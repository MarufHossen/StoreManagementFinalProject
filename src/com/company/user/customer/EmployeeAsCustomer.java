package com.company.user.customer;

import com.company.user.User;

public class EmployeeAsCustomer extends User implements Customer {

    private int point;

    public EmployeeAsCustomer(String name, String surname, String username, String password, String address, String phoneNumber, int point) {
        super(name, surname, username, password, address, phoneNumber);
        this.point = point;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public double calculateBonus() {
        double bonusAmount = 0;
        if (point/100 >= 0){
            bonusAmount = point/100 * 50;
        }
        return bonusAmount;
    }

    @Override
    public void calculatePointAfterPurchase(int newPoint) {
        point =  point + newPoint;
    }
    @Override
    public void printInfo() {
        System.out.println("Name: "+ super.getName());
        System.out.println("Address: "+ super.getAddress());
        System.out.println("Phone Number: "+ super.getPhoneNumber());
        System.out.println("Point: "+ this.point);
    }

}
