package com.thoughtworks.shop;

import com.thoughtworks.shop.exceptions.OutOfStockException;
import com.thoughtworks.shop.model.Customer;
import com.thoughtworks.shop.model.Inventory;

public class Shop {
    public Inventory inventory = new Inventory();

    public static void main(String[] args) throws OutOfStockException {
        Shop shop = new Shop();
        new Customer(shop.inventory);
    }
}
