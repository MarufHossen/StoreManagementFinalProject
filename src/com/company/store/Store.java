package com.company.store;

import com.company.basket.StoreBasket;
import com.company.discount.Coupon;
import com.company.item.Item;
import com.company.user.employee.*;
import java.util.ArrayList;

public class Store {
    private int id;
    private static int nextId = 100001;
    private ArrayList<StoreBasket> allBaskets;
    private ArrayList<StoreBasket> paidBaskets;
    private ArrayList<Item> allStoreItems;
    private Manager manager;
    private ArrayList<Cashier> cashiers;
    private ArrayList<Coupon> coupons;

    public Store(ArrayList<Cashier> cashiers, Manager manager) {
        this.id = ++nextId;
        this.allBaskets = new ArrayList<>();
        this.paidBaskets = new ArrayList<>();
        this.allStoreItems = new ArrayList<>();
        this.coupons = new ArrayList<>();
        this.cashiers = cashiers;
        this.manager = manager;
    }

    public ArrayList<StoreBasket> getAllBaskets() {
        return allBaskets;
    }

    public void setAllBaskets(ArrayList<StoreBasket> allBaskets) {
        this.allBaskets = allBaskets;
    }

    public ArrayList<StoreBasket> getPaidBaskets() {
        return paidBaskets;
    }

    public void setPaidBaskets(ArrayList<StoreBasket> paidBaskets) {
        this.paidBaskets = paidBaskets;
    }

    public ArrayList<Item> getAllStoreItems() {
        return allStoreItems;
    }

    public void setAllStoreItems(ArrayList<Item> allStoreItems) {
        this.allStoreItems = allStoreItems;
    }

    public StoreBasket getBasketById(int id){
       return allBaskets.stream().filter(storeBasket -> storeBasket.getId() == id).findFirst().orElse(null);
    }

    public Item getItemById(int id){
       return allStoreItems.stream().filter(item -> item.getId() == id).findFirst().orElse(null);
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public ArrayList<Cashier> getCashiers() {
        return cashiers;
    }

    public void setCashiers(ArrayList<Cashier> cashiers) {
        this.cashiers = cashiers;
    }

    public ArrayList<Coupon> getCoupons() {
        return coupons;
    }

    public void setCoupons(ArrayList<Coupon> coupons) {
        this.coupons = coupons;
    }

    public void updateCashierById(int cashierId, Cashier updatedCashier ){
        cashiers.forEach(cashier -> {
          if (cashier.getId() == cashierId) {
                cashier = updatedCashier;
          }
        });
    }
    public void updateItemById(int itemId, Item updatedItem ){
        allStoreItems.forEach(item -> {
          if (item.getId() == itemId) {
                item = updatedItem;
          }
        });
    }
    public void updateBasketById(int basketId, StoreBasket updatedBasket ){
        allBaskets.forEach(basket -> {
          if (basket.getId() == basketId) {
                basket = updatedBasket;
          }
        });
    }

    public void addBasket(StoreBasket storeBasket){
        this.allBaskets.add(storeBasket);
    }

    public void addCoupon(Coupon generatedCoupon) {
        coupons.add(generatedCoupon);
    }

    public Coupon getCouponByCouponCode(int couponCode){
        return coupons.stream().filter(coupon -> coupon.getCouponCode() == couponCode).findFirst().orElse(null);
    }

    @Override
    public String toString() {
        return "Store{" +
                "allBaskets=" + allBaskets +
                ", paidBaskets=" + paidBaskets +
                ", allStoreItems=" + allStoreItems +
                '}';
    }

}
