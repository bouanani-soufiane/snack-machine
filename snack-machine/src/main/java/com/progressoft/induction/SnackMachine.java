package com.progressoft.induction;

public class SnackMachine {
    static final Integer DEFAULT_QUANTITY = 10;

    private Money moneyInside;
    private Money moneyInTransaction;

    private Snack chewingGums;
    private Snack chips;
    private Snack chocolates;

    public SnackMachine() {
        this.moneyInside = Money.ZERO;
        this.moneyInTransaction = Money.ZERO;
        this.chewingGums = new Snack(DEFAULT_QUANTITY, SnackType.CHEWING_GUM.price());
        this.chips = new Snack(DEFAULT_QUANTITY, SnackType.CHIPS.price());
        this.chocolates = new Snack(DEFAULT_QUANTITY, SnackType.CHOCOLATE.price());

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

    public Snack chewingGums() {
        return chewingGums;
    }

    public Snack chips() {
        return chips;
    }

    public Snack chocolates() {
        return chocolates;
    }

    public void buySnack ( SnackType snackType ) {
    }
}
