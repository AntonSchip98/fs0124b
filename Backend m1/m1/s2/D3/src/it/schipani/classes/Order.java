package it.schipani.classes;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class Order {
    private static long nextId = 1;
    private Long id;
    private String status;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private List<Product> products;
    private Customer customer;


    public Order(String status, LocalDate orederDate, LocalDate deliveyDate,
                 List<Product> products, Customer customer) {
        this.id = nextId++;
        this.status = status;
        this.orderDate = orederDate;
        this.deliveryDate = deliveyDate;
        this.products = products;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getOrederDate() {
        return orderDate;
    }

    public LocalDate getDeliveyDate() {
        return deliveryDate;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        String productList = products.stream()
                .map(Product::getName)
                .collect(Collectors.joining(",\n\t\t"));

        return  "\nOrder id: "+ id+ "{" +
                "\n\tStatus: '" + status + '\'' +
                "\n\tOrder Date: " + orderDate +
                "\n\tDelivery Date: " + deliveryDate +
                "\n\tProducts: [\n\t\t" + productList + "\n\t]" +
                "\n\tCustomer: " + customer.getName() +
                "\n}";
    }
}
