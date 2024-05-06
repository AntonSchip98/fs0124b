package it.schipani.entities;

import it.schipani.entities.constants.Tables;
import jakarta.persistence.*;


@Entity
@Table(name = Tables.Names.BOOKS)
@DiscriminatorValue(Tables.Discriminators.BOOKS)
public class Book extends Item {

    @Column(length = 50, nullable = false)
    private String author;
    @Column(length = 50, nullable = false)
    private String genre;

    public Book() {
    }

    public Book(String ISBN, String title, int publicationYear,
                int pageNumber, String author, String genre) {
        super(ISBN, title, publicationYear, pageNumber);
        this.author = author;
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

}
