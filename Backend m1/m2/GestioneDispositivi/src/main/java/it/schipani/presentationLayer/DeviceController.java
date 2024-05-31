package it.schipani.presentationLayer;

import it.schipani.businessLayer.services.exceptions.DeviceNotFoundException;
import it.schipani.businessLayer.services.impl.DeviceServiceImpl;

import it.schipani.dataLayer.entitys.Device;
import it.schipani.presentationLayer.models.DeviceValidationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {
    @Autowired
    DeviceServiceImpl services;

    @GetMapping
    public ResponseEntity<List<Device>> getAllDevices() {
        return new ResponseEntity<>(services.getAllDevice(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Device> getDeviceById(@PathVariable Long id) {
        Optional<Device> device = services.getDevice(id);
        return device.map(d ->
                new ResponseEntity<>(d, HttpStatus.OK)).orElseGet(() ->
                new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Device> createDevice(@RequestBody @Validated DeviceValidationRequest request) {
        Device device = Device.builder()
                .withType(request.type())
                .withState(request.state())
                /*.withEmployee(new Employee().setId(request.employeeId()))*/
                .build();

        Optional<Device> savedDevice = services.createDevice(device);
        return new ResponseEntity<>(savedDevice.get(), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Device> updateDevice(@PathVariable Long id, @RequestBody @Validated DeviceValidationRequest request) {
        try {
            Device deviceDetails = Device.builder()
                    .withType(request.type())
                    .withState(request.state())
                    /*.withEmployee(new Employee().setId(request.employeeId()))*/
                    .build();
            Device updatedDevice = services.updateDevice(id, deviceDetails);
            return ResponseEntity.ok(updatedDevice);
        } catch (DeviceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDevice(@PathVariable Long id) {
        services.deleteDevice(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{deviceId}/assign/{employeeId}")
    public ResponseEntity<Device> assignDeviceToEmployee(@PathVariable Long deviceId, @PathVariable Long employeeId) {
        try {
            Device assignedDevice = services.assignDeviceToEmployee(deviceId, employeeId);
            return ResponseEntity.ok(assignedDevice);
        } catch (ConfigDataResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
