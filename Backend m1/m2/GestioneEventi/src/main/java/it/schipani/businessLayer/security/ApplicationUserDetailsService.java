package it.schipani.businessLayer.security;

import it.schipani.dataLayer.repositories.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
// Servizio di recupero di un utente tramite le procedure di gestione utente di Spring Security
public class ApplicationUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository users;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = users.findOneByUsername(username).orElseThrow();
        return SecurityUserDetails.build(user);
    }
}
