package com.apirest.challenge.domain.topico.records;

import com.apirest.challenge.domain.topico.Curso;
import com.apirest.challenge.domain.topico.Topico;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDateTime;

public record DatosListaTopicos(

        String titulo,
        String mensaje,
        LocalDateTime fecha,
        String autor,
        Curso curso,
        boolean status
) {
public DatosListaTopicos (Topico t) {
    this(t.getTitulo(), t.getMensaje(), t.getFehaDeCreacion(), t.getAutor(), t.getCurso(), t.isStatus());
}
}
