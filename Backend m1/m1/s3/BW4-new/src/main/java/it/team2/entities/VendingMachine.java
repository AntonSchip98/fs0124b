package it.team2.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.StringJoiner;

@Entity
@DiscriminatorValue("D")
public class VendingMachine extends Seller {

    private boolean active = true;

    @Column(name = "subscription_sold")
    private int numberSubscriptionsIssued = 0;
    @Column(name = "ticket_sold")
    private int numberOfTicketsIssued = 0;

    public VendingMachine() {
    }


    @Override
    public void issueSubscription() {
        numberSubscriptionsIssued++;
    }

    @Override
    public void issueTicket() {
        numberOfTicketsIssued++;
    }

    public int getNumberOfTicketsIssued() {
        return numberOfTicketsIssued;
    }

    public  int getNumberSubscriptionsIssued() {
        return numberSubscriptionsIssued;
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
                .add("numberSubscriptionsIssued=" + numberSubscriptionsIssued)
                .add("numberOfTicketsIssued=" + numberOfTicketsIssued)
                .toString();
    }
}
