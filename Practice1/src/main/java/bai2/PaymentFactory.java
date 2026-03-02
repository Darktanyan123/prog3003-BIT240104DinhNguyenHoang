package bai2;

abstract class PaymentFactory {
    public abstract Payment createPayment();

    public void executePayment(double amount) {
        Payment payment = createPayment();
        payment.processPayment(amount);
    }
}
class CreditCardFactory extends PaymentFactory {
    @Override
    public Payment createPayment() {
        return new CreditCardPayment();
    }
}

class PayPalFactory extends PaymentFactory {
    @Override
    public Payment createPayment() {
        return new PayPalPayment();
    }
}

class CashFactory extends PaymentFactory {
    @Override
    public Payment createPayment() {
        return new CashPayment();
    }
}