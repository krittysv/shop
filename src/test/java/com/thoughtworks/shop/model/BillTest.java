package com.thoughtworks.shop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BillTest {
    @Test
    void shouldDisplayBillWhenDisplayMethodIsCalled() {
        ShoppingCart shoppingCart = new ShoppingCart();
        MockBill mockBill = new MockBill();
        PurchaseItem itemInCart = new PurchaseItem(111, "Twix", 600, 1);

        shoppingCart.addItem(itemInCart);
        mockBill.display(shoppingCart);

        assertTrue(mockBill.isCalled);
    }
}
