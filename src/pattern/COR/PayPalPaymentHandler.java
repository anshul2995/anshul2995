package pattern.COR;

public class PayPalPaymentHandler extends PaymentHandler{
    @Override
    void payment(double amount) {
        if (amount <= 1500) {
            System.out.println("handled via paypal");
        } else {
            next.payment(amount);
        }
    }
}
