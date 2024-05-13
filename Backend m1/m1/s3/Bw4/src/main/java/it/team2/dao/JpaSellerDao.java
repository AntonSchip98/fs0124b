package it.team2.dao;

import it.team2.entities.Seller;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class JpaSellerDao extends JpaBaseDao implements SellerDao{
    @Override
    public void save(Seller seller) {
        try{
            var t = em.getTransaction();
            t.begin();
            em.persist(seller);
            t.commit();
        }catch (Exception ex){
            log.error("{}", ex);
        }
    }

    @Override
    public List<Seller> getAllSellers() {
        List<Seller> sellers = null;
        try {
            TypedQuery<Seller> query = em.createNamedQuery("TUTTI_I_SELLER", Seller.class);
            sellers = query.getResultList();
        } catch (Exception ex) {
            log.error("{}", ex);
        }
        return sellers;
    }
}
