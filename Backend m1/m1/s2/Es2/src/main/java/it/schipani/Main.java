package it.schipani;
import it.schipani.services.FileCatalogoService;

public class Main {

    public static void main(String[] args) {

        FileCatalogoService service = new FileCatalogoService();


        /*service.addItem(new Libro("Il giovane Holden", 1951, 234, "J.D. Salinger", "Romanzo"));
        service.addItem(new Libro("libro2", 1951, 234, "J.D. Salinger", "Romanzo"));
        service.addItem(new Libro("libro3", 1951, 234, "J.D. Salinger", "Romanzo"));*/

        service.searchByISBN(3);
    /*   service.getItems();*/

    }
}