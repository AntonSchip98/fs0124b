package it.schipani.demo.services;


import it.schipani.demo.entities.menu.Item;
import it.schipani.demo.entities.ordini.Order;
import it.schipani.demo.entities.ordini.OrderState;
import it.schipani.demo.entities.ordini.Table;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@Component
public class OrderServiceImpl implements OrderService{

    @Value("${cover.charge}")
    private double coverCharge;

    @Override
    public String printOrder(Order order) {
        String print =  "Numero ordine: " + order.getOrderNumber() + "\n" +
                "Numero tavolo: " + order.getTable().getTableNumber() + "\n" +
                "Stato tavolo: " + order.getTable().getState() + "\n" +
                "Items: " + order.getItems() + "\n" +
                "Prezzo totale: " + calculateTotalAmount(order);

        return print;
    }


    public double calculateTotalAmount(Order order) {
        double totalPrice = 0.0;
        for (Item item : order.getItems()) {
            totalPrice += item.getPrice();
        }
        // Aggiungi il costo del coperto
        totalPrice += coverCharge * order.getTable().getMaxSeats();
        return totalPrice;
    }

    private int generateOrderNumber() {
        // Esempio di generazione di un numero univoco per l'ordine basato sull'ora attuale
        return LocalDateTime.now().hashCode();
    }
}
