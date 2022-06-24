package com.absoft.unit9homework.service;

import com.absoft.unit9homework.domain.BankAccount;
import com.absoft.unit9homework.domain.Money;
import com.absoft.unit9homework.exception.MoneyTransferException;

public interface PaymentService {
    void transfer(BankAccount source, BankAccount target, Money amount) throws MoneyTransferException;
}
