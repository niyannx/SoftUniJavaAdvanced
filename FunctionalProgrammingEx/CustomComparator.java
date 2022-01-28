package FunctionalProgrammingEx;

/*
Write a custom comparator that sorts all even numbers before all odd ones in ascending order.
Pass it to an Arrays.sort() function and print the result.
 */

import java.util.*;
import java.util.stream.Collectors;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> input = sort(Arrays.stream(scan.nextLine().split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .boxed()
                        .collect(Collectors.toList()));

        input.forEach(num -> System.out.print(num + " "));

    }

    public static List<Integer> sort (List<Integer> list) {
        List<Integer> evens = new ArrayList<>();
        List<Integer> odds = new ArrayList<>();

        for (int el : list) {
            if (el % 2 == 0) {
                evens.add(el);
            } else {
                odds.add(el);
            }
        }

        Collections.sort(evens);
        Collections.sort(odds);

        List<Integer> result = new ArrayList<>();

        result.addAll(evens);
        result.addAll(odds);

        return result;
    }
}
