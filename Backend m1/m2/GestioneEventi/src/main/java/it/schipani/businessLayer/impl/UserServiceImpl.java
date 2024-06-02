package it.schipani.businessLayer.impl;

import it.schipani.businessLayer.dto.LoginResponseDto;
import it.schipani.businessLayer.dto.RegisterUserDto;
import it.schipani.businessLayer.dto.RegisteredUserDto;
import it.schipani.businessLayer.exceptions.InvalidLoginException;
import it.schipani.businessLayer.exceptions.PersistEntityException;
import it.schipani.businessLayer.services.Mapper;
import it.schipani.businessLayer.services.UserService;
import it.schipani.config.JwtUtils;
import it.schipani.dataLayer.entities.RoleEntity;
import it.schipani.dataLayer.entities.UserEntity;
import it.schipani.dataLayer.repositories.RoleRepository;
import it.schipani.dataLayer.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@Slf4j
/*questo service è un'implementazione dello UserService che fornisce metodi per la registrazione,
 login e recupero delle informazioni di un utente. */
public class UserServiceImpl implements UserService {
    @Autowired
    PasswordEncoder encoder;

    @Autowired
    UserRepository users;
    @Autowired
    private RoleRepository roles;

    @Autowired
    private AuthenticationManager auth;

    @Autowired
    private JwtUtils jwt;

    @Autowired
    Mapper<RegisterUserDto, UserEntity> mapEntity;
    @Autowired
    Mapper<UserEntity, RegisteredUserDto> mapRegisteredUser;
    @Autowired
    Mapper<UserEntity, LoginResponseDto> mapLogin;


    @Override
    public RegisteredUserDto register(RegisterUserDto user) {
        try {
            var u = mapEntity.map(user);
            var p = encoder.encode(user.getPassword());
            log.info("Password encrypted: {}", p);
            u.setPassword(p);
            if (user.getRoles() != null)
                Stream.of(user.getRoles().split(",")).forEach(r ->{
                    // Cerca il ruolo nel database con lo stesso nome
                    RoleEntity role = roles.findOneByName(r).orElse(null);
                    if (role != null) {
                        // Se il ruolo esiste già, lo aggiunge all'utente
                        u.getRoles().add(role);
                    } else {
                        throw new PersistEntityException(user);
                    }
                });
            return mapRegisteredUser.map(users.save(u));
        } catch (Exception e) {
            log.error(String.format("Exception saving user %s", user), e);
            throw new PersistEntityException(user);
        }
    }

    @Override
    public Optional<LoginResponseDto> login(String username, String password) {
        try {
            var a = auth.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            a.getAuthorities();
            SecurityContextHolder.getContext().setAuthentication(a);

            var dto = mapLogin.map(users.findOneByUsername(username).orElseThrow());
            dto.setToken(jwt.generateToken(a));
            return Optional.of(dto);
        } catch (NoSuchElementException e) {
            log.error("User not found", e);
            throw new InvalidLoginException(username, password);
        } catch (AuthenticationException e) {
            log.error("Authentication failed", e);
            throw new InvalidLoginException(username, password);
        }
    }

    @Override
    public Optional<RegisteredUserDto> get(long id) {
        try {
            return Optional.of(mapRegisteredUser.map(users.findById(id).orElseThrow()));
        } catch (Exception e) {
            log.error(String.format("User not found for id %s", id), e);
            return Optional.empty();
        }
    }
}
