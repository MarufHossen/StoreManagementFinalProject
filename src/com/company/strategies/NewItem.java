package com.company.strategies;

public class NewItem implements INewItem {

    private DiscountStrategy discountStrategy;
    private static int nextId = 100000;
    private int id;
    private String name;
    private double price;

    public NewItem(String name, double price) {
        this.id = ++nextId;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void chooseDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }


    public double calculateDiscount() {
        return this.discountStrategy.calculateDiscount();
    }

    @Override
    public void printInfo() {
        System.out.println("id " + this.id);
        System.out.println("Name: " + this.name);
        System.out.println("Price: " + this.price);
    }
}
