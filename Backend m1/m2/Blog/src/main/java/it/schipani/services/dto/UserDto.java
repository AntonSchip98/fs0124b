package it.schipani.services.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")
public class UserDto {
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate birthDate;
    private String avatar;

}
