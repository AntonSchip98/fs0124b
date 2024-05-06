package it.schipani.entities;

import it.schipani.entities.constants.Tables;
import jakarta.persistence.*;

import java.util.StringJoiner;


@Entity
@Table(name = Tables.Names.LIBRARY)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = Tables.Columns.DISCRIMINATOR, discriminatorType = DiscriminatorType.INTEGER)
@NamedQuery(name = "FIND_BY_YEAR", query = "SELECT i FROM Item i WHERE i.publicationYear = :year")
@NamedQuery(name = "FIND_BY_AUTHOR", query = "SELECT i FROM Item i WHERE i.author = :author")
@NamedQuery(name = "FIND_BY_TITLE", query = "SELECT i FROM Item i WHERE i.title = :title")
@NamedQuery(name = "FIND_ITEM_LOAN", query = "SELECT l.item FROM Loan l WHERE l.user.cardNumber = :cardNumber")
@NamedQuery(name = "FIND_LOAN_OVERDUE", query = "SELECT l.item FROM Loan l WHERE l.expectedReturnDate < CURRENT_DATE")

/*Questa è un'entità generica che dovrà essere estesa a Libri e Riviste*/
public abstract class Item extends BaseEntity {

    @Column(length = 10, nullable = false)
    private String ISBN;
    @Column(length = 80, nullable = false)
    private String title;
    private int publicationYear;
    private int pageNumber;

    public Item(String ISBN, String title, int publicationYear, int pageNumber) {
        this.ISBN = ISBN;
        this.title = title;
        this.publicationYear = publicationYear;
        this.pageNumber = pageNumber;
    }

    public Item() {
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Item.class.getSimpleName() + "[", "]")
                .add("ISBN='" + ISBN + "'")
                .add("title='" + title + "'")
                .add("publicationYear=" + publicationYear)
                .add("pageNumber=" + pageNumber)
                .toString();
    }
}
