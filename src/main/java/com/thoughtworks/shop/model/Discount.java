package com.thoughtworks.shop.model;

public enum Discount {
    TotalAmountAbove2000(5),
    TotalAmountAbove5000(10);

    private final double discountPercentage;

    Discount(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public boolean isApplicable(double totalPrice) throws NullPointerException {
        return totalPrice > 2000;
    }

    public double applyDiscount(double totalPrice) {
        if (totalPrice > 5000)
            return totalPrice - totalPrice * TotalAmountAbove5000.discountPercentage / 100;
        if (totalPrice > 2000)
            return totalPrice - totalPrice * TotalAmountAbove2000.discountPercentage / 100;
        return totalPrice;
    }
}
