package it.schipani.controller;

import it.schipani.entities.User;
import it.schipani.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@Slf4j
public class UsersController {

    @Autowired
    UserService service;

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        var u = service.saveUser(user);
        if (u.isEmpty())
            throw new RuntimeException("Impossibile salvare l'utente");
        var headers = new HttpHeaders();
        var uri = UriComponentsBuilder //
                .fromPath("/api/users/{id}").buildAndExpand(u.get().getId()).toString();
        headers.add("Location", uri);
        return new ResponseEntity<>(u.get(), headers, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        var users = service.getAllUsers();
        return new ResponseEntity<>(users, null, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        Optional<User> userOptional = service.getUserById(userId);
        return userOptional.map(user ->
                new ResponseEntity<>(user, HttpStatus.OK)).orElseGet(() ->
                new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Void> updateUser(@PathVariable Long userId, @RequestBody User updatedUser) {
        service.updateUser(userId, updatedUser);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        service.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
