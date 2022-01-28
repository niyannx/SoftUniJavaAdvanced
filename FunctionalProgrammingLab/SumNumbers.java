package FunctionalProgrammingLab;

/*
Write a program that reads one line of Integers separated by &quot;, &quot;. Print the count of the numbers and their sum.
Use a Function <String, Integer>.
 */

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(", ");

        Function<String, Integer> parser = Integer::parseInt;

        List<Integer> numbers = Arrays.stream(input)
                .map(parser)
                .collect(Collectors.toList());

        int sum = Arrays.stream(input).mapToInt(Integer::parseInt).sum();

        System.out.println("Count = " + numbers.size());
        System.out.println("Sum = " + sum);
    }
}
