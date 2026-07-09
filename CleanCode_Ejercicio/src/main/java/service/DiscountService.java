package service;

public class DiscountService {

    private static final double TASA_DESCUENTO_VIP = 0.15;
    private static final double TASA_DESCUENTO_PREMIUM = 0.15;

    public double calcularDescuento(double price, double tasa) {
        return price * tasa;
    }

}
