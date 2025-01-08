package com.apirest.challenge.controller;

import com.apirest.challenge.controller.service.CreacionComentario;
import com.apirest.challenge.domain.comentarios.Comentario;
import com.apirest.challenge.domain.comentarios.record.DatosListaComentarios;
import com.apirest.challenge.domain.comentarios.record.DatosResgistroComentario;
import com.apirest.challenge.domain.comentarios.record.DatosRespuestaComentario;
import com.apirest.challenge.repository.ComentariosRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentario")
public class ComentarioController {

    @Autowired
    private ComentariosRepository comentariosRepository;
    @Autowired
    private CreacionComentario comentarioService;

    @PostMapping("/{topicoId}")
    public ResponseEntity resgistratComentario(@PathVariable Long topicoId, @Valid @RequestBody DatosResgistroComentario datos) {

        DatosRespuestaComentario comentario = comentarioService.crearComentario(topicoId, datos);
//        var comentario =comentariosRepository.save(datos);
        return ResponseEntity.ok(comentario);
    }

    @GetMapping("/todos/{topicoId}")
    public ResponseEntity<DatosListaComentarios> listarComentariosDelTopico(@PathVariable Long topicoId) {
        DatosListaComentarios lista = comentarioService.listarCompentariosPorTopico(topicoId);
        return ResponseEntity.ok(lista);
    }
}
