package SetsAndMapsEx;

/*
You are given an n number of chemical compounds. You need to keep track of all chemical elements used in the
compounds and at the end print all unique ones in ascending order:
 */

import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<String> chemicalElements = new TreeSet<>();

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] elements = scan.nextLine().split("\\s+");
            Collections.addAll(chemicalElements, elements);
        }

        chemicalElements.forEach(e -> System.out.print(e + " "));
    }
}
