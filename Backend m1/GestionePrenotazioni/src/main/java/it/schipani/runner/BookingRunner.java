package it.schipani.runner;

import it.schipani.data.*;
import it.schipani.repositories.BuildingRepository;
import it.schipani.repositories.ReservationRepository;
import it.schipani.repositories.StationRepository;
import it.schipani.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;


@Component
@Slf4j
public class BookingRunner implements CommandLineRunner {

    @Autowired
    StationRepository stationRepo;

    @Autowired
    UserRepository userRepo;

    @Autowired
    BuildingRepository buildingRepo;

    @Autowired
    ReservationRepository reservationRepo;


    @Override
    public void run(String... args) throws Exception {
        createUsers();
        createBuildings();
        createStations();

        User user = userRepo.findById(1L).orElseThrow(() -> new Exception("Utente non trovato"));
        Station station = stationRepo.findById(1L).orElseThrow(() -> new Exception("Postazione non trovata"));
        LocalDate date = LocalDate.now().plusDays(1);

        try {
            makeReservation(user, station, date);
            System.out.println("Prenotazione effettuata con successo per l'utente " + user.getUsername());
        } catch (Exception e) {
            System.err.println("Impossibile effettuare la prenotazione: " + e.getMessage());
        }

        // Esegui altre prenotazioni di test
        createReservations();
    }
    private void createUsers() {
        for (int i = 1; i <= 10; i++) {
            userRepo.save(User.builder()
                    .withUsername("username" + i)
                    .withFullName("Nome Cognome" + i)
                    .withEmail("email" + i + "@example.com")
                    .build());
        }
    }

    private void createBuildings() {
        for (int i = 1; i <= 10; i++) {
            buildingRepo.save(Building.builder()
                    .withName("Nome Edificio" + i)
                    .withAddress("Indirizzo Edificio" + i)
                    .withCity("Città" + i)
                    .build());
        }
    }

    private void createStations() {
        List<Building> buildings = buildingRepo.findAll();
        Random random = new Random();
        for (int i = 1; i <= 10; i++) {
            Building building = buildings.get(random.nextInt(buildings.size()));
            stationRepo.save(Station.builder()
                    .withUniqueCode("codice" + i)
                    .withDescription("Descrizione" + i)
                    .withStationType(StationType.PRIVATE)
                    .withMaxNumOccupants(5)
                    .withBuilding(building)
                    .build());
        }
    }

    public  void makeReservation(User user, Station station, LocalDate date) throws Exception {
        if (!isStationAvailable(station, date)) {
            throw new Exception("La postazione non è disponibile per quella data.");
        }

        if (hasReservationForDate(user, date)) {
            throw new Exception("Hai già una prenotazione per questa data.");
        }

        reservationRepo.save(Reservation.builder()
                .withUser(user)
                .withStation(station)
                .withDate(date)
                .build());
    }

    private boolean isStationAvailable(Station station, LocalDate date) {
        int count = stationRepo.countReservationsForStationAndDate(station, date);
        return count == 0;
    }

    private boolean hasReservationForDate(User user, LocalDate date) {
        int count = userRepo.countReservationsForUserAndDate(user, date);
        return count > 0;
    }

    private void createReservations() {
        List<User> users = userRepo.findAll();
        List<Station> stations = stationRepo.findAll();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            User user = users.get(random.nextInt(users.size()));
            Station station = stations.get(random.nextInt(stations.size()));
            LocalDate date = LocalDate.now().plusDays(random.nextInt(30));
            try {
                makeReservation(user, station, date);
                System.out.println("Prenotazione effettuata con successo per l'utente " + user.getUsername() + " per la postazione " + station.getUniqueCode());
            } catch (Exception e) {
                System.err.println("Impossibile effettuare la prenotazione per l'utente " + user.getUsername() + ": " + e.getMessage());
            }
        }
    }
}
