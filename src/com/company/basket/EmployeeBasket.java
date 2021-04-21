package com.company.basket;


import com.company.item.Item;
import com.company.user.customer.EmployeeAsCustomer;
import java.util.Date;
import java.util.ArrayList;

public class EmployeeBasket extends StoreBasket {
    private EmployeeAsCustomer employeeAsCustomer;

    public EmployeeBasket(double vat, String storeAddress, String cashierName, EmployeeAsCustomer employeeAsCustomer) {
        super(vat, storeAddress, cashierName);
        this.employeeAsCustomer = employeeAsCustomer;
    }

    public EmployeeAsCustomer getEmployeeAsCustomer() {
        return employeeAsCustomer;
    }


    public void setEmployeeAsCustomer(EmployeeAsCustomer employeeAsCustomer) {
        this.employeeAsCustomer = employeeAsCustomer;
    }

    @Override
    public double calculatePayment() {
        return super.calculatePayment();
    }

    @Override
    public void completePayment() {
        super.setPurchaseTime(new Date());
        int newPoint = (int) (super.getNetAmount()/15);
        employeeAsCustomer.calculatePointAfterPurchase(newPoint);
    }
}
