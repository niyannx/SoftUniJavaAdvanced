package GenericsEx.GenericBoxOfInteger;

/*
Use the description of the previous problem (GenericBox) but now, test your generic box with Integers.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println(new Box<>(Integer.parseInt(scan.nextLine())));
        }
    }
}
