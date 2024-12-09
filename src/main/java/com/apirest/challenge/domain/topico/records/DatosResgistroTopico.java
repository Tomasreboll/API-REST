package com.apirest.challenge.domain.topico.records;

import com.apirest.challenge.domain.topico.Curso;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosResgistroTopico(

        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotBlank
        String autor,
        @NotNull
        Curso curso,
        LocalDateTime fecha
) {
}
