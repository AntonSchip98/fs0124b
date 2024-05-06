package it.schipani.dao;

import it.schipani.entities.BaseEntity;
import it.schipani.entities.Item;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ItemDao extends AutoCloseable {
    void save(BaseEntity item);

    void deleteItemByISBN(long ISBN);

    Optional<BaseEntity> getItemByISBN(long ISBN);

    List<BaseEntity> getByYear(Date year);

    List<BaseEntity> getByAuthor(String author);

    Optional<BaseEntity> getByTitle(String title);

   List<Item> cercaElementiInPrestito(int numeroTesseraUtente);

    List<Item> cercaPrestitiScaduti();
}
