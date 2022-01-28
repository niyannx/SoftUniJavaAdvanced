package FunctionalProgrammingEx;

/*
Write a predicate. Its goal is to check a name for its length and to return true if the length of the name is less or
equal to the passed integer. You will be given an integer that represents the length you have to use. On the second
line, you will be given a string array with some names. Print the names, passing the condition in the predicate.
 */

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        BiPredicate<String, Integer> checkLength = (name, length) ->  name.length() <= length;

        int lengthLimit = Integer.parseInt(scan.nextLine());

        List<String> names = Arrays.stream(scan.nextLine().split("\\s+"))
                .collect(Collectors.toList());


        names.stream()
                .filter(name -> checkLength.test(name, lengthLimit))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}
