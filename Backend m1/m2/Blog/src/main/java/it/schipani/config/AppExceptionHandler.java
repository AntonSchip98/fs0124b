package it.schipani.config;

import it.schipani.controller.excpetions.ApiValidationException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


/*Questo gestore di eccezioni verrà utilizzato prima di altri eventuali gestori*/
@Order(Ordered.HIGHEST_PRECEDENCE)
/*Permette di gestire le eccezioni a livello globale in tutti i controller della Blog App*/
@ControllerAdvice
/*Questa classe serve a configurare il gestore dell errore*/
public class AppExceptionHandler extends ResponseEntityExceptionHandler {
    /*   @Data
       @AllArgsConstructor
       public static class MyExceptionInfoModel {
           private String message;
           private LocalDateTime occurredAt;
           private HttpStatus status;
       }

       @ExceptionHandler(MyProjectException.class)
       protected ResponseEntity<?> handleMyProjectException(MyProjectException e) {
           var info = new MyExceptionInfoModel(e.getMessage(), e.occurredAt, HttpStatus.BAD_REQUEST);
           return new ResponseEntity<>(info, HttpStatus.INTERNAL_SERVER_ERROR);
       }*/
    /*una struttura dati immutabile che in questo caso contiene 2 campi field e message*/
    public record ValidationError(String field, String message) {
    }


    /*Questo è il gestore dell'errore, serve a produrre una response che sarà inviata al client
     * nella quale all'interno c'è l'errore*/
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<?> handleApplicationException(ApiValidationException e) {
        return new ResponseEntity<>(new Exception(e.getMessage()),
                HttpStatus.BAD_REQUEST);
    }
}
