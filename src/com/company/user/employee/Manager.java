package com.company.user.employee;

import com.company.payment.Payable;
import com.company.user.User;

public class Manager extends User implements Payable {
    private String internalPhoneNumber;
    private String pin;
    private double baseSalary;

    public Manager(String name, String surname, String username, String password, String address, String phoneNumber, String internalPhoneNumber, String pin, double baseSalary) {
        super(name, surname, username, password, address, phoneNumber);
        this.internalPhoneNumber = internalPhoneNumber;
        this.pin = pin;
        this.baseSalary = baseSalary;
    }

    public String getInternalPhoneNumber() {
        return internalPhoneNumber;
    }

    public void setInternalPhoneNumber(String internalPhoneNumber) {
        this.internalPhoneNumber = internalPhoneNumber;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    @Override
    public double calculatePayment() {
        return baseSalary;
    }
}
