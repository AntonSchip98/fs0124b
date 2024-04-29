package it.schipani.services;

import it.schipani.classes.*;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class FileCatalogoService implements CatalogoService {
    private static final Logger log = LoggerFactory.getLogger(FileCatalogoService.class);

    private final List<CatalogoItem> items = new ArrayList<>();

    private static final String STORAGE = "C:/Users/user/Desktop/Epciode/fs0124b/Backend m1/m1/s2/Es2/src/biblioteca.csv";

    /*public FileCatalogoService(String file) {
        try {
            load();
        } catch (IOException e) {
            log.error("Eccezione leggendo il file della biblioteca", e);
        }
    }*/

    public FileCatalogoService() {
        try {
            load();
        } catch (IOException e) {
            log.error("Eccezione leggendo il file della biblioteca", e);
        }
    }

    public void save() {
        File f = new File(STORAGE);
        try {
            FileUtils.delete(f);
        } catch (IOException e) {
            log.error("Eccezione durante l'eliminazione del file di storage", e);
        }

        try {
            for (CatalogoItem item : items) {
                String line;

                if (item instanceof Libro libro) {
                    line = String.join(",", String.valueOf(libro.getISBN()), libro.getTitle(), String.valueOf(libro.getYearOfPublication()), String.valueOf(libro.getPageNumber()), libro.getAuthor(), libro.getType());

                } else if (item instanceof Riviste rivista) {
                    line = String.join(",", String.valueOf(rivista.getISBN()), rivista.getTitle(), String.valueOf(rivista.getYearOfPublication()), String.valueOf(rivista.getPageNumber()), rivista.getPeriodicity().toString());

                } else {
                    log.error("Tipo non supportato: {}", item.getClass().getSimpleName());
                    continue;
                }
                FileUtils.writeStringToFile(f, line + System.lineSeparator(), StandardCharsets.ISO_8859_1, true);
            }
        } catch (IOException e) {
            log.error("Eccezione durante il salvataggio", e);
        }
    }

    public void load() throws IOException {
        File f = new File(STORAGE);

        if (!f.exists()) {
            log.error("Il file non esiste...");
            return;
        }

        List<String> lines = FileUtils.readLines(f, StandardCharsets.ISO_8859_1);

        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length == 5) {
                try {
                    Periodicity periodicity = Periodicity.valueOf(parts[4]);
                    items.add(new Riviste(parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), periodicity));
                } catch (NumberFormatException e) {
                    log.error("Errore durante il parsing dell'ISBN: {}", e.getMessage());
                }
            } else if (parts.length == 6) {
                try {
                    items.add(new Libro(parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), parts[4], parts[5]));
                } catch (NumberFormatException e) {
                    log.error("Errore durante il parsing dell'ISBN: {}", e.getMessage());
                }
            }
        }
    }


    @Override
    public void getItems() {
        List.of(items).forEach(i -> log.debug("{}", i));
    }

    @Override
    public void addItem(Item item) {
        items.add(item);
        save();
    }

    @Override
    public void removeItemByISBN(int ISBN) {
        Optional<CatalogoItem> item = items.stream()
                .filter(i -> Integer.valueOf(i.getISBN()).equals(ISBN))
                .findAny();

        item.ifPresentOrElse(
                i -> {
                    items.remove(i);
                    save();
                },
                () -> {
                    log.error("L'elemento con ISBN {} non esiste nel catalogo", ISBN);

                }
        );
    }

    @Override
    public void searchByISBN(int ISBN) {
        Optional<CatalogoItem> item = items.stream()
                .filter(i -> Integer.valueOf(i.getISBN()).equals(ISBN))
                .findFirst();

        item.ifPresentOrElse(
                i -> log.debug("{}", i),
                () -> {
                    log.error("L'elemento con ISBN {} non è presente nel catalogo", ISBN);
                });
    }

    @Override
    public void searchByPubblicazione(int yearOfPublication) {

        Optional<CatalogoItem> item = items.stream()
                .filter(i -> Integer.valueOf(i.getYearOfPublication()).equals(yearOfPublication))
                .findAny();

        item.ifPresentOrElse(
                i -> log.debug("{}", i),
                () -> {
                    log.error("L'elemento con anno di pubblicazione {} non è presente nel catalogo", yearOfPublication);
                }
        );
    }

    @Override
    public void searchByAuthor(String author) {

        Optional<CatalogoItem> item = items.stream()
                .filter(i -> i instanceof Libro && ((Libro) i).getAuthor().equals(author))
                .findAny();

        item.ifPresentOrElse(
                i -> log.debug("{}", i),
                ()->{
                    log.error("L'elemento con autore {} non è presente nel catalogo", author);
                }
        );
    }
}
