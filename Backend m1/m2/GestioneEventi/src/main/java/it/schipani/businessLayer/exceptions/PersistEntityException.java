package it.schipani.businessLayer.exceptions;

import it.schipani.businessLayer.dto.DtoBase;

/*Questa classe viene utilizzata per gestire le eccezioni specifiche che si verificano durante
il salvataggio di un'entità (entity) nel livello di persistenza.*/
public class PersistEntityException extends ServiceException {

    /*
     DtoBase rappresenta il DTO (Data Transfer Object) che non è stato possibile salvare, essendo
      final, questo campo deve essere inizializzato nel costruttore e non può essere modificato successivamente.
     */
    public final DtoBase invalidDto;

    /*Questo è un costruttore che accetta un parametro di tipo DtoBase e lo assegna al campo
     invalidDto. Il costruttore permette di creare un'istanza
    di PersistEntityException specificando quale DTO non è stato possibile salvare.*/
    public PersistEntityException(DtoBase invalidDto) {
        this.invalidDto = invalidDto;
    }
}

