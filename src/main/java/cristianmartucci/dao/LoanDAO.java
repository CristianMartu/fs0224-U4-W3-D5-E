package cristianmartucci.dao;

import cristianmartucci.entities.Loan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

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

    public List<Loan> getByCardId(String card_id) {
        TypedQuery<Loan> query = em.createQuery("SELECT l FROM Loan l WHERE l.return_date IS NULL AND l.user_card.card_id = :card_id", Loan.class);
        query.setParameter("card_id", UUID.fromString(card_id));
        return query.getResultList();
    }

    public List<Loan> getExpired() {
        TypedQuery<Loan> query = em.createQuery("SELECT l FROM Loan l WHERE l.return_date IS NULL AND l.expected_return_date < :date", Loan.class);
        query.setParameter("date", LocalDate.now());
        return query.getResultList();
    }

}
