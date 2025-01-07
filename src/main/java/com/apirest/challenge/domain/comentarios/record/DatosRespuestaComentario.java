package com.apirest.challenge.domain.comentarios.record;

import com.apirest.challenge.domain.topico.Curso;

import java.time.LocalDateTime;

public record DatosRespuestaComentario(
        String titulo,
        String mensaje,
        Curso curso,
        DatosMuestraComentario comentario

) {
}


//,
//String comentario,
//String autor,
//LocalDateTime fecha
