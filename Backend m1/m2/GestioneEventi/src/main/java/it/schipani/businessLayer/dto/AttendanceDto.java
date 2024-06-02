package it.schipani.businessLayer.dto;

import it.schipani.dataLayer.entities.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@Builder(setterPrefix = "with")
@AllArgsConstructor
public class AttendanceDto extends DtoBase{
    private Long userId;
    private Long eventId;
    private Status status;
}
