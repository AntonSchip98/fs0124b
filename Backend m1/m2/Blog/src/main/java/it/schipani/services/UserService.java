package it.schipani.services;

import it.schipani.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    /*User*/
    Optional<User> saveUser(User u);

    List<User> getAllUsers();

    Optional<User> getUserById(Long id);

    Optional<User> updateUser(Long id, User u);

    Optional<User> deleteUser(Long id);


}
