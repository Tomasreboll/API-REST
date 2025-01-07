package com.apirest.challenge.domain.comentarios.record;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record DatosMuestraComentario(
        String comentario,
        String autor,
        LocalDateTime fecha
) {
}
