package it.schipani.repositories;

import it.schipani.data.Reservation;
import it.schipani.data.Station;
import it.schipani.data.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Optional<Reservation> findByUserAndStationAndDate(User user, Station station, LocalDate date);
}
