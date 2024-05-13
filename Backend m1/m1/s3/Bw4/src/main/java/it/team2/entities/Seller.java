package it.team2.entities;

import jakarta.persistence.*;

import java.util.StringJoiner;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "seller_type", discriminatorType = DiscriminatorType.STRING)
@NamedQuery(name = "TUTTI_I_SELLER", query = "SELECT s FROM Seller s ORDER BY s.id")
public abstract class Seller extends BaseEntity {
    private String location;

    public Seller() {

    }

    public Seller(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Seller.class.getSimpleName() + "[", "]")
                .add("location='" + location + "'")
                .toString();
    }
}
