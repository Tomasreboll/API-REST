package com.apirest.challenge.domain.comentarios;

import com.apirest.challenge.domain.topico.Topico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Table(name = "comentarios")
@Entity(name = "Comentario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topico_id")
    private Topico topico;
    private String comentario;
    private String autor;
    private LocalDateTime fecha;




    // Todos los getters y setter:

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTopico(Topico topico) {
        this.topico = topico;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }


    // Constructores
//    public Comentario(Long id, Topico topico, String comentario, String autor, LocalDateTime fecha) {
//        this.id = id;
//        this.topico = topico;
//        this.comentario = comentario;
//        this.autor = autor;
//        this.fecha = LocalDateTime.now();
//
//    }
}
