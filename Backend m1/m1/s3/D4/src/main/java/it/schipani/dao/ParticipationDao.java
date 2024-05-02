package it.schipani.dao;

import it.schipani.entity.Participation;

public interface ParticipationDao {
    void save(Participation ev);

    Participation getById(long id);

    void delete(Long id);
}
