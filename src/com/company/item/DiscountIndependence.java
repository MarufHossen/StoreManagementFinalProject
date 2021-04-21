package com.company.item;

public class DiscountIndependence extends ItemWithDiscount implements Discount{
    private double discountIndependence;

    public DiscountIndependence(String name, double price) {
        super(name, price);
        this.discountIndependence = 0;
    }

    public double getDiscountIndependence() {
        return discountIndependence;
    }

    public void setDiscountIndependence(double discountIndependence) {
        this.discountIndependence = discountIndependence;
    }

    @Override
    public double calculateDiscount() {
        return super.getDiscountAmount() + this.discountIndependence;
    }

    @Override
    public void printInfo() {
        System.out.println("id " + super.getId());
        System.out.println("Name: " + super.getName());
        System.out.println("Price: " + super.getPrice());
        System.out.println("Discount: " + this.calculateDiscount());
    }

}
