package it.schipani.dao;

import it.schipani.entity.Location;

public interface LocationDao {
    void save(Location ev);

    Location getById(long id);

    void delete(Long id);
}
