package it.schipani.classes;

public class Libro extends Item {

    private final String author;
    private final String type;

    public Libro( String title, int yearOfPublication, int numberOfPages, String author, String type) {
        super(title, yearOfPublication, numberOfPages);
        this.author = author;
        this.type = type;
    }

    public String getAuthor() {
        return author;
    }

    public String getType() {
        return type;
    }

    @Override
    public int getISBN() {
        return super.getISBN();
    }

    @Override
    public String getTitle() {
        return super.getTitle();
    }

    @Override
    public int getYearOfPublication() {
        return super.getYearOfPublication();
    }

    @Override
    public int getPageNumber() {
        return super.getPageNumber();
    }

    @Override
    public String toString() {
        return  "\n  Libro: " + getTitle() +
                "\n  Codice ISBN: " + getISBN() +
                "\n  Anno pubblicazione: " + getYearOfPublication() +
                "\n  Numero pagine: " + getPageNumber() +
                "\n  Autore: " + getAuthor() +
                "\n  Genere: " + getType() +
                "\n\n";
    }

}
