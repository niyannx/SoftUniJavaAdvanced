package SetsAndMapsEx;

/*
Write a simple program that reads from the console a sequence of usernames and keeps a collection with only the
unique ones. Print the collection on the console in order of insertion:
 */

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<String> set = new LinkedHashSet<>();

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();

            set.add(input);
        }

        for (String setData : set) {
            System.out.println(setData);
        }
    }
}
