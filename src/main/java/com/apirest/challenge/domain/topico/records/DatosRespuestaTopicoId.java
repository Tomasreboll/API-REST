package com.apirest.challenge.domain.topico.records;

import com.apirest.challenge.domain.topico.Curso;

import java.time.LocalDateTime;

public record DatosRespuestaTopicoId(


        String titulo,
        String mensaje,
        String autor,
        LocalDateTime fecha,
        Boolean status,
        Curso curso) {
}
