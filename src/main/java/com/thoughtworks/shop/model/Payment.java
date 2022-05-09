package com.thoughtworks.shop.model;

public class Payment {
    PaymentStatus status;

    public void makePayment(Bill bill, ShoppingCart shoppingCart) {
        bill.display(shoppingCart);
        status = PaymentStatus.SUCCESSFUL;
    }
}
