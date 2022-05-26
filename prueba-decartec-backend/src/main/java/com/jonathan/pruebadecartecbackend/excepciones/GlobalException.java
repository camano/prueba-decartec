package com.jonathan.pruebadecartecbackend.excepciones;

import com.jonathan.pruebadecartecbackend.dto.MensajeDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.RestClientException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PaisException.class)
    public ResponseEntity<MensajeDto> manejarMercanciaException(PaisException mercanciaException, WebRequest webRequest) {

        MensajeDto mensajeDto = new MensajeDto(mercanciaException.getMensaje());

        return new ResponseEntity<>(mensajeDto, mercanciaException.getEstado());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MensajeDto> manejarGlobalException(Exception exception, WebRequest webRequest) {

        MensajeDto mensajeDto = new MensajeDto(exception.getMessage());
        return new ResponseEntity<>(mensajeDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RestClientException.class)
    public ResponseEntity<MensajeDto> manejarGlobalException(RestClientException exception, WebRequest webRequest) {
        MensajeDto mensajeDto = new MensajeDto(exception.getMessage());
        return new ResponseEntity<>(mensajeDto, HttpStatus.BAD_REQUEST);
    }
}
