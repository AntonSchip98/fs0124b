package it.schipani.controller.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

/*i record Java sono una sintassi concisa per dichiarare  classi immutabili che contengono solo dati*/
/*Questo record MessageRequest rappresenta una struttura dati immutabile che contiene le informazioni di un post,
* */
public record PostRequest(

        @NotBlank(message = "La categoria non può essere vuota")
        @Size(max = 80, message = "La categoria non può essere più lunga di 80 caratteri")
        String category,

        @NotBlank(message = "Il titolo non può essere vuoto")
        String title,

        @Size(max = 80, message = "La copertina non può essere più lunga di 80 caratteri")
        String cover,

        @Size(max = 2048, message = "Il contenuto non può superare i 2048 caratteri")
        String content,

        @NotNull(message = "Il tempo di lettura non può essere nullo")
        Double lectureTime,

        @NotNull(message = "L'ID dell'utente non può essere omesso")
        Long userId,

        @NotBlank(message = "Il nome dell'utente non può essere vuoto")
        @Size(max = 80, message = "Il nome dell'utente non può essere più lungo di 80 caratteri")
        String userFirstName,

        @NotBlank(message = "Il cognome dell'utente non può essere vuoto")
        @Size(max = 80, message = "Il cognome dell'utente non può essere più lungo di 80 caratteri")
        String userLastName,

        @NotBlank(message = "L'email dell'utente non può essere vuota")
        @Email(message = "L'indirizzo email non è valido")
        @Size(max = 100, message = "L'email non può essere più lunga di 100 caratteri")
        String userEmail,

        @NotNull(message = "La data di nascita dell'utente non può essere nulla")
        LocalDate userBirthDate,

        @Size(max = 80, message = "L'avatar dell'utente non può essere più lungo di 80 caratteri")
        String userAvatar
)
{}
