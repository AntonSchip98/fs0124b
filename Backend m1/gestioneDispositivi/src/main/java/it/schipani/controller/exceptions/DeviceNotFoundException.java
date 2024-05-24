package it.schipani.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;

import java.io.Serial;
import java.util.List;

public class DeviceNotFoundException extends ApiValidationException{
    @Serial
    private static final long serialVersionUID = 1L;

    public DeviceNotFoundException(List<ObjectError> errors) {
        super(errors, HttpStatus.NOT_FOUND, "Device non trovato");
    }
}
