package bai2;

interface Payment {
    void processPayment(double amount);
}
class CreditCardPayment implements Payment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Thanh toán " + amount + " bằng Credit Card.");
    }
}

class PayPalPayment implements Payment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Thanh toán " + amount + " bằng PayPal.");

    }
}


class CashPayment implements Payment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Thanh toán " + amount + " bằng Tiền mặt.");
    }
}