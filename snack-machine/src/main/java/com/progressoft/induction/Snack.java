package com.progressoft.induction;

public class Snack {
    private long quantity;
    private final Money price;

    public Snack(long quantity, Money price) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        if (price == null) {
            throw new IllegalArgumentException("Price cannot be null");
        }
        this.quantity = quantity;
        this.price = price;
    }

    public long quantity() {
        return quantity;
    }

    public Money price() {
        return price;
    }

    public void dispense() {
        if (quantity <= 0) {
            throw new IllegalStateException("Snack is not available");
        }
        quantity--;
    }
}