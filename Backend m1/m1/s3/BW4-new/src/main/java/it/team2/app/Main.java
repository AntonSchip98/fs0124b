package it.team2.app;


import it.team2.dao.JpaSellerDao;
import it.team2.entities.Reseller;
import it.team2.entities.Seller;
import it.team2.entities.VendingMachine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        var reseller1 = new Reseller("reseller-cz");
        var machine1 = new VendingMachine();

        var sellerDao = new JpaSellerDao();
        sellerDao.save(reseller1);
        sellerDao.save(machine1);

        List<Seller> sellers = sellerDao.findAll();
        for (Seller seller : sellers) {
            System.out.println(seller);
        }


        /*reseller1.issueTicket();*/


    }
}