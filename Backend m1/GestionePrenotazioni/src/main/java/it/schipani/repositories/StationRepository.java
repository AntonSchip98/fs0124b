package it.schipani.repositories;

import it.schipani.data.Station;

import it.schipani.data.StationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface StationRepository extends JpaRepository<Station, Long> {

    @Query("SELECT COUNT(r) FROM Reservation r WHERE r.station = :station AND r.date = :date")
    int countReservationsForStationAndDate(@Param("station") Station station, @Param("date") LocalDate date);

    List<Station> findByBuildingCityAndStationTypeAndAvailable(String buildingCity, StationType stationType, Boolean available);
}
