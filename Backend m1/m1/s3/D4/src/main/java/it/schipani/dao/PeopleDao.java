package it.schipani.dao;


import it.schipani.entity.People;

public interface PeopleDao {
    void save(People ev);

    People getById(long id);

    void delete(Long id);
}
