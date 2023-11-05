package pattern.COR;

public class BankPaymentHandler extends PaymentHandler{
    @Override
    void payment(double amount) {
        if (amount <= 600) {
            System.out.println("handled via bank");
        } else {
            next.payment(amount);
        }
    }
}
