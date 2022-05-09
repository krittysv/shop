package com.thoughtworks.shop.model;

import com.thoughtworks.shop.exceptions.OutOfStockException;

import java.util.ArrayList;
import java.util.Objects;

public class Inventory {
    ArrayList<StockItem> stockItems = new ArrayList<>();
    //int numberOfItemsInInventory = 0;

    public Inventory() {
        loadInventory();
        display();
    }

    void loadInventory() {
        StockItem toblerone = new StockItem(111, "Toblerone", 690, 40);
        StockItem kitkat = new StockItem(222, "KitKat", 50, 50);
        StockItem galaxy = new StockItem(333, "Galaxy", 120, 100);
        StockItem snickers = new StockItem(444, "Snickers", 560, 60);

        addItem(toblerone);
        addItem(kitkat);
        addItem(galaxy);
        addItem(snickers);
    }

    void addItem(StockItem stockItem) {
        stockItems.add(stockItem);
    }

    private void removeItem(StockItem stockItem) {
        stockItems.remove(stockItem);
    }

    double getItemUnitPrice(int itemID) {
        for (StockItem stockItem : stockItems) {
            if (Objects.equals(stockItem.id, itemID)) {
                return stockItem.unitPrice;
            }
        }
        return 0;
    }

    String getItemName(int itemID) {
        for (StockItem stockItem : stockItems) {
            if (Objects.equals(stockItem.id, itemID)) {
                return stockItem.name;
            }
        }
        return null;
    }

    boolean isItemAvailable(int itemID) throws OutOfStockException {
        return isItemInStock(itemID, 1);
    }

    boolean isItemInStock(int itemID, int quantity) throws OutOfStockException {
        for (StockItem stockItem : this.stockItems) {
            if (Objects.equals(stockItem.id, itemID)) {
                if (quantity <= stockItem.stock)
                    return true;
                throw new OutOfStockException();
            }
        }
        throw new OutOfStockException();
    }

    void updateStock(ShoppingCart shoppingCart) {
        shoppingCart.itemsInCart.forEach((itemInCart) -> {
            for (StockItem stockItem : stockItems) {
                if (Objects.equals(itemInCart.id, stockItem.id)) {
                    stockItem.stock -= itemInCart.quantity;
                    int minimumStockLevel = 1;
                    if (stockItem.stock < minimumStockLevel)
                        removeItem(stockItem);
                }
            }
        });
    }

    void display() {
        System.out.format("--------------------------------------------------");
        System.out.print("\nID\t\t\tItem\t\t\tUnit Price\t\tStock \n");
        System.out.format("--------------------------------------------------\n");
        String formatPattern = "%-5d\t\t%-9s\t\t%9.2f \t\t%5d\n";
        for (StockItem stockItem : stockItems) {
            System.out.format(formatPattern,
                    stockItem.id,
                    stockItem.name,
                    stockItem.unitPrice,
                    stockItem.stock);
        }
        System.out.format("--------------------------------------------------\n");
    }
}
