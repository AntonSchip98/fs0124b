package it.team2.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.StringJoiner;

@Entity
@DiscriminatorValue("R")
public class Reseller extends Seller{
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    public Reseller(){

    }
    public Reseller(String location, String name) {
        super(location);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Reseller.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .toString();
    }
}