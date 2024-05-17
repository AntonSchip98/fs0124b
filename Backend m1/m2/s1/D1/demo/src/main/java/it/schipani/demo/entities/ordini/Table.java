package it.schipani.demo.entities.ordini;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Table {
    private int tableNumber;
    private int maxSeats;
    private TableState state;
}
