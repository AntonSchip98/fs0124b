package it.schipani.businessLayer.services.exceptions;

import java.io.Serial;

/*Questa classe rappresenta una situazione in cui si verifica un errore durante un tentativo
 di login, memorizzando le credenziali (username e password) che hanno causato l'errore. */
public class InvalidLoginException extends ServiceException{
    @Serial
    private static final long serialVersionUID = 1L;

    public final String username;
    public final String password;

    public InvalidLoginException(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
