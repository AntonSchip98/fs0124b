package it.team2.services;

import java.util.UUID;

public class TicketCodeGeneratorService {

    public String generateTicketCode() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 10);
    }
}
