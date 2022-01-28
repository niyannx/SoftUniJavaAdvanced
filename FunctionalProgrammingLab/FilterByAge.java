package FunctionalProgrammingLab;

/*
Write a program that reads an integer N on the first line. And on next N lines read pairs of &quot;{name}, {age}&quot;. Then
read three more lines with:
 Condition - "younger" or "older"
 Age - Integer
 Format - "name", "age" or "name age";
Depending on the condition, print the pairs in the right format.
Don’t use any built-in functionality. Write your methods.
 */

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class FilterByAge {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Integer> people = new LinkedHashMap<>();

        int nOfLines = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < nOfLines; i++) {
            String[] personData = scan.nextLine().split(", ");

            String personName = personData[0];
            int personAge = Integer.parseInt(personData[1]);

            people.put(personName, personAge);
        }

        String condition = scan.nextLine();
        int ageLimit = Integer.parseInt(scan.nextLine());
        String printType = scan.nextLine();

        // Predicate for filtering
        BiPredicate<Integer, Integer> filter;

        if (condition.equals("younger")) {
            filter = (currentAge, age) -> currentAge <= age;
        } else {
            filter = (currentAge, age) -> currentAge >= age;
        }

        // Consumer for printing
        Consumer<Map.Entry<String, Integer>> printOutput;

        if (printType.equals("name")) {
            printOutput = person -> System.out.println(person.getKey());
        } else if (printType.equals("age")) {
            printOutput = person -> System.out.println(person.getValue());
        } else {
            printOutput = person -> System.out.println(person.getKey() + " - " + person.getValue());
        }

        people.entrySet()
                .stream()
                .filter(person -> filter.test(person.getValue(), ageLimit))
                .forEach(printOutput);
    }
}
