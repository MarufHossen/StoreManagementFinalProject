package com.company.item;

public class Item implements Discount{

    private static int nextId = 100000;
    private int id;
    private String name;
    private double price;

    public Item(String name, double price) {
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

    @Override
    public double calculateDiscount() {
        return 0;
    }

    @Override
    public void printInfo() {
        System.out.println("id " + this.id);
        System.out.println("Name: " + this.name);
        System.out.println("Price: " + this.price);
    }
}
