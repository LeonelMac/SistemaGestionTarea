package com.prueba.tenica.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class AccionNoPermitidaException extends RuntimeException {
    public AccionNoPermitidaException(String mensaje) {
        super(mensaje);
    }
}
