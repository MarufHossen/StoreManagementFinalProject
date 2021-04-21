package com.company.discount;

public class Coupon {
    private int id;
    private static int nextId;
    private double discountAmount;
    private int couponCode;

    public Coupon(double discountAmount, int couponCode) {
        this.id = ++nextId;
        this.discountAmount = discountAmount;
        this.couponCode = couponCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public int getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(int couponCode) {
        this.couponCode = couponCode;
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "id=" + id +
                ", discountAmount=" + discountAmount +
                ", couponCode=" + couponCode +
                '}';
    }
}
