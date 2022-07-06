package com.absoft.unit9homework.domain;

public class Card {
    private final String fullName;
    private final String cardNumber;

    public Card(String fullName, String cardNumber) {
        // TODO: 1) Add validation that fullName is not null
        // TODO: 2) Add validation that cardNumber is non-null
        // throw NullPointerException if validation fails
        // TODO: Optional: Validate that cardNumber contain exactly 16 digits. And throw some unchecked exception if it invalid
        this.fullName = fullName;
        this.cardNumber = cardNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public String getCardNumber() {
        return cardNumber;
    }
}
