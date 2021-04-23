package com.company.basket;

import com.company.item.*;
import com.company.payment.Payable;
import com.company.user.User;

import java.util.ArrayList;
import java.util.Date;

public class StoreBasket implements IBasket {
    private static int nextId = 100000;
    private int id;
    private double netAmount;
    private double vat;
    private ArrayList<Item> items;
    private Date purchaseTime;
    private String storeAddress;
    private String cashierName;
    private double additionalDiscount;

    public StoreBasket( double vat, String storeAddress, String cashierName) {
        this.id = ++nextId;
        this.vat = vat;
        this.items = new ArrayList<>();
        this.storeAddress = storeAddress;
        this.cashierName = cashierName;
        this.additionalDiscount = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(double netAmount) {
        this.netAmount = netAmount;
    }

    public double getVat() {
        return vat;
    }

    public void setVat(double vat) {
        this.vat = vat;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public Date getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(Date purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getCashierName() {
        return cashierName;
    }

    public void setCashierName(String cashierName) {
        this.cashierName = cashierName;
    }

    public double getAdditionalDiscount() {
        return additionalDiscount;
    }

    public void setAdditionalDiscount(double additionalDiscount) {
        this.additionalDiscount = additionalDiscount;
    }

    public void insertNewItem(Item item){
        this.items.add(item);

    }

    public void removeItem(Item item){
        this.items.remove(item);
    }

    public void applyDiscount(int percentage){
        this.additionalDiscount = additionalDiscount+netAmount*percentage/100;
    }
    public void applyCouponDiscount(double amountOfDiscount){
        this.additionalDiscount = additionalDiscount+amountOfDiscount;
    }


    @Override
    public double calculatePayment() {
        this.netAmount = 0;
        for (Item item :
                items) {
            double priceAfterDiscount = item.getPrice();
            if (item instanceof BuyMorePayLess){
                priceAfterDiscount = (item.getPrice()*((BuyMorePayLess) item).getBuyQuantity()) - ((BuyMorePayLess) item).calculateDiscount();
            }
            else if (item instanceof DiscountIndependence){
                priceAfterDiscount = item.getPrice() - ((DiscountIndependence) item).calculateDiscount();
            }
            else if (item instanceof ItemTakeItAll){
                priceAfterDiscount = item.getPrice() - ((ItemTakeItAll) item).calculateDiscount();
            }
            else if (item instanceof ItemWithDiscount){
                priceAfterDiscount = item.getPrice() - ((ItemWithDiscount) item).calculateDiscount();
            }
            this.netAmount = netAmount+priceAfterDiscount;
        }

        return this.netAmount+(netAmount*(vat/100))-additionalDiscount;
    }

    @Override
    public void completePayment() {
        this.purchaseTime = new Date();
    }

    @Override
    public String toString() {
        return "StoreBasket{" +
                "netAmount=" + netAmount +
                ", vat=" + vat +
                ", items=" + items +
                ", purchaseTime=" + purchaseTime +
                ", storeAddress='" + storeAddress + '\'' +
                ", cashierName='" + cashierName + '\'' +
                '}';
    }

}
