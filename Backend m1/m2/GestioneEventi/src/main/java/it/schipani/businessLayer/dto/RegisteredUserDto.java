package it.schipani.businessLayer.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
/*DTO (Data Transfer Object) utilizzato per rappresentare i dati di un utente già registrato nel
 sistema*/
public class RegisteredUserDto {
    /*attributi relativi all utente gia registratp*/
    private long id;
    private String username;
    private final List<String> roles;

    @Builder(setterPrefix = "with")
    public RegisteredUserDto(long id, String username, List<String> roles) {
        this.id = id;
        this.username = username;
        this.roles = roles;
    }
}

