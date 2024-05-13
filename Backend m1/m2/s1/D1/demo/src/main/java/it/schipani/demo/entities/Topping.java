package it.schipani.demo.entities;



import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Topping extends Item{


    public Topping(String name, int calories, double price) {
        super(name, calories, price);
    }

    @Override
    public String toString() {
        return "Topping{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                ", price=" + price +
                '}';
    }
}
