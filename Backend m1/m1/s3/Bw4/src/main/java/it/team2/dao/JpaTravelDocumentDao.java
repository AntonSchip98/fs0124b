package it.team2.dao;


import it.team2.entities.TravelDocument;

public class JpaTravelDocumentDao extends JpaBaseDao implements TravelDocumentDao {
    @Override
    public void save(TravelDocument tr) {
        try{
            var t = em.getTransaction();
            t.begin();
            em.persist(tr);
            t.commit();
        }catch (Exception ex){
            log.error("{}", ex);
        }
    }
}
