package it.schipani.presentationLayer;

import it.schipani.businessLayer.EventService;
import it.schipani.businessLayer.UserService;
import it.schipani.businessLayer.dto.EventDto;
import it.schipani.dataLayer.entities.EventEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/events")
public class EventController {
    @Autowired
    private EventService eventService;

    @Autowired
    private UserService userService;


    @PostMapping
    public ResponseEntity<EventEntity> createEvent(@RequestBody EventEntity event, Authentication authentication) {
        // Verifica se l'utente è autenticato
        if (authentication != null && authentication.isAuthenticated()) {
            // Ottieni il nome dell'utente autenticato
            String username = authentication.getName();
            // Verifica se l'utente ha un ruolo di EntityManager
            if (userService.hasRole(username, "EventManager")) {
                // L'utente ha il ruolo richiesto, quindi crea l'evento
                EventEntity createdEvent = eventService.createEvent(event);
                return ResponseEntity.status(HttpStatus.CREATED).body(createdEvent);
            } else {
                // L'utente non ha il ruolo richiesto, restituisci un errore 403 Forbidden
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
        } else {
            // L'utente non è autenticato, restituisci un errore 401 Unauthorized
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
