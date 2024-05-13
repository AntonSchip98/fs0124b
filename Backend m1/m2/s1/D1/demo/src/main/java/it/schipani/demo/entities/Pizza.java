package it.schipani.demo.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Pizza extends Item {

    private List<Topping> toppings;


    public Pizza(String name, List<Topping> toppings) {
        super(name, 700, 4.5);
        this.toppings = toppings;
        this.calories = setCalories(toppings);
        this.price = setPrice(toppings);
    }


    protected int setCalories(List<Topping> toppings) {
        int baseCalories = 700;
        if (toppings != null) {
            for (int i = 0; i < toppings.size(); i++) {
                baseCalories += toppings.get(i).getCalories();
            }
        }
        return baseCalories;
    }

    protected double setPrice(List<Topping> toppings) {
        double basePrice = 4.50;
        if (toppings != null) {
            for (int i = 0; i < toppings.size(); i++) {
                basePrice += toppings.get(i).getPrice();
            }
        }
        return basePrice;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                ", price=" + price +
                ", toppingList=" + toppings +
                '}';
    }
}
