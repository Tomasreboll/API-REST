package com.apirest.challenge.domain.comentarios.record;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record DatosResgistroComentario(

        @NotBlank
        String comentario,
        @NotBlank
        String autor,
        LocalDateTime fecha

) {
}
