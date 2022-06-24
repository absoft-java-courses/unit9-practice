package com.absoft.unit9homework.service;

import com.absoft.unit9homework.domain.BankAccount;
import com.absoft.unit9homework.domain.Money;
import com.absoft.unit9homework.exception.MoneyTransferException;

public class PayPalPaymentService implements PaymentService {
    @Override
    public void transfer(BankAccount source, BankAccount target, Money amount) throws MoneyTransferException {
        //TODO: Add validation here
        // 1) validate nothing is null
        // 2) validate source, target and amount has the same currency
        // 3) validate source has enough money to withdraw

        source.withdraw(amount);
        target.receive(amount);
    }
}
