package it.team2.entities;

import it.team2.services.TicketCodeGeneratorService;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.StringJoiner;

@Entity
@Table(name = "user")
public class User extends BaseEntity {
    @Column(name = "name", length = 50, nullable = false)
    private String name;
    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;
    @Column(name = "card_code", unique = true)
    private int cardCode;
    @Column(name = "card_expiration_date", nullable = false)
    private LocalDate expirationCard;

    public User() {
    }

    public User(String name, String lastName) {
        LocalDate today = LocalDate.now();
        this.name = name;
        this.lastName = lastName;
        this.cardCode = (int)(Math.random()*1000);
        this.expirationCard = today.plusYears(1);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getCardCode() {
        return cardCode;
    }

    public void setCardCode(int cardCode) {
        this.cardCode = cardCode;
    }

    public LocalDate getExpirationCard() {
        return expirationCard;
    }

    public void setExpirationCard(LocalDate expirationCard) {
        this.expirationCard = expirationCard;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("lastName='" + lastName + "'")
                .add("code='" + cardCode + "'")
                .add("expirationCard=" + expirationCard)
                .toString();
    }
}
