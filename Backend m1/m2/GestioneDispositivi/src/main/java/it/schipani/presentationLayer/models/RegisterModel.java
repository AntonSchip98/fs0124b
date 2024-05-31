package it.schipani.presentationLayer.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record RegisterModel(
        @NotBlank @Length(max = 125) String fullName, //
        @NotBlank @Length(max = 15) String password, //
        @NotBlank @Length(max = 25) @Email String email
) {
}
