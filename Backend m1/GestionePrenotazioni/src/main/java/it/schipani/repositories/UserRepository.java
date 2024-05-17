package it.schipani.repositories;

import it.schipani.data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT COUNT(r) FROM Reservation r WHERE r.user = :user AND r.date = :date")
    int countReservationsForUserAndDate(@Param("user") User user, @Param("date") LocalDate date);
}
