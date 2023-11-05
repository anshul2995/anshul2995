package src.pattern.COR;

public class CreditCardPaymentHandler extends PaymentHandler{
    @Override
    void payment(double amount) {
        if (amount <= 1000) {
            System.out.println("handled via creditCard");
        } else {
            next.payment(amount);
        }
    }
}
