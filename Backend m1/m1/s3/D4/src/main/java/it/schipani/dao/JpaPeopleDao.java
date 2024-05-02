package it.schipani.dao;

import it.schipani.entity.Evento;
import it.schipani.entity.People;

public class JpaPeopleDao extends JpaBaseDao implements PeopleDao{
    @Override
    public void save(People ev) {
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
    public People getById(long id) {
        return em.find(People.class, id);
    }

    @Override
    public void delete(Long id) {
        var t = em.getTransaction();

        try {
            People ev = em.find(People.class, id);
            if (ev != null) {
                em.remove(ev);
            }
            t.commit();
            log.debug("People {} eliminato correttamente", ev);
        } catch (Exception err) {

            if (t != null && t.isActive()) {
                t.rollback();
            }
            log.error("Errore durante l'eliminazione del people", err);
        }
    }
}
