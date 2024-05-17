package it.schipani.demo.entities.ordini;

import it.schipani.demo.entities.menu.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private int orderNumber;
    private Table table;
    private OrderState state;
    private List<Item> items;
    private double totalPrice;
    private LocalDateTime acquisitionTime;


}
