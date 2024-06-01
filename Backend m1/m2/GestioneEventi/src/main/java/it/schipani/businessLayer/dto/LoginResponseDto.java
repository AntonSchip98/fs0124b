package it.schipani.businessLayer.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
/*
 Classe di trasferimento dati, utilizzata per rappresentare i dati di risposta di un tentativo
 * di login,  fornendo informazioni come l'identificatore dell'utente, il nome utente,
 * i ruoli assegnati e il token di autenticazione.
 * */
public class LoginResponseDto {
    private long id;
    private String username;
    private final List<String> roles;
    private String token;

    @Builder(setterPrefix = "with")
    public LoginResponseDto(long id, String username, List<String> roles, String token) {
        this.id = id;
        this.username = username;
        this.roles = roles;
        this.token = token;
    }
}
