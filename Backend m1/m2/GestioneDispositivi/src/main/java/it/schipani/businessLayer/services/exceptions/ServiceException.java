package it.schipani.businessLayer.services.exceptions;

import java.io.Serial;

/*Estendendo RuntimeException, ServiceException è un tipo di eccezzione non controllata
 *Le eccezioni non controllate non richiedono di essere dichiarate nel metodo con throws e possono
 *  essere lanciate durante l'esecuzionedel programma senza essere necessariamente catturate
 *  o dichiarate.*/
public class ServiceException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    /*Costruttore di default che chiama il costruttore di default della classe RuntimeException*/
    public ServiceException() {
        super();
    }

    /* Costruttore che permette di specificare un messaggio di errore, una causa, la possibilità
     di sopprimere l'eccezione e se lo stack trace è scrivibile.
     Chiama il corrispondente costruttore della classe RuntimeException*/
    public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    /*Costruttore che permette di specificare un messaggio di errore e una causa. Chiama il
     corrispondente costruttore della classe RuntimeException*/
    public ServiceException(String message, Throwable cause){
        super(message, cause);
    }

    /* Costruttore che permette di specificare un messaggio di errore. Chiama il corrispondente
    costruttore della classe RuntimeException*/
    public ServiceException(String message) {
        super(message);
    }

    /* Costruttore che permette di specificare una causa. Chiama il corrispondente costruttore
     della classe RuntimeException*/
    public ServiceException(Throwable cause) {
        super(cause);
    }
}
