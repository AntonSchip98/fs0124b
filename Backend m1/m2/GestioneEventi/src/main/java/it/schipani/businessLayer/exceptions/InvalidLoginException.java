package it.schipani.businessLayer.exceptions;


import java.io.Serial;

public class InvalidLoginException extends ServiceException {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Username.
     */
    public final String username;
    /**
     * Password.
     */
    public final String password;

    public InvalidLoginException(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
