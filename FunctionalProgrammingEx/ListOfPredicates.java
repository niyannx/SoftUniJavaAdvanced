package FunctionalProgrammingEx;

/*
Find all numbers in the range 1..N that is divisible by the numbers of a given sequence. Use predicates.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }

        Integer[] divisors = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Predicate<Integer> check = i -> {
            for (Integer el : divisors) {
                if (el == 0) {
                    continue;
                }

                if (i % el != 0) {
                    return false;
                }
            }
            return true;
        };

        for (Integer num : list) {
            if (check.test(num)) {
                System.out.printf("%d ", num);
            }
        }

    }
}
