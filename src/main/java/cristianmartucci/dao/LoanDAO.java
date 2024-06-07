package cristianmartucci.dao;

import cristianmartucci.entities.Loan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class LoanDAO {
    private final EntityManager em;

    public LoanDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Loan loan) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(loan);
        transaction.commit();
    }
}
