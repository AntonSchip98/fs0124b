package it.schipani.businessLayer.services;

import it.schipani.dataLayer.entities.EventEntity;

public interface EventService {
    EventEntity createEvent(EventEntity eventEntity);
}
