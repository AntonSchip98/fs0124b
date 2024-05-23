package it.schipani.controller.excpetions;

import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;

import java.io.Serial;
import java.util.List;

public class UserNotFoundException extends ApiValidationException{
    @Serial
    private static final long serialVersionUID = 1L;

    public UserNotFoundException(List<ObjectError> errors) {
        super(errors, HttpStatus.NOT_FOUND, "User non trovato");
    }
}
