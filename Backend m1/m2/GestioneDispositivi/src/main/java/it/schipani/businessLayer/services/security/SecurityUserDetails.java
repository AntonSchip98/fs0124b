package it.schipani.businessLayer.services.security;

import it.schipani.dataLayer.entitys.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.util.Collection;


@Data
@AllArgsConstructor
@Builder(setterPrefix = "with")
/*questa classe implementa l'interfaccia UserDetails di spring security e serve
* a rappresentare i dettagli di un utente per scopi di autenticazione e autorizzazione*/
public class SecurityUserDetails implements UserDetails {
    @Serial
    private static final long serialVersionUID = 1L;

    private Collection<? extends GrantedAuthority> authorities;
    private String password;
    private String username;
    @Builder.Default
    private boolean accountNonExpired = true;
    @Builder.Default
    private boolean accountNonLocked = true;
    @Builder.Default
    private boolean credentialsNonExpired = true;
    @Builder.Default
    private boolean enabled = true;

    public static SecurityUserDetails build(Employee employee) {
        var authorities = employee.getDevices().stream() //
                .map(d -> new SimpleGrantedAuthority(d.getType().toString()))
                .toList();
        return SecurityUserDetails.builder() //
                .withUsername(employee.getFullName()) //
                .withPassword(employee.getPassword()) //
                .withAuthorities(authorities) //
                .build();
    }
}
