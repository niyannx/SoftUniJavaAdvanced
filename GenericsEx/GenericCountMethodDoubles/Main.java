package GenericsEx.GenericCountMethodDoubles;

/*
Use the description of the previous problem but now, test your list of generic boxes with Doubles.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        Boxes<Double> elements = new Boxes<>();

        for (int i = 0; i < n; i++) {
            elements.add(new Box<>(Double.parseDouble(scan.nextLine())));
        }

        System.out.println(elements.getNumberOfGreaterElements(Double.parseDouble(scan.nextLine())));
    }
}
