package com.company.strategies;

public class BuyMorePayLessStrategy implements DiscountStrategy {
    private double regularPrice;
    private int buyMoreQuantity;
    private int payForQuantity;
    private int limit;

    public BuyMorePayLessStrategy(double regularPrice, int buyMoreQuantity, int payForQuantity) {
        this.regularPrice = regularPrice;
        this.buyMoreQuantity = buyMoreQuantity;
        this.payForQuantity = payForQuantity;
        limit = 10;
    }


    @Override
    public double calculateDiscount() {
        return regularPrice*payForQuantity;
    }
}
