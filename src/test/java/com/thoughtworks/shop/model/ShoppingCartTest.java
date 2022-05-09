package com.thoughtworks.shop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShoppingCartTest {
    ShoppingCart shoppingCart = new ShoppingCart();

    @Test
    void shouldAddItemsToCartWhenAddItemMethodIsCalled() {
        PurchaseItem itemInCart = new PurchaseItem(111, "Bournville", 94, 1);

        shoppingCart.addItem(itemInCart);

        boolean isCartEmpty = shoppingCart.itemsInCart.isEmpty();
        assertFalse(isCartEmpty);
    }

    @Test
    void shouldReturnTrueIfCartIsEmpty() {
        boolean isCartEmpty = shoppingCart.itemsInCart.isEmpty();

        assertTrue(isCartEmpty);
    }

}
