package FunctionalProgrammingEx;

/*
Write a program which is using a custom function (written by you) to find the smallest integer in a sequence of
integers. The input could have more than one space. Your task is to collect the integers from the console, find the
smallest one and print its index (if more than one such elements exist, print the index of the rightmost one).
 */

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        Function<int[], Object> func = arr -> {
            int min = Integer.MAX_VALUE;
            int minIndex = 0;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] <= min) {
                    min = arr[i];
                    minIndex = i;
                }
            }

            return minIndex;
        };

        Consumer<int[]> smallestNum = array -> System.out.println(func.apply(array));

        smallestNum.accept(numbers);
    }
}
