package com.apirest.challenge.domain.topico.records;

import com.apirest.challenge.domain.topico.Curso;

import java.time.LocalDateTime;

public record DatosActulizaTopico(
        String titulo,
        String mensaje,
        String autor,
        Curso curso,
        LocalDateTime fecha)
{

}
