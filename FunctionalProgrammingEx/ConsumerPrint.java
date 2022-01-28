package FunctionalProgrammingEx;

/*
Write a program that reads a collection of strings, separated by one or more whitespaces, from the console and
then prints them onto the console. Each string should be printed on a new line. Use a Consumer<T>.
 */

import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Consumer<String> print = System.out::println;

        List.of(scan.nextLine().split("\\s+")).forEach(print);
    }
}
