package com.thoughtworks.shop.model;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class PaymentTest {
    @Test
    void shouldSetPaymentStatusAsSuccessfulWhenPaymentIsMade() {
        Payment payment = new Payment();
        ShoppingCart shoppingCart = new ShoppingCart();
        MockBill mockBill = new MockBill();

        payment.makePayment(mockBill, shoppingCart);

        assertThat(PaymentStatus.SUCCESSFUL, is(equalTo(payment.status)));
    }
}
