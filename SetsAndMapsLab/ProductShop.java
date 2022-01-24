package SetsAndMapsLab;

/*
Write a program that prints information about food shops in Sofia and the products they store. Until the
"Revision" command you will receive an input in the format: "{shop}, {product}, {price}".
Keep in mind that if you get a store that already exists, you need to gather product information in it.
Your output must be ordered by shop name and must be in the format:

"{shop}->;
Product: {product}, Price: {price}"

The price should be formatted to one digit after the decimal point.
 */

import java.util.*;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(",\\s+");

        Map<String, LinkedHashMap<String, Double>> shops = new TreeMap<>();

        while (!input[0].equals("Revision")) {
            String shop = input[0];
            String product = input[1];
            double price = Double.parseDouble(input[2]);

            if (!shops.containsKey(shop)) {
                shops.put(shop, new LinkedHashMap<>());
            }
            shops.get(shop).put(product, price);

            input = scan.nextLine().split(",\\s+");
        }

        for (Map.Entry<String, LinkedHashMap<String, Double>> entry : shops.entrySet()) {
            System.out.printf("%s->\n", entry.getKey());
            for (Map.Entry<String, Double> entryProducts : entry.getValue().entrySet()) {
                System.out.printf("Product: %s, Price: %.1f\n", entryProducts.getKey(), entryProducts.getValue());
            }
        }
    }
}
