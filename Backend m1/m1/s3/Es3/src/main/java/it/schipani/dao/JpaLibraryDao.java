package it.schipani.dao;

import it.schipani.entities.BaseEntity;
import it.schipani.entities.Item;
import jakarta.persistence.NoResultException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class JpaLibraryDao extends JpaBaseDao implements ItemDao {
    @Override
    public void save(BaseEntity item) {
        try {
            log.debug("Saving {}", item);
            var t = em.getTransaction();
            t.begin();
            em.persist(item);
            t.commit();
            log.debug("Saved {}", item);
        } catch (Exception e) {
            log.error("Exception saving entity...", e);
        }
    }

    @Override
    public void deleteItemByISBN(long ISBN) {
        var t = em.getTransaction();
        try {
            Item item = em.find(Item.class, ISBN);
            if (item != null) {
                em.remove(item);
            }
            t.commit();
            log.debug("Library item {} eliminato correttamente", item);

        } catch (Exception e) {
            if (t != null && t.isActive()) {
                t.rollback();
            }
            log.error("Errore durante l'eliminazione dell'item", e);
        }finally {
            em.close();
        }
    }

    @Override
    public Optional<BaseEntity> getItemByISBN(long ISBN) {
        return Optional.ofNullable(em.find(Item.class, ISBN));
    }

    @Override
    public List<BaseEntity> getByYear(Date year) {
        var query = em.createNamedQuery("FIND_BY_YEAR", BaseEntity.class);
        query.setParameter("year", year);
        return query.getResultList();
    }

    @Override
    public List<BaseEntity> getByAuthor(String author) {
        var query = em.createNamedQuery("FIND_BY_AUTHOR", BaseEntity.class);
        query.setParameter("author", author);
        return  query.getResultList();
    }

    @Override
    public Optional<BaseEntity> getByTitle(String title) {
        var query = em.createNamedQuery("FIND_BY_TITLE", BaseEntity.class);
        query.setParameter("title", title);
        try {
            return Optional.ofNullable(query.getSingleResult());
        } catch (NoResultException e) {
            log.error("Exception searching city by id", e);
            return Optional.empty();

        }
    }

    @Override
    public List<Item> cercaElementiInPrestito(int cardNumber) {
       var query = em.createNamedQuery("FIND_ITEM_LOAN", Item.class);
       query.setParameter("cardNumber", cardNumber);
       return query.getResultList();
    }

    @Override
    public List<Item> cercaPrestitiScaduti() {
        var query = em.createNamedQuery("FIND_LOAN_OVERDUE", Item.class);
        return query.getResultList();
    }

    @Override
    public void close() throws Exception {
        em.close();
    }
}
