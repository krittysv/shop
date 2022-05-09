package com.thoughtworks.shop.model;

public class StockItem extends Item {
    int stock;

    public StockItem(int ItemId, String itemName, double unitPrice, int stock) {
        super(ItemId, itemName, unitPrice);
        this.stock = stock;
    }
}
