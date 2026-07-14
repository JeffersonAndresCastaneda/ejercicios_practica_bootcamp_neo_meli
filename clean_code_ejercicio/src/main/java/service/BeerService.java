package service;

public class BeerService {

    private final int EDAD_MINIMA= 21;
    private final double PRECIO_CERVEZA = 5.99;



    public boolean canBuyBeer(int age, double money) {
         return age >= EDAD_MINIMA && money >= PRECIO_CERVEZA;
         }

}
