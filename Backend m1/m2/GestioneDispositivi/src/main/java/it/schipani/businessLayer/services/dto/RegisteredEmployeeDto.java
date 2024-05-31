package it.schipani.businessLayer.services.dto;

import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")
public class RegisteredEmployeeDto extends DtoBase{
    private long id;
    private String email;
    private String fullName;
    private List<String> devices;
}
