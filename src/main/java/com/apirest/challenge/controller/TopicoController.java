package com.apirest.challenge.controller;


import com.apirest.challenge.domain.topico.Topico;
import com.apirest.challenge.domain.topico.records.DatosResgistroTopico;
import com.apirest.challenge.domain.topico.records.DatosRespuestaTopico;
import com.apirest.challenge.repository.TopicosRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicosRepository topicosRepository;

    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> registrarTopico (@RequestBody @Valid DatosResgistroTopico dtotopicos, UriComponentsBuilder uriComponentsBuilder) {

        Topico topico = topicosRepository.save(new Topico(dtotopicos));
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(),
                topico.getAutor(), topico.getCurso());
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }

}
