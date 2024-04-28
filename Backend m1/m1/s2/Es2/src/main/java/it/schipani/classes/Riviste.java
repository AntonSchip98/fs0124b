package it.schipani.classes;

public class Riviste extends Item {

    private final Periodicity periodicity;

    public Riviste(String title, int yearOfPublication, int numberOfPages, Periodicity periodicity) {
        super(title, yearOfPublication, numberOfPages);
        this.periodicity = periodicity;
    }

    public Periodicity getPeriodicity() {
        return periodicity;
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
        return "Rivista: " + getTitle() +
                "\n  Codice ISBN: " + getISBN() +
                "\n  Anno pubblicazione: " + getYearOfPublication() +
                "\n  Numero pagine: " + getPageNumber() +
                "\n  Periodicità: " + getPeriodicity()
                + "\n\n";
    }
}
