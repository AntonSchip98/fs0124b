package it.schipani.presentationLayer.exceptions;





import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.io.Serial;
import java.util.List;


/*questa eccezione divide gli errori di validazione dei campi di un model in due categorie:
errori sui campi specifici e altri tipi di errori di validazione. Questa suddivisione può essere
 utile per gestire e presentare gli errori in modo specifico nell'interfaccia utente
o nei log di sistema, consentendo una gestione più granulare degli errori di validazione.*/
public class FieldValidationException extends ValidationException {
    @Serial
    private static final long serialVersionUID = 1L;

    public final List<FieldError> errors;

    public final List<ObjectError> otherErrors;

    public FieldValidationException(List<ObjectError> errors) {
        this.errors = errors.stream().filter(a -> a instanceof FieldError).map(a -> (FieldError) a).toList();
        this.otherErrors = errors.stream().filter(a -> !(a instanceof FieldError)).toList();
    }
}
