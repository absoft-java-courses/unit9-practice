package com.absoft.unit9homework;

import com.absoft.unit9homework.domain.BankAccount;
import com.absoft.unit9homework.domain.Currency;
import com.absoft.unit9homework.domain.Money;
import com.absoft.unit9homework.domain.Card;
import com.absoft.unit9homework.service.PayPalPaymentService;
import com.absoft.unit9homework.service.PaymentService;

public class Runner {
    private final PaymentService paymentService;
    private int errorsAmount;

    private void run() {
        System.out.println("====Task 1====");
        callTask1();
        System.out.println("========");

        System.out.println("====Task 2====");
        callTask2();
        System.out.println("========");

        System.out.println("====Task 3====");
        callTask3();
        System.out.println("========\n");

        printIfHasErrors();

    }

    public static void main(String[] args) {
        new Runner(new PayPalPaymentService()).run();
    }

    public Runner(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // Ensure classes Card & BankAccount has null-check
    private void callTask1() {
        hasToThrowException("Card has to have null check on all fields",
                () -> new Card(null, "1234567812345678"));
        hasToThrowException("Card has to have null check on all fields",
                () -> new Card("John Doe", null));

        var money = new Money(100500, Currency.UAH);
        var card = new Card("Ab Softer", "1234567812345678");
        hasToThrowException("BankAccount has to have null check on all fields",
                () -> new BankAccount(null, "UA123", card));
        hasToThrowException("BankAccount has to have null check on all fields",
                () -> new BankAccount(money, null, card));
        hasToThrowException("BankAccount has to have null check on all fields",
                () -> new BankAccount(money, "UA123", null));
    }

    // TODO: Fix NotEnoughMoneyException, it has to be exception
    // TODO: Ensure source bank account has enough money to transfer. Throw NotEnoughMoneyException
    private void callTask2() {
        var aliceMoney = new Money(100, Currency.UAH);
        var aliceCard = new Card("Alice Cooper", "1234567891234567");
        var aliceAccount = new BankAccount(aliceMoney, "UA123", aliceCard);

        var bobMoney = new Money(200, Currency.UAH);
        var bobCard = new Card("Bob Martin", "987654321098765432");
        var bobAccount = new BankAccount(bobMoney, "UA456", bobCard);


       hasToThrowException("Alice hasn't be allowed to transfer more money than she has.",
               () -> paymentService.transfer(aliceAccount, bobAccount, new Money(101, Currency.UAH)));
       hasToThrowException("Bob hasn't be allowed to transfer more money than he has.",
               () -> paymentService.transfer(bobAccount, aliceAccount, new Money(201, Currency.UAH)));

        hasNotThrowException("Alice has be allowed to transfer money she has.",
                () -> paymentService.transfer(aliceAccount, bobAccount, new Money(100, Currency.UAH)));
        hasNotThrowException("Bob has be allowed to transfer money he has.",
                () -> paymentService.transfer(bobAccount, aliceAccount, new Money(300, Currency.UAH)));
    }

    // TODO: Fix InvalidCurrencyException, it has to be exception
    // TODO: Ensure source, target and amount has the same currencies.
    //  Throw InvalidCurrencyException when they has different currencies
    private void callTask3() {
        var aliceMoney = new Money(100, Currency.UAH);
        var aliceCard = new Card("Alice Cooper", "1234567891234567");
        var aliceAccount = new BankAccount(aliceMoney, "UA123", aliceCard);

        var bobMoney = new Money(200, Currency.EUR);
        var bobCard = new Card("Bob Martin", "987654321098765432");
        var bobAccount = new BankAccount(bobMoney, "UA456", bobCard);

        var karlMoney = new Money(300, Currency.UAH);
        var karlCard = new Card("Karl Gustaf", "5555444433332222");
        var karlAccount = new BankAccount(karlMoney, "UA456", karlCard);


        hasToThrowException("Alice hasn't be allowed to transfer money with invalid currency.",
                () -> paymentService.transfer(aliceAccount, bobAccount, new Money(50, Currency.UAH)));
        hasToThrowException("Alice hasn't be allowed to transfer money with invalid currency.",
                () -> paymentService.transfer(aliceAccount, bobAccount, new Money(50, Currency.EUR)));
        hasToThrowException("Alice hasn't be allowed to transfer money with invalid currency.",
                () -> paymentService.transfer(aliceAccount, karlAccount, new Money(50, Currency.USD)));


        hasNotThrowException("Alice has be allowed to transfer money with valid currencies.",
                () -> paymentService.transfer(aliceAccount, bobAccount, new Money(50, Currency.UAH)));
    }


    private void hasToThrowException(String msg, RunnableWithException runnable) {
        try {
            runnable.run();
            System.out.println(msg);
            errorsAmount++;
        } catch (Exception e) {
            // ignore
        }
    }

    private void hasNotThrowException(String msg, RunnableWithException runnable) {
        try {
            runnable.run();
        } catch (Exception e) {
            System.out.println(msg);
            e.printStackTrace(System.out);
            errorsAmount++;
        }
    }

    private void printIfHasErrors() {
        if (errorsAmount > 0) {
            System.out.printf("\tUnfortunately you still have %s error(s) =c\n", errorsAmount);
        } else {
            System.out.println("\tCongads! you don't have any errors.");
        }
    }

    private interface RunnableWithException {
        void run() throws Exception;
    }
}
