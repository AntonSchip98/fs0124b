package it.schipani.demo.services;

import it.schipani.demo.entities.menu.Item;

import it.schipani.demo.entities.ordini.Order;
import it.schipani.demo.entities.ordini.Table;

import java.util.List;

public interface OrderService {
    String printOrder(Order order);
}
