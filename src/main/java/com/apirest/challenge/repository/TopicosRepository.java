package com.apirest.challenge.repository;

import com.apirest.challenge.domain.topico.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicosRepository extends JpaRepository<Topico, Long> {
}
