package com.absoft.unit9homework.domain;

public class BankAccount {
    private Money money;
    private final String iban;
    private final Card owner;

    // TODO: add null checks for params
    // TODO: Optional: check that iban contain exactly 15 symbols and throw unchecked exception otherwise
    public BankAccount(Money money, String iban, Card card) {
        this.money = money;
        this.iban = iban;
        this.owner = card;
    }

    public String getIban() {
        return iban;
    }

    public Card getOwner() {
        return owner;
    }

    public Money getMoney() {
        return money;
    }

    public void withdraw(Money withdraw) {
        long newMoneyAmount = money.getAmount() - withdraw.getAmount();
        money = new Money(newMoneyAmount, money.getCurrency());
    }

    public void receive(Money withdraw) {
        long newMoneyAmount = money.getAmount() + withdraw.getAmount();
        money = new Money(newMoneyAmount, money.getCurrency());
    }
}
