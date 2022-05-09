package com.thoughtworks.shop.model;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class PurchaseItemTest {
    @Test
    void shouldReturnSubTotalPriceWhenQuantityIsGiven() {
        PurchaseItem toblerone = new PurchaseItem(111, "Toblerone", 180, 3);
        double expected = 540.00;

        double subTotalPrice = toblerone.getSubTotalPrice();

        assertThat(expected, is(equalTo(subTotalPrice)));
    }
}
