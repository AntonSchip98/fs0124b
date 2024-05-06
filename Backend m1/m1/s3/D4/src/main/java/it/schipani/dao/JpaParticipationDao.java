package it.schipani.dao;

import it.schipani.entity.Location;
import it.schipani.entity.Participation;

public class JpaParticipationDao extends JpaBaseDao implements ParticipationDao{
    @Override
    public void save(Participation ev) {
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
    public Participation getById(long id) {
        return em.find(Participation.class, id);
    }

    @Override
    public void delete(Long id) {
        var t = em.getTransaction();

        try {
            Participation ev = em.find(Participation.class, id);
            if (ev != null) {
                em.remove(ev);
            }
            t.commit();
            log.debug("Location {} eliminato correttamente", ev);
        } catch (Exception err) {

            if (t != null && t.isActive()) {
                t.rollback();
            }
            log.error("Errore durante l'eliminazione del location", err);
        }
    }
}
