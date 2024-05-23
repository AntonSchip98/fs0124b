package it.schipani.controller.excpetions;

import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;

import java.io.Serial;
import java.util.List;

/* La classe ApiValidationException viene utilizzata per segnalare errori di validazione
 API all'interno dell'applicazione. Può essere lanciata quando vengono rilevati
errori di validazione e include dettagli sugli errori e lo stato HTTP appropriato.*/

public class ApiValidationException extends RuntimeException {
    @Serial
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
