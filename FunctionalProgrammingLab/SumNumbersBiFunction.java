package FunctionalProgrammingLab;

/*
Write a program that reads one line of Integers separated by &quot;, &quot;. Print the count of the numbers and their sum.
Use a Function<String, Integer>.
 */

import java.util.Scanner;
import java.util.function.BiFunction;

public class SumNumbersBiFunction {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] split = scan.nextLine().split(", ");

        System.out.println("Count = " + split.length);

        BiFunction<Integer, String, Integer> parseAndSum = (x, y) -> x + Integer.parseInt(y);

        int sum = 0;

        for (String s : split) {
            sum = parseAndSum.apply(sum, s);
        }

        System.out.println("Sum = " + sum);
    }
}
