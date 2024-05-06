package it.schipani.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import java.util.Date;
import java.util.StringJoiner;

/*Proprietà di navigazione che consente di recuperare l'elemento in prestito all'interno
 della tabella collegata
* */
@Entity
public class Loan extends BaseEntity{
    @ManyToOne
    private User user;
    @ManyToOne
    private Item item;
    private Date loanStartDate;
    private Date expectedReturnDate;
    private Date effectiveReturnDate;


    public Loan() {
    }

    public Loan(User user, Item item, Date loanStartDate) {
        this.user = user;
        this.item = item;
        this.loanStartDate = loanStartDate;

        // Calcola la data di restituzione prevista (30 giorni dopo la data di inizio prestito)
        this.expectedReturnDate = new Date(loanStartDate.getTime() + (30L * 24 * 60 * 60 * 1000));
    }

    public User getUser() {
        return user;
    }

    public Item getItem() {
        return item;
    }

    public Date getLoanStartDate() {
        return loanStartDate;
    }

    public Date getExpectedReturnDate() {
        return expectedReturnDate;
    }

    public Date getEffectiveReturnDate() {
        return effectiveReturnDate;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setLoanStartDate(Date loanStartDate) {
        this.loanStartDate = loanStartDate;
    }

    public void setExpectedReturnDate(Date expectedReturnDate) {
        this.expectedReturnDate = expectedReturnDate;
    }

    public void setEffectiveReturnDate(Date effectiveReturnDate) {
        this.effectiveReturnDate = effectiveReturnDate;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Loan.class.getSimpleName() + "[", "]")
                .add("user=" + user)
                .add("item=" + item)
                .add("loanStartDate=" + loanStartDate)
                .add("expectedReturnDate=" + expectedReturnDate)
                .add("effectiveReturnDate=" + effectiveReturnDate)
                .toString();
    }
}
