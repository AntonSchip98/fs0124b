package it.schipani.businessLayer.services.dto;

import lombok.*;

@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Data
@Builder(setterPrefix = "with")
@AllArgsConstructor
@NoArgsConstructor
public class RegisterEmployeeDto extends DtoBase {
    private String fullName;
    private String password;
    private String email;
}
