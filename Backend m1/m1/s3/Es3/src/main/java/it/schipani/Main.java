package it.schipani;


import it.schipani.dao.JpaLibraryDao;

import it.schipani.entities.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
       try(var itemDao = new JpaLibraryDao()){
           var magazines1 = new Magazines("123456789", "Magazine Title", 2024, 50, Periodicity.MONTHLY);
           var user1 = new User("John ", "Doe", new Date(10-10-1990),23);
           var book1 = new Book("1234", "Il Signore degli Anelli", 1954, 1170, "J.R.R. Tolkien", "Fantasy");
           var loan1 = new Loan(user1,book1, new Date());
           itemDao.save(book1);
          /* itemDao.save(magazines1);*/
          /* itemDao.save(loan1);*/
         var getItem =  itemDao.getItemByISBN(1234);
         log.debug("{}", getItem);
       }catch (Exception e){
           log.error("Exception", e);
       }
    }
}