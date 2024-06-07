package cristianmartucci.entities;

import cristianmartucci.enums.Periodicity;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;


@Entity
@DiscriminatorValue("magazine")
public class Magazine extends ElementCatalog {
    @Enumerated(EnumType.STRING)
    private Periodicity periodicity;

    public Magazine() {
    }

    public Magazine(String ISBN, String title, int year_of_publication, int pages, Periodicity periodicity) {
        super(ISBN, title, year_of_publication, pages);
        this.periodicity = periodicity;
    }

    public Periodicity getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(Periodicity periodicity) {
        this.periodicity = periodicity;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "periodicity=" + periodicity +
                ", ISBN='" + ISBN + '\'' +
                ", title='" + title + '\'' +
                ", year_of_publication=" + year_of_publication +
                ", pages=" + pages +
                '}';
    }
}
