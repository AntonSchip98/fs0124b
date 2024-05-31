package it.schipani.businessLayer.services;

import it.schipani.dataLayer.entitys.Device;

import java.util.List;
import java.util.Optional;

public interface DeviceService {
    Optional<Device> createDevice(Device d);

    List<Device> getAllDevice();


    Optional<Device> getDevice(Long id);

    Device updateDevice(Long id, Device e);

    Device deleteDevice(Long id);
}
