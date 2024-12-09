package com.apirest.challenge.domain.topico.records;

import com.apirest.challenge.domain.topico.Curso;

public record DatosRespuestaTopico(

        Long id,
        String titulo,
        String mensaje,
        String autor,
        Curso curso) {
}
