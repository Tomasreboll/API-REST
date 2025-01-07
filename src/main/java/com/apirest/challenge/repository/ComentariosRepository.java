package com.apirest.challenge.repository;

import com.apirest.challenge.domain.comentarios.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentariosRepository extends JpaRepository <Comentario, Long> {

}
