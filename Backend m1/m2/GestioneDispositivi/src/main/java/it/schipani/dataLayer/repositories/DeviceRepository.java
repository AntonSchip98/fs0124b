package it.schipani.dataLayer.repositories;

import it.schipani.dataLayer.entitys.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Long> {
}
