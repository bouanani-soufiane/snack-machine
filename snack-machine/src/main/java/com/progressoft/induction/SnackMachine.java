package com.progressoft.induction;

public class SnackMachine {
    static final Object DEFAULT_QUANTITY = 10;

    private Money moneyInside;
    private Money moneyInTransaction;


    public SnackMachine() {
        this.moneyInside = Money.ZERO;
        this.moneyInTransaction = Money.ZERO;

    }

    public void insertMoney(Money money) {
        if (money == null) {
            throw new IllegalArgumentException("Money cannot be null");
        }
        if (!(money.equals(Money.QUARTER_DINAR) ||
                money.equals(Money.HALF_DINAR) ||
                money.equals(Money.DINAR) ||
                money.equals(Money.FIVE_DINAR) ||
                money.equals(Money.TEN_DINAR))) {
            throw new IllegalArgumentException("Unsupported money unit");
        }
        moneyInTransaction = moneyInTransaction.add(money);
    }
    public Money moneyInside () {
        return moneyInside;
    }

    public Money moneyInTransaction() {
        return moneyInTransaction;
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
