package com.thoughtworks.shop.model;

public class Item {
    int id;
    protected String name;
    protected double unitPrice;

    public Item(int id, String name, double unitPrice) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
    }
}
