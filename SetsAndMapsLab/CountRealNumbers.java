package SetsAndMapsLab;

/*
Write a program that counts the occurrence of real numbers. The input is a single line with real numbers separated
by a space. Print the numbers in the order of appearance. All numbers must be formatted to one digit after the
decimal point.
 */

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double[] keys = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double, Integer> count = new LinkedHashMap<>();

        for (double key : keys) {
            if (count.containsKey(key)) {
                count.put(key, count.get(key) + 1);
            } else {
                count.put(key, 1);
            }
        }

        for (Map.Entry<Double, Integer> entry : count.entrySet()) {
            System.out.printf("%.1f -> %d", entry.getKey(), entry.getValue());
            System.out.println();
        }
    }
}
