package com.apirest.challenge.controller.service;

import com.apirest.challenge.domain.comentarios.Comentario;
import com.apirest.challenge.domain.comentarios.record.DatosListaComentarios;
import com.apirest.challenge.domain.comentarios.record.DatosMuestraComentario;
import com.apirest.challenge.domain.comentarios.record.DatosResgistroComentario;
import com.apirest.challenge.domain.comentarios.record.DatosRespuestaComentario;
import com.apirest.challenge.domain.topico.Topico;
import com.apirest.challenge.repository.ComentariosRepository;
import com.apirest.challenge.repository.TopicosRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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

        // Respueta personalizada en el insomnia para que muestre el topico y en una llave aparte el comentario.
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

    public DatosListaComentarios listarCompentariosPorTopico(Long topicoId) {
        // Verificar que el topico exista
        Topico topico = topicosRepository.findById(topicoId)
                .orElseThrow(() -> new IllegalArgumentException("Tópico no encontrado con ID: " + topicoId));

        // Realizar la busqueda de todos los comentarios x topico
        List<Comentario> comentarios = comentariosRepository.findByTopico(topico);

        // Mapear lo comentarios al record

        List<DatosMuestraComentario> datosMuestraComentarios = comentarios.stream()
                .map(c -> new DatosMuestraComentario(
                        c.getComentario(), c.getAutor(), c.getFecha()
                )).toList();

        return new DatosListaComentarios(
                topico.getTitulo(), topico.getMensaje(), topico.getCurso(),
                datosMuestraComentarios
        );

    }

}
