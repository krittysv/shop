package com.thoughtworks.shop.model;

import com.thoughtworks.shop.exceptions.OutOfStockException;

import java.util.Scanner;

public class Customer {
    ShoppingCart shoppingCart = new ShoppingCart();
    Bill bill = new Bill();
    Payment payment = new Payment();

    Scanner scan = new Scanner(System.in);

    public Customer(Inventory inventory) throws OutOfStockException {
        giveDetailsOfItemsToBePurchased(inventory);
        requestBill();
        doPayment(inventory);
    }

    private void giveDetailsOfItemsToBePurchased(Inventory inventory) throws OutOfStockException {
        int itemID;
        String itemName = "";
        int quantity;
        double unitPrice = 0;
        char choice;
        System.out.println("Enter the items to be purchased: ");
        do {
            itemID = getItemId();
            if (inventory.isItemAvailable(itemID)) {
                unitPrice = inventory.getItemUnitPrice(itemID);
                itemName = inventory.getItemName(itemID);
            }
            quantity = getQuantityToBePurchased();
            addItemToCart(itemID, itemName, unitPrice, quantity, inventory);
            choice = doYouWantToContinue();
        } while (choice == 'y' || choice == 'Y');
    }

    private int getItemId() {
        System.out.print("Item ID: ");
        return scan.nextInt();
    }

    private int getQuantityToBePurchased() {
        System.out.print("Quantity: ");
        return scan.nextInt();
    }

    private void addItemToCart(int itemID, String itemName, double unitPrice, int quantity, Inventory inventory) throws OutOfStockException {
        PurchaseItem purchaseItem = new PurchaseItem(itemID, itemName, unitPrice, quantity);
        if (inventory.isItemInStock(itemID, quantity)) {
            shoppingCart.addItem(purchaseItem);
        }
    }

    private char doYouWantToContinue() {
        System.out.print("Want to add more items? (Yes[Y] | No[N]): ");
        return scan.next().charAt(0);
    }

    private void requestBill() {
        bill.display(shoppingCart);
    }

    private void doPayment(Inventory inventory) {
        System.out.print("Proceed to payment? (Yes[Y] | No[N]): ");
        char choicePayment;
        choicePayment = scan.next().charAt(0);
        scan.nextLine();

        if (choicePayment == 'y' || choicePayment == 'Y') {
            payment.makePayment(bill, shoppingCart);
            if (payment.status == PaymentStatus.SUCCESSFUL) {
                inventory.updateStock(shoppingCart);
                inventory.display();
            }
        }
    }
}
