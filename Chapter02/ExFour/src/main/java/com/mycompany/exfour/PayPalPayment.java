
package com.mycompany.exfour;
public class PayPalPayment implements PaymentStrategy {

    private String email; // email PayPal

    public PayPalPayment(String email) {
        this.email = email; // gán email
    }

    @Override
    public void pay(int amount) {
        System.out.println("Thanh toan " + amount + " bang PayPal: " + email);
    }
}
