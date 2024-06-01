package it.schipani.businessLayer.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EventDto {

    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String description;

    @Builder(setterPrefix = "with")
    public EventDto(String name, LocalDateTime startDate, LocalDateTime endDate, String description) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }
}
