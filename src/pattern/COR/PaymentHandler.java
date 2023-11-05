package src.pattern.COR;

public abstract class PaymentHandler {
    PaymentHandler next;

    void setNext(PaymentHandler next) {
        this.next = next;
    }

    abstract void payment(double amount);
}
