package com.apirest.challenge.domain.comentarios.record;

import com.apirest.challenge.domain.topico.Curso;

import java.util.List;

public record DatosListaComentarios(
        String titulo,
        String mensaje,
        Curso curso,
        List<DatosMuestraComentario> comentario

) {
}
