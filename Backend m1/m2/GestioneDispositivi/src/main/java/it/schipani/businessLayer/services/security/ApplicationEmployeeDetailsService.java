package it.schipani.businessLayer.services.security;

import it.schipani.dataLayer.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApplicationEmployeeDetailsService implements UserDetailsService {

    @Autowired
    EmployeeRepository employees;


    @Override
    public UserDetails loadUserByUsername(String fullName) throws UsernameNotFoundException {
        var employee = employees.findOneByFullName(fullName).orElseThrow();
        return SecurityUserDetails.build(employee);
    }
}
