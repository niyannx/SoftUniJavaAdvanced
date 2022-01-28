package FunctionalProgrammingLab;

/*
Write a program that reads one line of Integers separated by ", ".
•	Print the even numbers.
•	Sort them in ascending order.
•	Print them again.
Use Lambda Expressions to do so.
 */

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> evenNumbers = Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt)
                .filter(e -> e % 2 == 0)
                .map(Object::toString)
                .collect(Collectors.toList());

        System.out.println(String.join(", ", evenNumbers));
    }
}
