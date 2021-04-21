package com.company.basket;

import com.company.user.customer.LoyalCustomer;
import java.util.Date;

public class LoyalCustomerBasket extends StoreBasket {
    private LoyalCustomer loyalCustomer;

    public LoyalCustomerBasket(double vat, String storeAddress, String cashierName, LoyalCustomer loyalCustomer) {
        super(vat, storeAddress, cashierName);
        this.loyalCustomer = loyalCustomer;
    }


    public LoyalCustomer getLoyalCustomer() {
        return loyalCustomer;
    }

    public void setLoyalCustomer(LoyalCustomer loyalCustomer) {
        this.loyalCustomer = loyalCustomer;
    }

    @Override
    public double calculatePayment() {
        return super.calculatePayment() - loyalCustomer.calculateBonus();
    }

    @Override
    public void completePayment() {
        super.setPurchaseTime(new Date());
        int newPoint = (int) (super.getNetAmount()/5);
        loyalCustomer.calculatePointAfterPurchase(newPoint);
    }
}
