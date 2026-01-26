
package com.mycompany.exfour;
public class ShoppingCart {

    private PaymentStrategy paymentStrategy; // strategy hiện tại

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy; // thay đổi strategy lúc runtime
    }

    public void checkout(int amount) {
        if (paymentStrategy == null) {
            System.out.println("Chua chon phuong thuc thanh toan!");
            return;
        }
        paymentStrategy.pay(amount); // gọi strategy tương ứng
    }
}
