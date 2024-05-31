package it.schipani.presentationLayer.models;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record LoginModel(
        @NotBlank @Length(max = 125) String fullName, //
        @NotBlank @Length(max = 15) String password
) {
}
