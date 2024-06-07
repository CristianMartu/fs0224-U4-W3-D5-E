package cristianmartucci;

import cristianmartucci.dao.ElementCatalogDAO;
import cristianmartucci.dao.LoanDAO;
import cristianmartucci.dao.UserDAO;
import cristianmartucci.entities.*;
import cristianmartucci.enums.Periodicity;
import cristianmartucci.exceptions.ElementException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("my_database");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        ElementCatalogDAO elementDAO = new ElementCatalogDAO(em);
        LoanDAO loanDAO = new LoanDAO(em);
        UserDAO userDAO = new UserDAO(em);

        Book book = new Book("679-0-04-528988-9", "A Game Of Thrones", 1996, 2000, "George R.R.Martin", "fantasy");
        Book book2 = new Book("678-0-04-528988-9", "The Witcher", 2000, 1000, " Andrzej Sapkowski", "fantasy");
        Book book3 = new Book("677-0-04-528988-9", "Harry Potter", 2004, 800, "J. K. Rowling", "fantasy");
        Book book4 = new Book("676-0-04-528988-9", "Dune", 1965, 1500, "Frank Herbert", "fantasy");
        Magazine magazine = new Magazine("679-0-04-528977-9", "Magazine", 2023, 300, Periodicity.MONTHLY);
        Magazine magazine2 = new Magazine("979-0-04-528977-9", "Weekly shonen jump", 2024, 100, Periodicity.WEEKLY);
        Magazine magazine3 = new Magazine("579-0-04-528987-9", "Ducati", 2020, 70, Periodicity.SEMIANNUAL);
//        elementDAO.save(book);
//        elementDAO.save(book2);
//        elementDAO.save(book3);
//        elementDAO.save(book4);
//        elementDAO.save(magazine);
//        elementDAO.save(magazine2);
//        elementDAO.save(magazine3);

        User user = new User("Mario", "Rossi", LocalDate.parse("1990-06-12"));
        User user2 = new User("Luigi", "verdi", LocalDate.parse("1990-06-12"));
        User user3 = new User("Toad", "Blu", LocalDate.parse("1995-05-23"));
//        userDAO.save(user);
//        userDAO.save(user2);
//        userDAO.save(user3);

        User userFromDb = userDAO.getByCardId("82b21122-f5dd-436f-a355-f804c66141b0");
        ElementCatalog elemFromDb = elementDAO.getByISBN("979-0-04-528977-9");
        Loan loan = new Loan(userFromDb, elemFromDb, LocalDate.now(), LocalDate.now().plusDays(30), null);
//        loanDAO.save(loan);

        try {
            elementDAO.delete("677-0-04-528988-9");
        } catch (ElementException exception) {
            System.out.println(exception.getMessage());
        }

        elementDAO.getByYear(2020).forEach(System.out::println);
        elementDAO.getByAuthor("George R.R.Martin").forEach(System.out::println);
        elementDAO.getByTitle("shonen").forEach(System.out::println);


        em.close();
        emf.close();
    }
}
