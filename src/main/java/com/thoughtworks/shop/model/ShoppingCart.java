package com.thoughtworks.shop.model;

import java.util.ArrayList;
import java.util.Objects;

public class ShoppingCart {
    ArrayList<PurchaseItem> itemsInCart = new ArrayList<>();

    public void addItem(PurchaseItem purchaseItem) {
        for (PurchaseItem item : itemsInCart) {
            boolean isItemAlreadyInCart = Objects.equals(purchaseItem.id, item.id);
            if (isItemAlreadyInCart) {
                updateCart(item, purchaseItem.quantity);
                return;
            }
        }
        itemsInCart.add(purchaseItem);
    }

    private void updateCart(PurchaseItem item, int quantity) {
        //TODO: Check updated purchase quantity is in stock
        item.quantity += quantity;
    }

    void display() {
        System.out.format("------------------------------------------------------------------------------");
        System.out.print("\nID\t\t\tItem\t\t\tUnit Price\t\tQuantity\t\tSub-Total Price \n");
        System.out.format("------------------------------------------------------------------------------\n");
        String formatPattern = "%-5d\t\t%-9s\t\t%9.2f \t\t%5d\t\t\t\t%9.2f \n";
        for (PurchaseItem purchaseItem : itemsInCart) {
            System.out.format(formatPattern,
                    purchaseItem.id,
                    purchaseItem.name,
                    purchaseItem.unitPrice,
                    purchaseItem.quantity,
                    purchaseItem.getSubTotalPrice());
        }
        System.out.format("------------------------------------------------------------------------------\n");
    }
}
