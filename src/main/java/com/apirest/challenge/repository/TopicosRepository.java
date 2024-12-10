package com.apirest.challenge.repository;

import com.apirest.challenge.domain.topico.Curso;
import com.apirest.challenge.domain.topico.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface TopicosRepository extends JpaRepository<Topico, Long> {

    @Query("SELECT t FROM Topico t ORDER BY t.fecha ASC")
    List<Topico> findFirst10TopicsOrderedByCreationDate();

    @Query("SELECT t FROM Topico t WHERE "
            + "(:fecha IS NULL OR YEAR(t.fecha) = YEAR(:fecha)) "
            + "AND (:curso IS NULL OR t.curso = :curso)")
    List<Topico> findByYearAndCurso(@Param("fecha") LocalDateTime fecha, @Param("curso") Curso curso);

}
