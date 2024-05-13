package it.team2.entities;

import it.team2.services.TicketCodeGeneratorService;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;
import java.util.StringJoiner;

@Entity
public class Subscription extends TravelDocument{

    private boolean active;
    @Enumerated(EnumType.STRING)
    @Column(name = "subscription_type", nullable = false)
    private SubscriptionType type;
    @Column(name = "user_card_number", nullable = false)
    private int cardNumber;
    @Column(name = "erogation_date", nullable = false)
    private LocalDate erogationDate;
    @Column(name = "expire_date", nullable = false)
    private LocalDate expireDate;



    public Subscription(SubscriptionType type,
                        User user, Seller seller) {
        super(seller.getId());
        LocalDate today = LocalDate.now();
        this.active = true;
        this.type = type;
        this.cardNumber = user.getCardCode();
        this.erogationDate = today;
        if (type == SubscriptionType.WEEKLY){
            this.expireDate = erogationDate.plusWeeks(1);
        } else if (type == SubscriptionType.MONTHLY) {
            this.expireDate = erogationDate.plusMonths(1);
        }
    }



    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public SubscriptionType getType() {
        return type;
    }

    public void setType(SubscriptionType type) {
        this.type = type;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public LocalDate getErogationDate() {
        return erogationDate;
    }

    public void setErogationDate(LocalDate startDate) {
        this.erogationDate = startDate;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate endDate) {
        this.expireDate = endDate;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Subscription.class.getSimpleName() + "[", "]")
                .add("active=" + active)
                .add("type=" + type)
                .add("cardNumber=" + cardNumber)
                .add("erogationDate=" + erogationDate)
                .add("expireDate=" + expireDate)
                .toString();
    }
}
