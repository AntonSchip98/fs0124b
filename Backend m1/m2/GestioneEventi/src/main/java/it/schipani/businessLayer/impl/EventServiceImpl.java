package it.schipani.businessLayer.impl;

import it.schipani.businessLayer.EventService;

import it.schipani.dataLayer.entities.EventEntity;
import it.schipani.dataLayer.repositories.EventRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EventServiceImpl implements EventService {

    @Autowired
    EventRepository events;




    @Override
    public EventEntity createEvent(EventEntity event) {
        try {
            return events.save(event);
        } catch (Exception e) {
            log.error("Exception occurred while creating event", e);
            throw new RuntimeException("Error creating event");
        }
    }
}
