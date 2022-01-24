package StacksAndQueuesEx;

/*
Write a program that reads N integers from the console and reverses them using a stack. Use the
ArrayDeque<Integer> class. Just put the input numbers in the stack and pop them.
 */

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> reverseStack = new ArrayDeque<>();

        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        for (int number : numbers) {
            reverseStack.push(number);
        }

        while (!reverseStack.isEmpty()) {
            System.out.printf("%d ", reverseStack.pop());
        }
    }
}
