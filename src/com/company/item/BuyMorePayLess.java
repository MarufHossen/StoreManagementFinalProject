package com.company.item;

public class BuyMorePayLess extends Item{
    private int minimumQuantityLimit = 10;
    private int buyQuantity;
    private int payForQuantity;

    public BuyMorePayLess(String name, double price) {
        super(name, price);
    }

    public int getMinimumQuantityLimit() {
        return minimumQuantityLimit;
    }

    public void setMinimumQuantityLimit(int minimumQuantityLimit) {
        this.minimumQuantityLimit = minimumQuantityLimit;
    }

    public int getBuyQuantity() {
        return buyQuantity;
    }

    public void setBuyQuantity(int buyQuantity) {
        this.buyQuantity = buyQuantity;
    }

    public int getPayForQuantity() {
        return payForQuantity;
    }

    public void setPayForQuantity(int payForQuantity) {
        this.payForQuantity = payForQuantity;
    }

    @Override
    public double calculateDiscount() {
        return super.getPrice()*buyQuantity - super.getPrice() * payForQuantity;
    }

    @Override
    public void printInfo() {
        System.out.println("id " + super.getId());
        System.out.println("Name: " + super.getName());
        System.out.println("Price: " + super.getPrice());
        System.out.println("Discount: " + this.calculateDiscount());
    }
}
