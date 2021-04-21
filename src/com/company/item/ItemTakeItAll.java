package com.company.item;

public class ItemTakeItAll extends ItemWithDiscount{
    private int minimumItemsToPurchase;
    private double discountForTakeItAll;

    public ItemTakeItAll(String name, double price) {
        super(name, price);
        this.discountForTakeItAll = 0;
    }


    public double getDiscountForTakeItAll() {
        return discountForTakeItAll;
    }

    public void setDiscountForTakeItAll(double discountForTakeItAll) {
        this.discountForTakeItAll = discountForTakeItAll;
    }

    public int getMinimumItemsToPurchase() {
        return minimumItemsToPurchase;
    }

    public void setMinimumItemsToPurchase(int minimumItemsToPurchase) {
        this.minimumItemsToPurchase = minimumItemsToPurchase;
    }

    @Override
    public double calculateDiscount() {
        return super.getDiscountAmount() + super.getPrice()*20/100;
    }

    @Override
    public void printInfo() {
        System.out.println("id " + super.getId());
        System.out.println("Name: " + super.getName());
        System.out.println("Price: " + super.getPrice());
        System.out.println("Discount: " + this.calculateDiscount());
    }
}
