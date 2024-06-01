package it.schipani.presentationLayer.models;

import jakarta.validation.constraints.NotNull;

public record RoleModel(
        @NotNull String name
) {
}
