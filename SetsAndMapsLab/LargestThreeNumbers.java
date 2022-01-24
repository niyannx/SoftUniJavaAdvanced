package SetsAndMapsLab;

/*
Read a list of integers and print the largest 3 of them. If there are less than 3, print all of them.
 */

import java.util.*;
import java.util.stream.Collectors;

public class LargestThreeNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println(Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).sorted(Comparator.reverseOrder()).limit(3)
                .collect(Collectors.toList()).stream()
                .map(Object::toString)
                .collect(Collectors.joining(" ")));
    }
}
