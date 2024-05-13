package it.team2.dao;

import it.team2.entities.User;

import java.util.Optional;

public interface UserDao {
    void save(User user);

    void deleteUser(long id);

    Optional<User> getUser(long id);
}
