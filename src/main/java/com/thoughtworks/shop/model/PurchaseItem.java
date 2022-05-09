package com.thoughtworks.shop.model;

public class PurchaseItem extends Item {
    int quantity;

    public PurchaseItem(int itemID, String itemName, double unitPrice, int quantity) {
        super(itemID, itemName, unitPrice);
        this.quantity = quantity;
    }

    public double getSubTotalPrice() {
        return this.unitPrice * quantity;
    }
}
