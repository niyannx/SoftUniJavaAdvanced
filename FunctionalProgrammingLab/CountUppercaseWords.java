package FunctionalProgrammingLab;

/*
Write a program that reads one line of text from the console. Print the count of words that start with an Uppercase
letter, after that print all these words in the same order, as you found them in the text.
Use a Predicate<String>.
 */

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Predicate<String> upperCasePredicate = word -> Character.isUpperCase(word.charAt(0));
        Consumer<String> printer = System.out::println;

        List<String> uppercaseWords = Arrays.stream(scan.nextLine().split("\\s+"))
                .filter(upperCasePredicate)
                .collect(Collectors.toList());

        System.out.println(uppercaseWords.size());
        uppercaseWords.forEach(printer);
    }
}
