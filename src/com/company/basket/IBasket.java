package com.company.basket;

import com.company.payment.Payable;

public interface IBasket extends Payable {
    public void completePayment();
}
