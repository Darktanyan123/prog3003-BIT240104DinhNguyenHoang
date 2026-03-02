package bai2;
public class Main {
    public static void main(String[] args) {

        PaymentFactory creditFactory = new CreditCardFactory();
        PaymentFactory paypalFactory = new PayPalFactory();
        PaymentFactory cashFactory = new CashFactory();

        creditFactory.executePayment(500.0);
        paypalFactory.executePayment(300.0);
        cashFactory.executePayment(150.0);
    }
}