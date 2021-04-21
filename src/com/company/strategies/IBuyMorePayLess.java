package com.company.strategies;

public interface IBuyMorePayLess extends DiscountStrategy{
    public double calculateDiscount(double price);
}
