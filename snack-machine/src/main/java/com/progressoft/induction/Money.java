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
        validateAmount(amount);
        this.amount = amount.stripTrailingZeros();
    }

    public Money add(Money money) {
        if (money == null) {
            throw new IllegalArgumentException("Cannot add null money");
        }
        validateAmount(money.amount);
        return new Money(this.amount.add(money.amount));
    }

    public Money subtract(Money money) {
        if (money == null) {
            throw new IllegalArgumentException("Cannot subtract null money");
        }
        BigDecimal result = this.amount.subtract(money.amount);

        if (result.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Resulting money cannot be negative");
        }
        return new Money(result);
    }

    public boolean isLessThan(Money other) {
        if (other == null) {
            return false;
        }
        return this.amount.compareTo(other.amount) < 0;
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
        return this.amount.compareTo(otherMoney.amount) == 0;
    }

    @Override
    public int hashCode() {
        return amount.stripTrailingZeros().hashCode();
    }

    @Override
    public String toString() {
        return "Money{" + "amount = " + amount + '}';
    }

    private void validateAmount(BigDecimal amount) {
        if (amount == null)
            throw new IllegalArgumentException("Amount cannot be null");

        if (amount.compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("Negative amount not accepted");

    }
}
