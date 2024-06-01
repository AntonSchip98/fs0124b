package it.schipani.presentationLayer.exceptions;

import java.io.Serial;

/* Questa classe fornisce una serie di costruttori per creare eccezioni
di validazione con diversi messaggi e/o cause. Può essere estesa da classi specifiche di domini
 o applicazione percreare eccezioni di validazione più specifiche, come FieldValidationException.*/
public class ValidationException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;

    /*Ogni costruttore chiama il costruttore corrispondente nella classe base RuntimeException,
     che è la classe base per le eccezioni non verificate in Java. Inoltre, il costruttore
      con causa chiama anche il costruttore della classe base con la causa specificata.*/

    public ValidationException() {
        super();
    }

    public ValidationException(String message, Throwable cause,
                               boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }


    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(Throwable cause) {
        super(cause);
    }
}
