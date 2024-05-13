package it.team2.entities;



import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.StringJoiner;


@Entity
@DiscriminatorValue("T")
public class Ticket extends TravelDocument {
    @Column(nullable = false)
    private boolean validated;


    public Ticket() {
    }


    public Ticket(Seller seller) {
        super(seller.getId());
        this.validated = false;
    }


    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Ticket.class.getSimpleName() + "[", "]")
                .add("validated=" + validated)
                .toString();
    }
}

