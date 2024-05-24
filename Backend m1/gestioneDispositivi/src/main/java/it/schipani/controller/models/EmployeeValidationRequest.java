package it.schipani.controller.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EmployeeValidationRequest(
        @NotNull(message = "Il campo 'username' non può essere nullo")
        @NotBlank(message = "Il campo 'username' non può essere vuoto o composto solo da spazi")
        String username,

        @NotNull(message = "Il campo 'firstName' non può essere nullo")
        @NotBlank(message = "Il campo 'firstName' non può essere vuoto o composto solo da spazi")
        String firstName,

        @NotNull(message = "Il campo 'lastName' non può essere nullo")
        @NotBlank(message = "Il campo 'lastName' non può essere vuoto o composto solo da spazi")
        String lastName,

        @NotNull(message = "Il campo 'email' non può essere nullo")
        @NotBlank(message = "Il campo 'email' non può essere vuoto o composto solo da spazi")
        @Email(message = "Il campo 'email' deve essere un indirizzo email valido")
        String email
) {
}
