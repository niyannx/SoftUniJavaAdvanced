package GenericsEx.GenericCountMethodStrings;

/*
Create a method that receives as an argument a list of any type that can be compared and an element of the given
type. The method should return the count of elements that are greater than the value of the given element.
Modify your Box class to support comparing by the value of the data stored.
On the first line, you will receive n - the number of elements to add to the list. On the next n lines, you will receive
the actual elements. On the last line, you will get the value of the element to which you need to compare every
element in the list.
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        Boxes<String> elements = new Boxes<>();

        for (int i = 0; i < n; i++) {
            elements.add(new Box<>(scan.nextLine()));
        }

        System.out.println(elements.getNumberOfGreaterElements(scan.nextLine()));
    }
}
