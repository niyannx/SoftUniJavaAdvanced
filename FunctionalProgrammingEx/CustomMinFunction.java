package FunctionalProgrammingEx;

/*
Write a simple program that reads a set of numbers from the console and finds the smallest of the numbers.
 */

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        Function<int[], Object> func = arr -> {
            int min = Integer.MAX_VALUE;

            for (int num : arr) {
                if (num < min) {
                    min = num;
                }
            }

            return min;
        };

        Consumer<int[]> smallestNum = array -> System.out.println(func.apply(array));

        smallestNum.accept(numbers);
    }
}
