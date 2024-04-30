package it.schipani.classes;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class EventDAO {
    private static final Logger log = LoggerFactory.getLogger(EventDAO.class);
    private final EntityManager entityManager;

    public EventDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestioneEventi");
        this.entityManager = emf.createEntityManager();
    }


    public void save(Evento ev) {
        EntityTransaction trans = entityManager.getTransaction();
        try {
            log.debug("Ho creato l'evento: {}", ev);
            trans.begin();
            log.debug("Salvo l' evento con persist()");
            entityManager.persist(ev);
            log.debug("Commissiono la transazione sul db");
            trans.commit();
        } catch (Exception err) {
            if (trans != null && trans.isActive()) {
                trans.rollback();
            }
            log.error("Errore durante il salvataggio dell'evento", err);
        }
    }

    public Evento getById(Long id){
        return entityManager.find(Evento.class, id);
    }

    public void delete(Long id){
        EntityTransaction trans = entityManager.getTransaction();
        try {
            trans.begin();
            Evento ev = entityManager.find(Evento.class, id);
            if (ev != null){
                entityManager.remove(ev);
            }
            trans.commit();
        }catch (Exception err){
            if (trans != null && trans.isActive()) {
                trans.rollback();
            }
            log.error("Errore durante l'eliminazione dell'evento", err);
        }
    }
}
