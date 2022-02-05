package GenericsEx.GenericSwapMethodInteger;

/*
Use the description of the previous problem but now, test your list of generic boxes with Integers.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        Box<Integer>[] boxes = new Box[n];

        for (int i = 0; i < n; i++) {
            Box<Integer> box = new Box<>(Integer.parseInt(scan.nextLine()));

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

    public static void swap(Box<Integer>[] boxes, int first, int second) {
        Box<Integer> temp = boxes[first];
        boxes[first] = boxes[second];
        boxes[second] = temp;
    }
}
