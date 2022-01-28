package FunctionalProgrammingEx;

/*
Write a program that reads a collection of names as strings from the console and then appends &quot;Sir&quot; in front of
every name and prints it back onto the console. Use a Consumer<T>.
 */

import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonour {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Consumer<String> print = e -> System.out.println("Sir " + e);

        List.of(scan.nextLine().split("\\s+")).forEach(print);
    }
}
