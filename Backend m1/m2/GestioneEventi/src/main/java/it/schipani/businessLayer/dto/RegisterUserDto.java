package it.schipani.businessLayer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@Builder(setterPrefix = "with")
@AllArgsConstructor
/* questo DTO verrà utilizzato per trasferire i dati relativi alla registrazione di un nuovo utente da e
verso i vari strati dell'applicazione(business layer o presentation layer)*/
public class RegisterUserDto extends DtoBase {

    /*Nome utente del nuovo utente che sta per registrarsi.*/
    private String username;
    /*Password del nuovo utente.*/
    private String password;
    /*Ruoli associati al nuovo utente.*/
    private String roles;

}
