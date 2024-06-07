package cristianmartucci.dao;

import cristianmartucci.entities.User;
import cristianmartucci.exceptions.UserException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class UserDAO {
    private final EntityManager em;

    public UserDAO(EntityManager em) {
        this.em = em;
    }

    public void save(User user) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(user);
        transaction.commit();
    }

    public User getByCardId(String card_id) {
        User user = em.find(User.class, UUID.fromString(card_id));
        if (user == null) throw new UserException(card_id);
        return user;
    }
}
