package it.schipani.dao;

import it.schipani.entity.Evento;

public interface EventoDao {

    void save(Evento ev);

    Evento getById(long id);

    void delete(Long id);

}
