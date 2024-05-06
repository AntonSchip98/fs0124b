package it.schipani.entities;

import jakarta.persistence.Entity;

import java.util.Date;
import java.util.StringJoiner;

@Entity
public class User extends BaseEntity{
    private  String name;
    private  String surname;
    private  Date dateOfBirth;
    private  int cardNumber;

    public User(String name, String surname, Date dateOfBirth, int cardNumber) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.cardNumber = cardNumber;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("surname='" + surname + "'")
                .add("dateOfBirth=" + dateOfBirth)
                .add("cardNumber=" + cardNumber)
                .toString();
    }
}
