package it.schipani.dao;


import it.schipani.entity.Location;


public class JpaLocationDao extends JpaBaseDao implements LocationDao{
    @Override
    public void save(Location ev) {
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
    public Location getById(long id) {
        return em.find(Location.class, id);
    }

    @Override
    public void delete(Long id) {
        var t = em.getTransaction();

        try {
            Location ev = em.find(Location.class, id);
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
