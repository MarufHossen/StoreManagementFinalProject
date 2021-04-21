package com.company.strategies;

public class ItemWithDiscountStrategy implements DiscountStrategy{
    private double discount;

    public ItemWithDiscountStrategy(double discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public double calculateDiscount() {
        return discount;
    }
}
