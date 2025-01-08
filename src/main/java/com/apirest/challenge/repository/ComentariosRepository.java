package com.apirest.challenge.repository;

import com.apirest.challenge.domain.comentarios.Comentario;
import com.apirest.challenge.domain.topico.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComentariosRepository extends JpaRepository <Comentario, Long> {

    List<Comentario> findByTopico(Topico topico);
}
