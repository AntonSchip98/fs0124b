package it.schipani;

import it.schipani.data.Reservation;
import it.schipani.data.Station;
import it.schipani.data.User;
import it.schipani.repositories.ReservationRepository;
import it.schipani.repositories.StationRepository;
import it.schipani.repositories.UserRepository;
import it.schipani.runner.BookingRunner;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ActiveProfiles("test")
@SpringBootTest
@Slf4j
class GestionePrenotazioniApplicationTests {
    private static AnnotationConfigApplicationContext ctx;


    @Autowired
    private ReservationRepository reservationRepo;

    @Autowired
    private StationRepository stationRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private BookingRunner bookingRunner;

    @BeforeAll
    public static void startUp() {
        ctx = new AnnotationConfigApplicationContext(GestionePrenotazioniApplication.class);

    }

    @Test
    void testMakeReservation() {
        // Creazione di un utente
        var user = User.builder()
                .withUsername("testuser")
                .withFullName("Test User")
                .withEmail("test@example.com")
                .build();
        userRepo.save(user);

        // Creazione di una stazione
        var station = Station.builder()
                .withUniqueCode("teststation")
                .withDescription("Test Station")
                .withMaxNumOccupants(5)
                .build();
        stationRepo.save(station);

        // Data per la prenotazione
        LocalDate date = LocalDate.now().plusDays(1);
        try {
            // Effettua la prenotazione
            Reservation reservation = Reservation.builder()
                    .withUser(user)
                    .withStation(station)
                    .withDate(date)
                    .build();
            reservationRepo.save(reservation);
        } catch (Exception e) {
            log.error("{}", e);
        }

        // Verifica che la prenotazione sia stata effettuata correttamente
        Optional<Reservation> savedReservationOpt = reservationRepo.findByUserAndStationAndDate(user, station, date);
        assertTrue(savedReservationOpt.isPresent());
    }


    @Test
    void testMakeReservationUnavailableStation() {
        // Creazione di un utente
        User user = User.builder()
                .withUsername("testuser")
                .withFullName("Test User")
                .withEmail("test@example.com")
                .build();
        userRepo.save(user);

        // Creazione di una stazione
        Station station = Station.builder()
                .withUniqueCode("teststation")
                .withDescription("Test Station")
                .withMaxNumOccupants(5)
                .build();
        stationRepo.save(station);

        // Prenotazione iniziale
        LocalDate date = LocalDate.now().plusDays(1);
        try {
            bookingRunner.makeReservation(user, station, date);
        } catch (Exception e) {
            log.error("Errore durante la prenotazione iniziale: {}", e);
        }

        // Tentativo di effettuare una seconda prenotazione per la stessa data e stazione
        try {
            bookingRunner.makeReservation(user, station, date);
            log.error("Dovrebbe essere stato sollevato un errore per stazione non disponibile.");
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("La postazione non è disponibile per quella data."));
        }
    }
}
