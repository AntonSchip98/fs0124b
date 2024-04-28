package it.schipani.classes;

public abstract class Item implements CatalogoItem {
    private static int incrementalISBN = 0;
    private final int ISBN;
    private final String title;
    private final int yearOfPublication;
    private final int numberOfPages;

    public Item(String title, int yearOfPublication, int numberOfPages) {

        this.ISBN = ++incrementalISBN ;
        this.title = title;
        this.yearOfPublication = yearOfPublication;
        this.numberOfPages = numberOfPages;
    }

    @Override
    public int getISBN() {
        return ISBN;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int getYearOfPublication() {
        return yearOfPublication;
    }

    @Override
    public int getPageNumber() {
        return numberOfPages;
    }


}
