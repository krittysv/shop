package com.thoughtworks.shop.model;

import com.thoughtworks.shop.exceptions.OutOfStockException;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InventoryTest {
    Inventory inventory = new Inventory();

    @Test
    void shouldLoadInventoryWithStock() {
        boolean isInventoryLoaded = inventory.stockItems.size() > 1;

        assertTrue(isInventoryLoaded);
    }

    @Test
    void shouldReturnTrueWhenItemIsInStock() throws OutOfStockException {
        int itemIdOfItemToBePurchased = 111;
        int quantityToBePurchased = 1;

        boolean inStock = inventory.isItemInStock(itemIdOfItemToBePurchased, quantityToBePurchased);

        assertTrue(inStock);
    }

    @Test
    void shouldAddItemsToInventory() {
        StockItem itemInInventory = new StockItem(1, "Twix", 100, 2);

        inventory.addItem(itemInInventory);

        assertFalse(inventory.stockItems.isEmpty());
    }

    @Test
    void shouldReturnUnitPriceOfItemInInventory() {
        double expectedUnitPrice = 690;

        double unitPrice = inventory.getItemUnitPrice(111);

        assertThat(expectedUnitPrice, is(equalTo(unitPrice)));
    }

    @Test
    void shouldUpdateStockWhenPurchaseIsMade() {
        //TODO: Write test
    }
}
