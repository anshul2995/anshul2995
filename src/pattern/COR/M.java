package pattern.COR;

public class M {

    public static void main(String[] args) {
        PaymentHandler b = new BankPaymentHandler();
        PaymentHandler bc= new CreditCardPaymentHandler();
        PaymentHandler pp = new PayPalPaymentHandler();

        b.setNext(bc);
        bc.setNext(pp);

        b.payment(300);
        b.payment(800);
        b.payment(1500);
    }
}
