package FunctionalProgrammingLab;

/*
You are given a lower and an upper bound for a range of integer numbers. Then a command specifies if you need to
list all even or odd numbers in the given range. Use predicates that need to be passed to a method.
 */

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Supplier<List<Integer>> genList = () -> {
            int[] input = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int start = input[0];
            int end = input[1];

            List<Integer> list = new ArrayList<>();

            for (int i = start; i <= end; i++) {
                list.add(i);
            }

            return list;
        };

        List<Integer> nums = genList.get();
        String type = scan.nextLine();

        Predicate<Integer> filter;

        if (type.equals("even")) {
            filter = number -> number % 2 == 0;
        } else {
            filter = number -> number % 2 != 0;
        }

        nums.stream()
                .filter(filter)
                .collect(Collectors.toList())
                .forEach(e -> System.out.print(e + " "));
    }
}
