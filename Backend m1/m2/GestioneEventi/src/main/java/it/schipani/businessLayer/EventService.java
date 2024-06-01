package it.schipani.businessLayer;

import it.schipani.businessLayer.dto.EventDto;
import it.schipani.dataLayer.entities.EventEntity;

public interface EventService {
    EventEntity createEvent(EventEntity event);
}
