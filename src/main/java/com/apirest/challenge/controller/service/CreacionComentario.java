package com.apirest.challenge.controller.service;

import com.apirest.challenge.domain.comentarios.Comentario;
import com.apirest.challenge.domain.comentarios.record.DatosMuestraComentario;
import com.apirest.challenge.domain.comentarios.record.DatosResgistroComentario;
import com.apirest.challenge.domain.comentarios.record.DatosRespuestaComentario;
import com.apirest.challenge.domain.topico.Topico;
import com.apirest.challenge.repository.ComentariosRepository;
import com.apirest.challenge.repository.TopicosRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CreacionComentario {

    private TopicosRepository topicosRepository;
    private ComentariosRepository comentariosRepository;


    public CreacionComentario(ComentariosRepository rComnetario, TopicosRepository rTopico) {
        this.comentariosRepository = rComnetario;
        this.topicosRepository = rTopico;
    }

    public DatosRespuestaComentario crearComentario(Long topicoId, DatosResgistroComentario datos) {
        // Verificar que el tópico existe
        Topico topico = topicosRepository.findById(topicoId)
                .orElseThrow(() -> new IllegalArgumentException("Tópico no encontrado con ID: " + topicoId));

        // se crea el comentario
        Comentario comentario = new Comentario(
                null, // ID generado automáticamente
                topico,
                datos.comentario(),
                datos.autor(),
                LocalDateTime.now()
        );

        // Guardar el comentario en la base de datos
        comentariosRepository.save(comentario);

        // Respueta personalizada en el insomnia
        DatosMuestraComentario comentarioPer = new DatosMuestraComentario(
                comentario.getComentario(),
                comentario.getAutor(),
                comentario.getFecha()
        );

        return new DatosRespuestaComentario(
                topico.getTitulo(), topico.getMensaje(), topico.getCurso(),
                comentarioPer

        );
    }

//    public Comentario crearComentario(Long topicoId, DatosResgistroComentario datos) {
//        // Verificar que el tópico existe
//        Topico topico = topicosRepository.findById(topicoId)
//                .orElseThrow(() -> new IllegalArgumentException("Tópico no encontrado con ID: " + topicoId));
//
//        // Crear el comentario
//        Comentario comentario = new Comentario(
//                null, // ID generado automáticamente
//                topico,
//                datos.comentario(),
//                datos.autor(),
//                LocalDateTime.now()
//        );
//
//        // Guardar el comentario en la base de datos
//        comentariosRepository.save(comentario);
//        return new DatosRespuestaComentario(
//                topico.getTitulo(), topico.getMensaje(), topico.getAutor(), topico.getCurso(),
//                comentario.getComentario(), comentario.getAutorComentario(), comentario.getFecha()
//        );
//    }

}
