package NotKasse.model;

import NotKasse.service.VATCalculate;

public class Konsumgueter extends Product implements VATCalculate {
    private static final double VAT_RATE = 0.19;
    public Konsumgueter(String name, double price) {
        super(name, price);
    }

    @Override
    public double calculateVAT() {
        return price * VAT_RATE;
    }
    public String toString() {
        return "< Code to insert | Konsumgueter product: " +
                name +
                ", price= " + price
                ;
    }
}
