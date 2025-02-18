package com.progressoft.induction;

public class SnackMachine {
    static final Object DEFAULT_QUANTITY = 10;

    private Money moneyInside;

    public SnackMachine() {
        this.moneyInside = Money.ZERO;
    }

    public Money moneyInside () {
        return moneyInside;
    }

    public void insertMoney ( Object quarterDinar ) {
    }

    public boolean moneyInTransaction () {
        return false;
    }

    public Object chewingGums () {
        return null;
    }

    public Object chips () {
        return null;
    }

    public Object chocolates () {
        return null;
    }

    public void buySnack ( SnackType snackType ) {
    }
}
