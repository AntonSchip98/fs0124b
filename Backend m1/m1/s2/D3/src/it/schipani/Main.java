package it.schipani;

import it.schipani.classes.Category;
import it.schipani.classes.Customer;
import it.schipani.classes.Order;
import it.schipani.classes.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Customer antonio = new Customer(1, "Antonio");
        Customer cristiano = new Customer(2, "Cristiano");
        Customer andrea = new Customer(1, "Andrea");
        Customer danilo = new Customer(3, "Danilo");


        List<Product> produtcs = new ArrayList<>();
        produtcs.add(new Product("Bici", Category.BOYS, 200.9));
        produtcs.add(new Product("Moto", Category.BOYS, 300.9));
        produtcs.add(new Product("Macchina", Category.BOYS, 500.9));
        produtcs.add(new Product("Pistola", Category.BOYS, 100.9));
        produtcs.add(new Product("Guantoni", Category.BOYS, 70.9));
        produtcs.add(new Product("Ciucciotto", Category.BABY, 10.9));
        produtcs.add(new Product("Bavaglino", Category.BABY, 20.9));
        produtcs.add(new Product("Sonaglio", Category.BABY, 40.9));
        produtcs.add(new Product("Culla", Category.BABY, 80.9));
        produtcs.add(new Product("Passeggino", Category.BABY, 55.9));
        produtcs.add(new Product("Atomic Habits", Category.BOOK, 120.9));
        produtcs.add(new Product("Sun Tzu", Category.BOOK, 150.9));
        produtcs.add(new Product("48 Leggi del Potere", Category.BOOK, 70.9));
        produtcs.add(new Product("Il libro dei 5 anelli", Category.BOOK, 90.9));
        produtcs.add(new Product("Il proiettore", Category.BOOK, 60.9));

        List<Order> orders = new ArrayList<>();
        orders.add(new Order("Pending", LocalDate.of(2021, 2, 1), LocalDate.of(2021, 4, 1), Arrays.asList(produtcs.get(14), produtcs.get(2)), cristiano));
        orders.add(new Order("Delivered", LocalDate.of(2021, 3, 15), LocalDate.of(2021, 4, 2), Collections.singletonList(produtcs.get(5)), antonio));
        orders.add(new Order("Delivered", LocalDate.of(2021, 3, 15), LocalDate.of(2021, 4, 2), Arrays.asList(produtcs.get(0), produtcs.get(2)), andrea));
        orders.add(new Order("Pending", LocalDate.of(2021, 2, 1), LocalDate.of(2021, 4, 1), Arrays.asList(produtcs.get(5), produtcs.get(8), produtcs.get(7)), cristiano));
        orders.add(new Order("Accepted", LocalDate.of(2021, 3, 15), LocalDate.of(2021, 4, 2), Arrays.asList(produtcs.get(0), produtcs.get(9)), danilo));
        orders.add(new Order("Rejected", LocalDate.of(2021, 2, 1), LocalDate.of(2021, 4, 1), Arrays.asList(produtcs.get(11), produtcs.get(2)), antonio));

        List<Product> booksSup100 = produtcs.stream()
                .filter(p -> p.getCategory().equals(Category.BOOK) && p.getPrice() > 100.0)
                .toList();


        List<Product> babysProduct = produtcs.stream()
                .filter(b -> b.getCategory().equals(Category.BABY))
                .toList();

        List<Order> orderBaby = orders.stream()
                .filter(o -> o.getProducts().stream()
                        .anyMatch(p -> p.getCategory().equals(Category.BABY)))
                .toList();



        List<Product> boysWith10 = produtcs.stream()
                .filter(p -> p.getCategory().equals(Category.BOYS))
                .map(p -> {
                    double sconto = p.getPrice() * 0.9;
                    return new Product(p.getName(), p.getCategory(), sconto);
                })
                .toList();

List<Product> prodTier2 = orders.stream()
        .filter(o -> o.getCustomer().getTier().equals(2))
        .filter(o -> o.getOrederDate().equals(LocalDate.of(2021, 2, 1)) && o.getDeliveyDate().equals(LocalDate.of(2021, 4, 1)))
        .flatMap(o -> o.getProducts().stream()).toList();

        System.out.println(prodTier2);
    }
}
