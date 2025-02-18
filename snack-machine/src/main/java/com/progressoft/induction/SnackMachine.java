package com.progressoft.induction;

public class SnackMachine {
    static final Long DEFAULT_QUANTITY = 10L;

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


    public Money buySnack(SnackType snackType) {
        Snack snack;
        switch (snackType) {
            case CHEWING_GUM:
                snack = chewingGums;
                break;
            case CHIPS:
                snack = chips;
                break;
            case CHOCOLATE:
                snack = chocolates;
                break;
            default:
                throw new IllegalArgumentException("Snack not found");
        }
        if (snack.quantity() <= 0) {
            throw new IllegalStateException("Snack is not available");
        }
        if (moneyInTransaction().isLessThan(snack.price())) {
            throw new IllegalStateException("Insufficient money inserted");
        }
        snack.dispense();
        Money change = moneyInTransaction.subtract(snack.price());
        moneyInside = moneyInside.add(snack.price());
        moneyInTransaction = Money.ZERO;
        return change;
    }
}
