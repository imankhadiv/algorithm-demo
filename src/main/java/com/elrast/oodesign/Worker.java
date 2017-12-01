package com.elrast.oodesign;

import java.util.Currency;

interface Timesheet {
}

interface Invoice {
}

interface Payable {
    public void pay();
}

class Money {
    public Money(double value, Currency currency) {
    }
}

abstract class Worker {
    private String name;

    public Worker(String name) {
        this.name = name;
    }

    public void pay() {

        Money due = getAmountDue();
    }

    protected abstract Money getAmountDue();
}

class Employee extends Worker {

    Timesheet[] timesheets;

    public Employee(String name) {
        super(name);
    }

    @Override
    protected Money getAmountDue() {
        //

        return new Money(12.9, Currency.getInstance("USD"));
    }

    public void attachTimeSheet(int i) {
    }

    ;
}

class Contractor extends Worker {

    private Invoice[] invoices;

    public Contractor(String name) {
        super(name);
    }

    @Override
    protected Money getAmountDue() {
        return new Money(32, Currency.getInstance("USD"));
    }

    public void attachInvoice(int i) {
    }
}

class AccountPayable {
    // Worker[] workers; wee needed to decouple this!
    Payable[] creditors;

    public void payEverybody() {
        for (Payable creditor : creditors) {
            creditor.pay();
        }
    }
}
