
package com.mycompany.exfour;
public class CreditCardPayment implements PaymentStrategy {

    private String cardNumber; // số thẻ

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber; // gán số thẻ
    }

    @Override
    public void pay(int amount) {
        System.out.println("Thanh toan " + amount + " bằng The tin dung: " + cardNumber);
    }
}
