package com.company.user.employee;

import com.company.payment.Payable;
import com.company.user.User;
import java.util.Date;

public class Cashier extends User implements Payable {
    private String internalPhoneNumber;
    private double hoursOfWork;
    private double baseSalary;
    private Date lastLoginTime;
    private double bonus;

    public Cashier(String name, String surname, String username, String password, String address, String phoneNumber, String internalPhoneNumber, double baseSalary) {
        super(name, surname, username, password, address, phoneNumber);
        this.internalPhoneNumber = internalPhoneNumber;
        this.baseSalary = baseSalary;
        this.hoursOfWork = 0;
        this.bonus = 0;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getInternalPhoneNumber() {
        return internalPhoneNumber;
    }

    public void setInternalPhoneNumber(String internalPhoneNumber) {
        this.internalPhoneNumber = internalPhoneNumber;
    }

    public double getHoursOfWork() {
        return hoursOfWork;
    }

    public void setHoursOfWork(double hoursOfWork) {
        this.hoursOfWork = hoursOfWork;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public void setLastLoginTime(){
        this.lastLoginTime = new Date();
    }

    public void calculateExtraHours(){
        Date currentDate = new Date();
        double todayHoursOfWork = (double) (currentDate.getTime() - lastLoginTime.getTime())/(1000*60*60);
        this.hoursOfWork = hoursOfWork+todayHoursOfWork;
        if (todayHoursOfWork > 8){
            this.bonus = this.bonus+((todayHoursOfWork-8)*10);
        }
    }

    @Override
    public double calculatePayment() {
        return baseSalary+bonus;
    }
}
