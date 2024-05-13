package it.team2.App;

import it.team2.dao.JpaSellerDao;
import it.team2.dao.JpaTravelDocumentDao;
import it.team2.dao.JpaUserDao;
import it.team2.dao.TravelDocumentDao;
import it.team2.entities.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {


        var user1 = new User("Antonio", "Schipani");
        var user2 = new User("Cristiano", "Turri");

        var seller1 = new VendingMachine("Roma");
        var seller2 = new Reseller("Cosenza", "Bar Jolly");

        var ticket1 = new Ticket(seller1);
        var sub1 = new Subscription(SubscriptionType.WEEKLY, user1, seller1);
        var sub2 = new Subscription(SubscriptionType.MONTHLY, user2, seller2);
        /*var sub1 = new Subscription(SubscriptionType.WEEKLY, "antonio111");*/
        /*log.debug("{}", sub1);*/

        var userDao = new JpaUserDao();
        var trDao = new JpaTravelDocumentDao();
        var sellerDao = new JpaSellerDao();

       /* List<TravelDocument> travelDocumentList = new ArrayList<>();
        travelDocumentList.add(sub1);
        travelDocumentList.add(sub2);
        travelDocumentList.add(ticket1);

        travelDocumentList.forEach(System.out::println);*/
        /*List<Seller> sellers = sellerDao.getAllSellers();
        if (sellers != null) {
            System.out.println("Lista dei venditori:");
            for (Seller seller : sellers) {
                System.out.println(seller);
            }
        } else {
            System.out.println("Nessun venditore trovato.");
        }*/

        sellerDao.save(seller1);
        sellerDao.save(seller2);

        userDao.save(user1);
        userDao.save(user2);
        trDao.save(sub1);
        trDao.save(sub2);
        trDao.save(ticket1);

    }
}
