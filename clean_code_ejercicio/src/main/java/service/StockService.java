package service;

public class StockService {

    public double getStockPrice(String symbol) {
        Map<String, Double> prices = loadPrices();
        if (!prices.containsKey(symbol)) {
            throw new SimboloNotFoundException("Símbolo '" + symbol + "' no existe");
        }
        return prices.get(symbol);
    }


    try {
        double precio = getStockPrice("AAPL");
        calcularGanancia(precio);
    } catch (SimboloNotFoundException e) {

    }

}



