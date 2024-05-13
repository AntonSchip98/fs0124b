package it.team2.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.StringJoiner;

@Entity
@DiscriminatorValue("V")
public class VendingMachine extends Seller {
    private boolean active = true;

    public VendingMachine() {

    }

    public VendingMachine(String location) {
        super(location);
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", VendingMachine.class.getSimpleName() + "[", "]")
                .add("active=" + active)
                .toString();
    }
}
