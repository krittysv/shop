package com.thoughtworks.shop.model;

public class MockBill extends Bill {
    boolean isCalled = false;

    @Override
    public void display(ShoppingCart shoppingCart) {
        isCalled = true;
    }
}
