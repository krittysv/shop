package com.thoughtworks.shop.model;

public class Bill {
    private double totalPrice;
    private double actualPriceToBePaid;

    private double calculateTotalPrice(ShoppingCart shoppingCart) {
        shoppingCart.itemsInCart.forEach((itemToBeBilled) -> totalPrice += itemToBeBilled.unitPrice * itemToBeBilled.quantity);
        return totalPrice;
    }

    private double calculateActualPriceToBePaid() {
        Discount discount = null;
        if (totalPrice > 5000) discount = Discount.TotalAmountAbove5000;
        if (totalPrice > 2000) discount = Discount.TotalAmountAbove2000;
        actualPriceToBePaid = totalPrice;
        if (discount != null && discount.isApplicable(totalPrice)) {
            actualPriceToBePaid = discount.applyDiscount(totalPrice);
            System.out.print("Discount Applied: ");
            System.out.format("%9.2f \n", (totalPrice - actualPriceToBePaid));
        }
        return actualPriceToBePaid;
    }

    public void display(ShoppingCart shoppingCart) {
        shoppingCart.display();
        totalPrice = this.calculateTotalPrice(shoppingCart);
        System.out.print("Total Price: ");
        System.out.format("%9.2f \n", totalPrice);
        actualPriceToBePaid = this.calculateActualPriceToBePaid();
        System.out.print("Actual Amount to be Paid: ");
        System.out.format("%9.2f \n\n", actualPriceToBePaid);
        //System.out.print("---------------- Thank You for shopping with us! ----------------\n\n");
    }
}
