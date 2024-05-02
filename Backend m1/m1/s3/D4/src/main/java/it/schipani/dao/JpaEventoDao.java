package it.schipani.dao;

import it.schipani.entity.Evento;

public class JpaEventoDao extends JpaBaseDao implements EventoDao {


    @Override
    public void save(Evento ev) {
        try {
            log.debug("Saving {}", ev);
            var t = em.getTransaction();
            t.begin();
            em.persist(ev);
            t.commit();
            log.debug("Saved {}", ev);
        } catch (Exception e) {
            log.error("Exception saving entity...", e);
        }
    }

    @Override
    public Evento getById(long id) {
        return em.find(Evento.class, id);
    }

    @Override
    public void delete(Long id) {
        var t = em.getTransaction();

        try {
            Evento ev = em.find(Evento.class, id);
            if (ev != null) {
                em.remove(ev);
            }
            t.commit();
            log.debug("Evento {} eliminato correttamente", ev);
        } catch (Exception err) {

            if (t != null && t.isActive()) {
                t.rollback();
            }
            log.error("Errore durante l'eliminazione dell'evento", err);
        }
    }


}
