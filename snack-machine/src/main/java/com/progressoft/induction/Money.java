package com.progressoft.induction;

import java.math.BigDecimal;

public class Money {
    private final BigDecimal amount;

    public static final Money ZERO = new Money(BigDecimal.ZERO);
    public static final Money QUARTER_DINAR = new Money(BigDecimal.valueOf(0.25));
    public static final Money HALF_DINAR = new Money(BigDecimal.valueOf(0.5));
    public static final Money DINAR = new Money(BigDecimal.valueOf(1));
    public static final Money FIVE_DINAR = new Money(BigDecimal.valueOf(5));
    public static final Money TEN_DINAR = new Money(BigDecimal.valueOf(10));

    public Money(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Money amount must be non-negative");
        }
        this.amount = amount;
    }

    public Money add(Money other) {
     return null;
    }

    public Money subtract(Money other) {
        return null;
    }

    public boolean isLessThan(Money other) {
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Money otherMoney = (Money) obj;
        return amount.equals(otherMoney.amount);
    }

    @Override
    public int hashCode() {
        return amount.hashCode();
    }


    @Override
    public String toString() {
        return "Money{" + "amount=" + amount + '}';
    }
}
