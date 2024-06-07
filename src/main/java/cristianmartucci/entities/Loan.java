package cristianmartucci.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "loan")
public class Loan {
    @Id
    @GeneratedValue
    private UUID id;

    @OneToMany(mappedBy = "loan_user")
    private List<User> userList;

    @OneToMany(mappedBy = "loan_element")
    private List<ElementCatalog> elementCatalogList;

    private LocalDate loan_start_date;
    private LocalDate expected_return_date;
    private LocalDate return_date;

    public Loan() {
    }

    public Loan(LocalDate loan_start_date, LocalDate expected_return_date, LocalDate return_date) {
        this.loan_start_date = loan_start_date;
        this.expected_return_date = expected_return_date;
        this.return_date = return_date;
    }

    public UUID getId() {
        return id;
    }

    public LocalDate getLoan_start_date() {
        return loan_start_date;
    }

    public void setLoan_start_date(LocalDate loan_start_date) {
        this.loan_start_date = loan_start_date;
    }

    public LocalDate getExpected_return_date() {
        return expected_return_date;
    }

    public void setExpected_return_date(LocalDate expected_return_date) {
        this.expected_return_date = expected_return_date;
    }

    public LocalDate getReturn_date() {
        return return_date;
    }

    public void setReturn_date(LocalDate return_date) {
        this.return_date = return_date;
    }

    public List<User> getUserList() {
        return userList;
    }

    public List<ElementCatalog> getElementCatalogList() {
        return elementCatalogList;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", loan_start_date=" + loan_start_date +
                ", expected_return_date=" + expected_return_date +
                ", return_date=" + return_date +
                '}';
    }
}
