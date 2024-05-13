package it.team2.dao;

import it.team2.entities.User;

import java.util.Optional;

public class JpaUserDao extends JpaBaseDao implements UserDao{
    @Override
    public void save(User user) {
        try{
            var t = em.getTransaction();
            t.begin();
            em.persist(user);
            t.commit();
        }catch (Exception ex){
            log.error("{}", ex);
        }
    }

    @Override
    public void deleteUser(long id) {

    }

    @Override
    public Optional<User> getUser(long id) {
        return Optional.ofNullable(em.find(User.class, id));
    }
}
