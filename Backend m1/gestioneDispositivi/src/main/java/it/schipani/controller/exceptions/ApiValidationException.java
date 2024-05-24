package it.schipani.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;

import java.util.List;

public class ApiValidationException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public final List<ObjectError> errors;
    public final HttpStatus status;

    public ApiValidationException(List<ObjectError> errors) {
        this(errors, HttpStatus.SERVICE_UNAVAILABLE, "Api validation failed");
    }

    public ApiValidationException(List<ObjectError> errors, HttpStatus status, String message) {
        super(message);
        this.errors = errors;
        this.status = status;
    }
}
