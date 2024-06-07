package cristianmartucci.dao;

import cristianmartucci.entities.ElementCatalog;
import cristianmartucci.exceptions.ElementException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ElementCatalogDAO {
    private final EntityManager em;

    public ElementCatalogDAO(EntityManager em) {
        this.em = em;
    }

    public void save(ElementCatalog elementCatalog) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(elementCatalog);
        transaction.commit();
    }

    public ElementCatalog getByISBN(String ISBN) {
        ElementCatalog element = em.find(ElementCatalog.class, ISBN);
        if (element == null) throw new ElementException(ISBN);
        return element;
    }

    public void delete(String ISBN) {
        ElementCatalog element = this.getByISBN(ISBN);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(element);
        transaction.commit();
    }

    public List<ElementCatalog> getByYear(int year) {
        TypedQuery<ElementCatalog> query = em.createQuery("SELECT e FROM ElementCatalog e WHERE e.year_of_publication = :year", ElementCatalog.class);
        query.setParameter("year", year);
        return query.getResultList();
    }

    public List<ElementCatalog> getByAuthor(String author) {
        TypedQuery<ElementCatalog> query = em.createQuery("SELECT e FROM ElementCatalog e WHERE e.author ILIKE :author", ElementCatalog.class);
        query.setParameter("author", author);
        return query.getResultList();
    }

    public List<ElementCatalog> getByTitle(String title) {
        TypedQuery<ElementCatalog> query = em.createQuery("SELECT e FROM ElementCatalog e WHERE e.title ILIKE :title", ElementCatalog.class);
        query.setParameter("title", "%" + title + "%");
        return query.getResultList();
    }
}
