package com.apirest.challenge.domain.topico.errores;

public class TopicoError {
    
    private String mensaje;
    private Long id;

    public TopicoError(String mensaje, Long id){
        this.mensaje = mensaje;
        this.id = id;
    }

    //Getters y stters:

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
