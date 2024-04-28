package it.schipani.services;

import it.schipani.classes.Item;

public interface CatalogoService {
    void getItems();
    void addItem(Item item);
    void removeItemByISBN(int ISBN);
    void searchByISBN(int ISBN);
    void searchByPubblicazione(int yearOfPublication);
    void searchByAuthor(String author);

}
