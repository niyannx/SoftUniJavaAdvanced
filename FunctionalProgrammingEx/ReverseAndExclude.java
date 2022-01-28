package FunctionalProgrammingEx;

/*
Write a program that reverses a collection and removes elements that are divisible by a given integer;
 */

import java.util.*;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        BiPredicate<Integer, Integer> divisible = (numFromList, num) -> numFromList % num != 0;

        List<Integer> nums = Arrays.stream(scan.nextLine().split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .boxed()
                        .collect(Collectors.toList());

        Collections.reverse(nums);

        int divideBy = Integer.parseInt(scan.nextLine());

        nums.stream()
                .filter(num -> divisible.test(num, divideBy))
                .collect(Collectors.toList())
                .forEach(e -> System.out.print(e + " "));
    }
}
