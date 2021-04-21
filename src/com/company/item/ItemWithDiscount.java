package com.company.item;

public class ItemWithDiscount extends Item{
    private double discountAmount;

    public ItemWithDiscount(String name, double price) {
        super(name, price);
        this.discountAmount = 0;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public double calculateDiscount(){
            return discountAmount;
    }

    @Override
    public void printInfo() {
        System.out.println("id " + super.getId());
        System.out.println("Name: " + super.getName());
        System.out.println("Price: " + super.getPrice());
        System.out.println("Discount Amount: " + this.calculateDiscount());
    }
}
