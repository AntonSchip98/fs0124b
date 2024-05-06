package it.schipani.entities;

import it.schipani.entities.constants.Tables;
import jakarta.persistence.*;

import java.util.StringJoiner;

@Entity
@Table(name = Tables.Names.MAGAZINES)
@DiscriminatorValue(Tables.Discriminators.MAGAZINES)
public class Magazines extends Item {


    @Enumerated(EnumType.STRING)
    @Column(name = "periodicity")
    private Periodicity periodicity;

    public Magazines() {
    }

    public Magazines(String ISBN, String title, int publicationYear, int pageNumber, Periodicity periodicity) {
        super(ISBN, title, publicationYear, pageNumber);
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
        return new StringJoiner(", ", Magazines.class.getSimpleName() + "[", "]")
                .add("periodicity=" + periodicity)
                .toString();
    }
}
