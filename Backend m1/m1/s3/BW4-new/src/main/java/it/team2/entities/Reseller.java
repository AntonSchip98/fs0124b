package it.team2.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.StringJoiner;

@Entity
@DiscriminatorValue("R")
public class Reseller extends Seller {

    @Column(name = "reseller_name", length = 80)
    private String name;

    @Column(name = "subscription_sold")
    private int numberSubscriptionsIssued = 0;
    @Column(name = "ticket_sold")
    private int numberOfTicketsIssued = 0;

    public Reseller() {
    }

    public Reseller(String name) {
        this.name = name;
    }


    @Override
    public void issueSubscription() {
        numberSubscriptionsIssued++;
    }

    @Override
    public void issueTicket() {
        numberOfTicketsIssued++;
    }

    public String getName() {
        return name;
    }

    public int getNumberSubscriptionsIssued() {
        return numberSubscriptionsIssued;
    }

    public int getNumberOfTicketsIssued() {
        return numberOfTicketsIssued;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Reseller.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("numberSubscriptionsIssued='" + numberSubscriptionsIssued + "'")
                .add("numberOfTicketsIssued='" + numberOfTicketsIssued + "'")
                .toString();
    }
}
