package com.apirest.challenge.controller;


import com.apirest.challenge.domain.topico.errores.TopicoError;
import com.apirest.challenge.domain.topico.Curso;
import com.apirest.challenge.domain.topico.FiltroTopico;
import com.apirest.challenge.domain.topico.Topico;
import com.apirest.challenge.domain.topico.records.*;
import com.apirest.challenge.repository.TopicosRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicosRepository topicosRepository;

    // Metodo para registrar topicos
    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> registrarTopico (@RequestBody @Valid DatosResgistroTopico dtotopicos, UriComponentsBuilder uriComponentsBuilder) {

        Topico topico = topicosRepository.save(new Topico(dtotopicos));
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(),
                topico.getAutor(), topico.getCurso());
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }

    // Metodo para listar los primeros 10 topicos existentes por fecha ASC:
    @GetMapping("/first10")
    public ResponseEntity<Page<DatosListaTopicos>> listarFirst10Topicos(@PageableDefault(size = 10) Pageable paginacion) {
        List<Topico> topicos = topicosRepository.findFirst10TopicsOrderedByCreationDate();
        Page<Topico> page = new PageImpl<>(topicos, paginacion, topicos.size());
        return ResponseEntity.ok(page.map(DatosListaTopicos::new));
    }

    // Metodo para listar todos los topicos existentes con paginacion 3:
    @GetMapping
    public ResponseEntity<Page<DatosListaTopicos>> listarTopicos(@PageableDefault(size = 3) Pageable paginacion) {
        return ResponseEntity.ok(topicosRepository.findAll(paginacion).map(DatosListaTopicos::new));
    }

    // Metodo para que el listado sea mediante una busqueda personalizada:
    @GetMapping("/busqueda")
    public ResponseEntity<List<DatosListaTopicos>> listaPorBusqueda(@RequestBody FiltroTopico filtro) {
        LocalDateTime fecha = null;
        if (filtro.getAnio() != null){
            fecha = LocalDateTime.of(filtro.getAnio(), 1,1,0,0,0,0);
        }
        Curso cursoEnum = null;
        if (filtro.getCurso() != null) {
            try {
                cursoEnum = Curso.valueOf(filtro.getCurso().toUpperCase());
            } catch (IllegalArgumentException e) {
                return ResponseEntity.badRequest().body(null);
            }
        }
        List<Topico> topicos = topicosRepository.findByYearAndCurso(fecha,cursoEnum);
        List<DatosListaTopicos> datos = topicos.stream()
                .map(DatosListaTopicos::new).toList();
        return ResponseEntity.ok(datos);
    }

    // Para obeter un topico por el id:
    @GetMapping("/{id}")
    public ResponseEntity <Object> listarPorId(@PathVariable Long id) {
        Optional<Topico> optionalTopico = topicosRepository.findById(id);
        if (optionalTopico.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new TopicoError("La ID buscada no existe", id));
        }
        Topico t = optionalTopico.get();
        var datosPorId = new DatosRespuestaTopicoId(t.getTitulo(), t.getMensaje(), t.getAutor(),
                t.getFehaDeCreacion(), t.isStatus(), t.getCurso());
        return ResponseEntity.ok(datosPorId);
    }

    // Para actulizar un topico
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity actulizarTopico(@RequestBody @Valid DatosActulizaTopico datos, @PathVariable Long id) {
        Optional<Topico> optionalTopico = topicosRepository.findById(id);
        if (optionalTopico.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new TopicoError("La ID buscada no existe", id));
        }

        Topico topico = optionalTopico.get();
        topico.actulizarTopico(datos);
        return ResponseEntity.ok(new DatosActulizaTopico(topico.getTitulo(), topico.getMensaje(),
                topico.getAutor(), topico.getCurso(), topico.getFehaDeCreacion()));

    }

}
