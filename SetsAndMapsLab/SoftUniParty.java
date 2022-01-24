package SetsAndMapsLab;

/*
There is a party in SoftUni. Many guests are invited, and they are two types: VIP and regular.
When a guest comes, you have to check if he/she exists in any of the two reservation lists. All reservation numbers
will be with 8 chars. All VIP numbers start with a digit.
There will be 2 command lines:
 First is "PARTY" - the party is on and guests start coming.
 The second is &quot;END&quot; - then the party is over, and no more guests will come.
The output shows all guests, who didn't come to the party (VIP must be first).
 */

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<String> guests = new TreeSet<>();

        String input = scan.nextLine();

        while (!input.equals("PARTY")) {
            guests.add(input);

            input = scan.nextLine();
        }

        while (!input.equals("END")) {
            guests.remove(input);

            input = scan.nextLine();
        }

        System.out.println(guests.size());
        for (String guest : guests) {
            System.out.println(guest);
        }
    }
}
