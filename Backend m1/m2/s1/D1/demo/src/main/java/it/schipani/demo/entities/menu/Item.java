package it.schipani.demo.entities.menu;

import lombok.*;

@Getter
public abstract class Item {
    protected String name;
    protected int calories;
    protected double price;

    public Item(String name, int calories, double price) {
        this.name = name;
        this.calories = calories;
        this.price = price;
    }

}
