package it.schipani.dataLayer.repositories;

import it.schipani.dataLayer.entities.AttendanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<AttendanceEntity, Long> {
}
