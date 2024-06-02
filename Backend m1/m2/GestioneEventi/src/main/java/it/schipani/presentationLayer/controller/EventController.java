package it.schipani.presentationLayer.controller;

import it.schipani.businessLayer.dto.EventDto;
import it.schipani.businessLayer.services.EventService;
import it.schipani.config.JwtUtils;
import it.schipani.dataLayer.entities.EventEntity;
import it.schipani.presentationLayer.exceptions.FieldValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("api/events")
@Slf4j
public class EventController {

    @Autowired
    private EventService events;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping
    public ResponseEntity<?> createEvent(@RequestBody @Validated EventDto eventDto, BindingResult validation, UriComponentsBuilder uri) {
        if (validation.hasErrors()) {
            throw new FieldValidationException(validation.getAllErrors());
        }

        try {
            // Creare l'oggetto EventEntity dal DTO
            EventEntity eventEntity = EventEntity.builder()
                    .withEventTitle(eventDto.getEventTitle())
                    .withPublishedAt(eventDto.getPublishedAt())
                    .withEventDescription(eventDto.getEventDescription())
                    .withType(eventDto.getType())
                    .withMaxAttendance(eventDto.getMaxAttendance())
                    .withLocation(eventDto.getLocation())
                    .build();

            // Chiama il metodo createEvent del service per creare un nuovo evento
            EventEntity createdEvent = events.createEvent(eventEntity);

            // Restituisci una risposta HTTP 201 (CREATED) con l'evento appena creato nel corpo della risposta
            HttpHeaders headers = new HttpHeaders();
            headers.add("Location", uri.path("/events/{id}").buildAndExpand(createdEvent.getId()).toString());
            return new ResponseEntity<>(createdEvent, headers, HttpStatus.CREATED);
        } catch (Exception e) {
            // Gestione delle eccezioni nel caso in cui si verifichi un errore durante la creazione dell'evento
            log.error("Error creating event", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating event");
        }
    }

}
