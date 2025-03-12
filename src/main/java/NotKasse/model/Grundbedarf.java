package NotKasse.model;

import NotKasse.service.VATCalculate;

public class Grundbedarf extends Product implements VATCalculate {
    private static final double VAT_RATE = 0.07;

    public Grundbedarf(String name, double price) {
        super(name, price);
    }

    @Override
    public double calculateVAT() {
        return price * VAT_RATE;
    }

    @Override

        public String toString() {
            return "<Code to insert | Grundbedarf product: " +
                    name +
                    ", price= " + price
                    ;
        }
}
