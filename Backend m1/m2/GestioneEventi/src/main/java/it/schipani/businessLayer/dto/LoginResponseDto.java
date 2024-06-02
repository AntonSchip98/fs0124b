package it.schipani.businessLayer.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class LoginResponseDto {

    private long id;
    private String username;
    private final List<String> roles;
    private String token;

    @Builder(setterPrefix = "with")
    public LoginResponseDto(long id, String username, String token, List<String> roles) {
        this.id = id;
        this.username = username;
        this.roles = roles;
        this.token = token;
    }
}
