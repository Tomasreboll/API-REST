package com.apirest.challenge.domain.topico;

public class FiltroTopico {

    private Integer anio;
    private String curso;

    // Getter Setters:
    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Integer getAnio() {
        return anio;
    }

    public String getCurso() {
        return curso;
    }
}
