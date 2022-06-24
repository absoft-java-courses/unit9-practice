package com.absoft.unit9homework.domain;

public class Money {
    private final long amount;
    private final Currency currency;

    public Money(long amount, String currencyStr) {
        // be aware that 'Currency.valueOf()' can throw IllegalArgumentException or NullPointerException
        this(amount, Currency.valueOf(currencyStr));
    }

    public Money(long amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public long getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }
}
