package it.schipani.controller.models;

import it.schipani.entities.DeviceState;
import it.schipani.entities.DeviceType;
import jakarta.validation.constraints.NotNull;

public record DeviceValidationRequest(
        @NotNull(message = "Il campo 'type' non può essere nullo")
        DeviceType type,

        @NotNull(message = "Il campo 'state' non può essere nullo")
        DeviceState state,

        @NotNull(message = "L'ID dell'employee non può essere nullo")
        Long employeeId
) {
}
