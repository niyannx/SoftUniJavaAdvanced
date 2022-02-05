package GenericsEx.GenericSwapMethodString;

/*
Create a generic method that receives a list containing any type of data and swaps the elements at two given
indexes.
As in the previous problems, read n number of boxes of type String and add them to the list. On the next line,
however, you will receive a swap command consisting of two indexes. Use the method you&#39;ve created to swap the
elements that correspond to the given indexes and print each element in the list.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        Box<String>[] boxes = new Box[n];

        for (int i = 0; i < n; i++) {
            Box<String> box = new Box<>(scan.nextLine());

            boxes[i] = box;
        }

        int[] input = Arrays.stream(scan.nextLine().split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        int firstIndex = input[0];
        int secondIndex = input[1];

        swap(boxes, firstIndex, secondIndex);

        Arrays.stream(boxes).forEach(System.out::println);
    }

    public static void swap(Box<String>[] boxes, int first, int second) {
        Box<String> temp = boxes[first];
        boxes[first] = boxes[second];
        boxes[second] = temp;
    }
}
