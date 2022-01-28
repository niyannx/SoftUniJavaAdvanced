package FunctionalProgrammingLab;

/*
Write a program that reads one line of Double prices separated by ", ". Print the prices with added VATs for all of
them. Format them to the 2 nd digit after the decimal point. The order of the prices must remain the same.
Use an UnaryOperator<Double>.
 */

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] prices = scan.nextLine().split(", ");

        Function<String, Double> parseToDouble = Double::parseDouble;
        Function<Double, Double> addVAT = e -> 1.2 * e;
        Consumer<Double> printer = e -> System.out.printf("%.2f\n", e);

        System.out.println("Prices with VAT:");
        Arrays.stream(prices)
                .map(parseToDouble)
                .map(addVAT)
                .forEach(printer);
    }
}
