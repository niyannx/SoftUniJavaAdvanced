package GenericsEx.CustomList;

/*
CUSTOM LIST ->
Create a generic data structure that can store any type that can be compared. Implement functions:
 void add(T element)
 T remove(int index)
 boolean contains(T element)
 void swap(int index, int index)
 int countGreaterThan(T element)
 T getMax()
 T getMin()

Create a command interpreter that reads commands and modifies the custom list that you have created. Implement
the commands:
 Add {element} - Adds the given element to the end of the list.
 Remove {index} - Removes the element at the given index.
 Contains {element} - Prints if the list contains the given element (true or false).
 Swap {index1} {index2} - Swaps the elements at the given indexes.
 Greater {element} - Counts the elements that are greater than the given element and prints their count
 Max - Prints the maximum element in the list.
 Min - Prints the minimum element in the list.
 Print - Prints all elements in the list, each on a separate line.
 END - stops the reading of commands.

+

CUSTOM LIST SORTER ->
Extend the problem by creating an additional single static method sort()
which can sort objects of type T. Extend the command list to
support one additional command Sort:
 Sort - Sort the elements in the list in ascending order.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        CustomList<String> list = new CustomList<String>();

        String input = reader.readLine();

        while (!input.equals("END")) {
            String[] commands = input.split("\\s+");

            switch (commands[0]) {
                case "Add":
                    list.add(commands[1]);
                    break;
                case "Remove":
                    list.remove(Integer.parseInt(commands[1]));
                    break;
                case "Contains":
                    System.out.println(list.contains(commands[1]));
                    break;
                case "Swap":
                    list.swap(Integer.parseInt(commands[1]), Integer.parseInt(commands[2]));
                    break;
                case "Greater":
                    System.out.println(list.countGreaterThan(commands[1]));
                    break;
                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;
                case "Print":
                    System.out.println(list);
                    break;
                case "Sort":
                    list.sort();
                    break;
                default:
                    break;
            }

            input = reader.readLine();
        }
    }
}
