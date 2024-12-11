package com.apirest.challenge.domain.topico;


import com.apirest.challenge.domain.topico.records.DatosActulizaTopico;
import com.apirest.challenge.domain.topico.records.DatosResgistroTopico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fecha;
    private boolean status;
    private String autor;
    @Enumerated(EnumType.STRING)
    private Curso curso;

    // Todos los getters y setters:

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public LocalDateTime getFehaDeCreacion() {
        return fecha;
    }

    public boolean isStatus() {
        return status;
    }

    public String getAutor() {
        return autor;
    }

    public Curso getCurso() {
        return curso;
    }


    // Todos los constructores (ya que no me funciona la anotacion de lombok)

    public Topico(DatosResgistroTopico dtoTopicos) {
        this.titulo = dtoTopicos.titulo();
        this.mensaje = dtoTopicos.mensaje();
        this.fecha = LocalDateTime.now();
        this.status = true;
        this.autor = dtoTopicos.autor();
        this.curso = dtoTopicos.curso();
    }

    public void actulizarTopico(DatosActulizaTopico dtoTopicos) {
        if (dtoTopicos.titulo() != null)
            this.titulo = dtoTopicos.titulo();

        if (dtoTopicos.autor() != null)
            this.autor = dtoTopicos.autor();

        if (dtoTopicos.mensaje() != null)
            this.mensaje = dtoTopicos.mensaje();

        if (dtoTopicos.curso() != null)
            this.curso = dtoTopicos.curso();

        if (dtoTopicos.fecha() != null)
            this.fecha = LocalDateTime.now();
    }
}
