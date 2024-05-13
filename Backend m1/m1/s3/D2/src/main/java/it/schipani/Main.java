package it.schipani;

import it.schipani.dao.EventDAO;
import it.schipani.dao.Evento;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        var evento1 = new Evento( "Park Life", new Date(1 - 5 - 2024), "Evento del primo maggio", 1000);
        EventDAO eventDAO = new EventDAO();
        /*eventDAO.save(evento1);*/
        eventDAO.getById(1L);

    }
}