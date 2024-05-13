package it.team2.dao;

import it.team2.entities.Seller;

import java.util.List;


public class JpaSellerDao extends JpaBaseDao implements SellerDao{
    @Override
    public void save(Seller sellers) {

        try{
            var t = em.getTransaction();
            t.begin();
            em.persist(sellers);
            t.commit();
        }catch (Exception ex){
            log.error("{}", ex);
        }
    }

    public Seller findById(Long id) {
        return em.find(Seller.class, id);
    }

    public List<Seller> findAll() {
        return em.createNamedQuery("ALL_SELLERS", Seller.class).getResultList();
    }
}
