package it.schipani.businessLayer.impl;

import it.schipani.businessLayer.services.EventService;
import it.schipani.dataLayer.entities.EventEntity;
import it.schipani.dataLayer.repositories.EventRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EventServiceImpl implements EventService {
    @Autowired
    private EventRepository eventRepository;

    @Override
    public EventEntity createEvent(EventEntity eventEntity) {
        try {
            // Salva l'evento nel database utilizzando il repository degli eventi
            EventEntity savedEvent = eventRepository.save(eventEntity);
            log.info("Event created successfully: {}", savedEvent);
            return savedEvent;
        } catch (Exception e) {
            // Gestione delle eccezioni nel caso in cui si verifichi un errore durante il salvataggio dell'evento
            log.error("Error creating event", e);
            throw new RuntimeException("Error creating event", e);
        }
    }
}
