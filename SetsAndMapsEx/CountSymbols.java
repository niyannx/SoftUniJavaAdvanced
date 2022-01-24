package SetsAndMapsEx;

/*
Write a program that reads some text from the console and counts the occurrences of each character in it. Print the
results in alphabetical (lexicographical) order.
 */

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        Map<String, Integer> counter = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            String currChar = String.valueOf(input.charAt(i));

            if (!counter.containsKey(currChar)) {
                counter.put(currChar, 0);
            }
            counter.put(currChar, counter.get(currChar) + 1);
        }

        for (Map.Entry<String, Integer> entry : counter.entrySet()) {
            System.out.printf("%s: %d time/s\n", entry.getKey(), entry.getValue());
        }
    }
}
