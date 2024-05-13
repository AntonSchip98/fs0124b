package it.schipani;

import it.schipani.dao.JpaEventoDao;
import it.schipani.dao.JpaLocationDao;
import it.schipani.dao.JpaParticipationDao;
import it.schipani.dao.JpaPeopleDao;
import it.schipani.entity.*;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        var evento1 = new Evento("Veglione", new Date(-2024), "Evento di capodanno", 1000);


        var people1 = new People("Mario", "Varano", "mario.varano@email.it", new Date(1985, 7, 15), Sex.M);
        var participation1 = new Participation(people1, evento1, ParticipationState.CONFIRMED);
        var location1 = new Location("Capannone", "Sersale");

        var eventDao = new JpaEventoDao();
        var peopleDao = new JpaPeopleDao();
        var participationDao = new JpaParticipationDao();
        var locationDao = new JpaLocationDao();


        participationDao.save(participation1);
/*
        peopleDao.save(people1);
*/

/*
        locationDao.save(location1);
*//*dao.save(evento1);*/

    }
}