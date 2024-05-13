package it.team2.entities;


import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "seller", discriminatorType = DiscriminatorType.STRING)
@NamedQuery(name = "ALL_SELLERS", query = "SELECT s FROM Seller s ORDER BY s.id")
public abstract class Seller extends BaseEntity {

    public abstract void issueSubscription();

    public abstract void issueTicket();
}
