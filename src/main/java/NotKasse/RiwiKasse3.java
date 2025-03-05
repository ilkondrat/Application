package NotKasse;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class RiwiKasse3 {

    public static void main(String[] args) {
        double totalSum = 0;
        int totalQuantity = 0;
        double totalVAT = 0;

        Scanner scanner = new Scanner(System.in);

        Map<Integer, Product> productList = new TreeMap<>();
        productList.put(1, new Grundbedarf("Apfel", 0.5));
        productList.put(2, new Grundbedarf("Banane", 0.88));
        productList.put(3, new Grundbedarf("Orange", 1.59));
        productList.put(4, new Grundbedarf("Brot", 2.33));
        productList.put(5, new Grundbedarf("Milch", 1.19));
        productList.put(91, new Konsumgueter("TV", 1000.5));
        productList.put(92, new Konsumgueter("iPhone", 8990.88));
        productList.put(93, new Konsumgueter("Mac", 115.59));
        productList.put(94, new Konsumgueter("Handy", 1512.33));
        productList.put(95, new Konsumgueter("Beamer", 5451.19));

        System.out.println("Verfügbare Produkte und ihre Preise:");
        for (Map.Entry<Integer, Product> entry : productList.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " EUR");
        }

        System.out.println("\nBitte geben Sie die Produktnamen ein (zum Beenden '0' eingeben):");

        Map<Integer, Integer> purchasedProducts = new TreeMap<>();
        while (true) {
            System.out.print("Produktnummer oder '0' to exit: ");


            int productNumber = 0;
            try {
                productNumber = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
                continue;
            }

            if (productNumber == 0) {
                break;
            }

            if (productList.containsKey(productNumber)) {
                Integer quantity = null;
                do{
                System.out.print("Bitte geben Sie die gewuenschte Menge ein: ");
                try {
                    quantity = Integer.parseInt(scanner.nextLine().trim());
                    if (quantity <= 0) {
                        System.out.println("Menge muss groesser als 0 sein.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ungueltige Eingabe.");
                }
                } while (quantity == null || quantity <= 0);
                Product product = productList.get(productNumber);
                double price = product.getPrice();
                double itemTotal = price * quantity;

                double itemVAT;

                itemVAT = ((VATCalculate) product).calculateVAT() * quantity;
                totalSum += itemTotal;
                totalVAT += itemVAT;
                totalQuantity += quantity;
                purchasedProducts.put(productNumber, purchasedProducts.getOrDefault(productNumber, 0) + quantity);

                System.out.println("Produkt " + productNumber + " hinzugefügt, Menge: " + quantity + ", Einzelpreis: " + price + " EUR");
            } else {
                System.out.println("Fehler: Produkt " + productNumber + " nicht gefunden.");
            }
        }


        // Округление итоговой суммы и НДС в пользу магазина (округление вверх)
        BigDecimal roundedTotalSum = new BigDecimal(totalSum).setScale(2, RoundingMode.CEILING);
        BigDecimal roundedVatAmount = new BigDecimal(totalVAT).setScale(2, RoundingMode.CEILING);

        System.out.println("\nErgebnisse:");
        System.out.printf("Gesamtsumme der ausgewählten Produkte: %.2f EUR\n", roundedTotalSum.doubleValue());
        System.out.printf("MwSt: %.2f EUR\n", roundedVatAmount.doubleValue());
        System.out.printf("Anzahl der ausgewählten Produkte: %d\n", totalQuantity);
        System.out.println("\nVAT Details:");
        for (Map.Entry<Integer, Integer> entry : purchasedProducts.entrySet()) {
            Product product = productList.get(entry.getKey());
            int quantity = entry.getValue();
            double price = product.getPrice();
            double totalPrice = price * quantity;

            double vatPerItem = ((VATCalculate) product).calculateVAT();
            double totalVat = vatPerItem * quantity;

            String vatRate = (product instanceof Konsumgueter) ? "19%" : "7%";

            System.out.printf("%s x%d - %.2f EUR (inkl. MwSt %s: %.2f EUR)\n",
                    product.getName(),
                    quantity,
                    totalPrice,
                    vatRate,
                    totalVat);
        }


        scanner.close();
    }


}
