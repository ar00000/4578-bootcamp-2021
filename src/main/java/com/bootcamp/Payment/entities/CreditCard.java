package com.bootcamp.Payment.entities;

import javax.persistence.*;

@Entity
@Table(name = "creditcard")
@PrimaryKeyJoinColumn(name = "id")
public class CreditCard extends Payment{
    @Column(name = "creditnumber")
    private String cardNumber;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
