package cristianmartucci.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;


@Entity
@DiscriminatorValue("book")
public class Book extends ElementCatalog {
    private String author;
    private String genre;

    public Book() {
    }

    public Book(String ISBN, String title, int year_of_publication, int pages, String author, String genre) {
        super(ISBN, title, year_of_publication, pages);
        this.author = author;
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "genre='" + genre + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", title='" + title + '\'' +
                ", year_of_publication=" + year_of_publication +
                ", pages=" + pages +
                ", author='" + author + '\'' +
                '}';
    }
}
