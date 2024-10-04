package com.prueba.tenica.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ManejadorExcepcionesGlobal {

    // Manejo de recurso no encontrado
    @ExceptionHandler(RecursoNoEncontradoException.class)
    public ResponseEntity<String> manejarRecursoNoEncontrado(RecursoNoEncontradoException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    // Manejo de datos inválidos
    @ExceptionHandler(DatosInvalidosException.class)
    public ResponseEntity<String> manejarDatosInvalidos(DatosInvalidosException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // Manejo de acción no permitida
    @ExceptionHandler(AccionNoPermitidaException.class)
    public ResponseEntity<String> manejarAccionNoPermitida(AccionNoPermitidaException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.FORBIDDEN);
    }

    // Manejo de estado inválido
    @ExceptionHandler(EstadoInvalidoException.class)
    public ResponseEntity<String> manejarEstadoInvalido(EstadoInvalidoException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
