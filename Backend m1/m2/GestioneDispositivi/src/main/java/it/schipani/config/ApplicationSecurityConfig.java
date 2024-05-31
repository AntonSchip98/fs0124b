package it.schipani.config;

import it.schipani.businessLayer.services.security.ApplicationEmployeeDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

public class ApplicationSecurityConfig {
    @Bean
    PasswordEncoder stdPasswordEncoder() {
        return new BCryptPasswordEncoder(11);
    }


    @SuppressWarnings("removal")
    @Bean
    AuthenticationManager authenticationManager(HttpSecurity http, //
                                                PasswordEncoder passwordEncoder, UserDetailsService userDetailsService) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class) //
                .userDetailsService(userDetailsService) //
                .passwordEncoder(passwordEncoder) //
                .and().build();
    }

    @Bean
    SecurityFilterChain web(HttpSecurity http) throws Exception {
        http //
                //.cors(c -> corsConfigurationSource())
                .csrf(c -> c.disable()) //
                .authorizeHttpRequests(authorize -> //
                        authorize //
                                .requestMatchers(HttpMethod.POST).permitAll() //
                                .anyRequest().authenticated()) //
                .httpBasic(Customizer.withDefaults()) //
                .sessionManagement(sm -> //
                        sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        ;

        return http.build();
    }

}
