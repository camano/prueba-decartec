package com.jonathan.pruebadecartecbackend.excepciones;

import org.springframework.http.HttpStatus;

public class PaisException extends RuntimeException{
    private HttpStatus estado;
    private String mensaje;


    public PaisException(HttpStatus estado, String mensaje) {
        this.estado = estado;
        this.mensaje = mensaje;
    }

    public HttpStatus getEstado() {
        return estado;
    }

    public void setEstado(HttpStatus estado) {
        this.estado = estado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
