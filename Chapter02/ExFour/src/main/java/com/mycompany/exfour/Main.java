
package com.mycompany.exfour;
public class Main {
    public static void main(String[] args) {

        ShoppingCart cart = new ShoppingCart();

        cart.setPaymentStrategy(new CreditCardPayment("1234-5678-9999"));
        cart.checkout(500); // thanh toán bằng thẻ

        cart.setPaymentStrategy(new PayPalPayment("user@gmail.com"));
        cart.checkout(300); // đổi sang PayPal lúc runtime
    }
}
