package com.company.strategies;

public class DiscountIndependenceStrategy extends ItemWithDiscountStrategy{
    private double discountIndependence;

    public DiscountIndependenceStrategy(double discount, double discountIndependence) {
        super(discount);
        this.discountIndependence = discountIndependence;
    }

    @Override
    public double calculateDiscount() {
        return super.getDiscount()+this.discountIndependence;
    }
}
