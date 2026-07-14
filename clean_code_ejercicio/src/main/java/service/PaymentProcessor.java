package service;

public class PaymentProcessor {


    public Receipt processPayment(Payment p) {
        if (p == null) {
            throw new IllegalArgumentException("Payment no puede ser null");
        }
        if (p.getAmount() <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor a 0");
        }
        if (p.getCard() == null) {
            throw new IllegalArgumentException("La tarjeta no puede ser null");
        }

        try {
            return gateway.charge(p);
        } catch (Exception e) {
            throw new RuntimeException("Error al procesar el pago", e);
        }
    }




}

