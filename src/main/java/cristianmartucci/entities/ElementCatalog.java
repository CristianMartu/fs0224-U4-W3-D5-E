package cristianmartucci.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "element_catalogs")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class ElementCatalog {
    @Id
    protected String ISBN;
    protected String title;
    protected int year_of_publication;
    protected int pages;

    @OneToMany(mappedBy = "element")
    private List<Loan> loanList;

    public ElementCatalog() {
    }

    public ElementCatalog(String ISBN, String title, int year_of_publication, int pages) {
        this.ISBN = ISBN;
        this.title = title;
        this.year_of_publication = year_of_publication;
        this.pages = pages;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getYear_of_publication() {
        return year_of_publication;
    }

    public void setYear_of_publication(int year_of_publication) {
        this.year_of_publication = year_of_publication;
    }

    public List<Loan> getLoanList() {
        return loanList;
    }
}
