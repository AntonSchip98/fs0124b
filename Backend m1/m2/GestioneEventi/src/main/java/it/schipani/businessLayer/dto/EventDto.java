package it.schipani.businessLayer.dto;

import it.schipani.dataLayer.entities.EventEntity;
import it.schipani.dataLayer.entities.EventType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@Builder(setterPrefix = "with")
@AllArgsConstructor
public class EventDto extends DtoBase{
    private String eventTitle;
    private LocalDateTime publishedAt;
    private String eventDescription;
    private EventType type;
    private int maxAttendance;
    private String location;


}
