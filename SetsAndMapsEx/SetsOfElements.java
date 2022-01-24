package SetsAndMapsEx;

/*
On the first line, you are given the length of two sets N and M. On the next N + M lines there are N numbers, that
are in the first set and M numbers that are in the second one. Find all non-repeating element that appears in both
of them, and print them in the same order at the console:
Set with length N = 4: {1, 3, 5, 7}
Set with length M = 3: {3, 4, 5}
Set that contains all repeating elements -&gt; {3, 5}
 */

import java.util.*;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] setsSizes = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < setsSizes[0]; i++) {
            firstSet.add(Integer.parseInt(scan.nextLine()));
        }

        for (int i = 0; i < setsSizes[1]; i++) {
            secondSet.add(Integer.parseInt(scan.nextLine()));
        }

        firstSet.retainAll(secondSet);

        firstSet.forEach(e -> System.out.print(e + " "));
    }
}
