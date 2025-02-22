package com.progressoft.induction;

import java.math.BigDecimal;

public enum SnackType {
    CHEWING_GUM(Money.HALF_DINAR),
    CHIPS(Money.DINAR),
    CHOCOLATE(new Money(BigDecimal.valueOf(2)));

    private final Money price;

    SnackType(Money price) {
        this.price = price;
    }

    public Money price() {
        return price;
    }
}
