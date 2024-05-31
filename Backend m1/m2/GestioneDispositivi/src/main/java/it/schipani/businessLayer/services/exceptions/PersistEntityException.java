package it.schipani.businessLayer.services.exceptions;

import it.schipani.businessLayer.services.dto.DtoBase;

import java.io.Serial;

/*. Questa classe rappresenta una situazione specifica in cui si verifica un errore durante il
 salvataggio di un'entità. Ecco una spiegazione dettagliata delle sue componenti:*/
public class PersistEntityException extends ServiceException{
    @Serial
    private static final long serialVersionUID = 1L;

    public final DtoBase invalidDto;

    public PersistEntityException(DtoBase invalidDto) {
        this.invalidDto = invalidDto;
    }
}
