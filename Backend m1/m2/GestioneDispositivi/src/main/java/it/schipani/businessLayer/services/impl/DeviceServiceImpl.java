package it.schipani.businessLayer.services.impl;

import it.schipani.businessLayer.services.DeviceService;
import it.schipani.businessLayer.services.exceptions.DeviceNotFoundException;
import it.schipani.dataLayer.entitys.Device;
import it.schipani.dataLayer.entitys.DeviceState;
import it.schipani.dataLayer.entitys.Employee;
import it.schipani.dataLayer.repositories.DeviceRepository;
import it.schipani.dataLayer.repositories.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    DeviceRepository devices;

    @Autowired
    EmployeeRepository employees;

    @Override
    public Optional<Device> createDevice(Device d) {
        return Optional.of(devices.save(d));
    }

    @Override
    public List<Device> getAllDevice() {
        return devices.findAll();
    }

    @Override
    public Optional<Device> getDevice(Long id) {
        return devices.findById(id);
    }

    @Override
    public Device updateDevice(Long id, @Validated Device e) {
        Optional<Device> existingDevicesOptional = devices.findById(id);
        if (existingDevicesOptional.isPresent()) {
            return devices.save(Device.builder()
                    .withType(e.getType())
                    .withState(e.getState())
                    .withEmployee(e.getEmployee())
                    .build());
        } else {
            throw new DeviceNotFoundException(List.of(new ObjectError("device", "Device not found with id " + id)));
        }
    }

    @Override
    public Device deleteDevice(Long id) {
        Optional<Device> device = devices.findById(id);
        if (device.isPresent()) {
            devices.deleteById(id);
            return device.get();
        } else {
            throw new DeviceNotFoundException(List.of(new ObjectError("device", "Device not found with id " + id)));
        }
    }

    public Device assignDeviceToEmployee(Long deviceId, Long employeeId) {
        Optional<Device> device = devices.findById(deviceId);
        Optional<Employee> employee = employees.findById(employeeId);

        if (device.isPresent() && employee.isPresent()) {
            Device assignedDevice = device.get();
            assignedDevice.setEmployee(employee.get());
            assignedDevice.setState(DeviceState.ASSIGNED);
            return devices.save(assignedDevice);
        } else {
            throw new DeviceNotFoundException(List.of(new ObjectError("device", "Device or Employee not found")));
        }
    }
}
