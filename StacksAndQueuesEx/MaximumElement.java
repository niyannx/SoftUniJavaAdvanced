package StacksAndQueuesEx;

/*
You have an empty sequence, and you will be given N commands. Each command is one of the following types:
 "1 X" - Push the element X into the stack.
 "2" - Delete the element present at the top of the stack.
 "3" - Print the maximum element in the stack.
 */

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            int[] input = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            switch (input[0]) {
                case 1:
                    stack.push(input[1]);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    printMaximum(stack);
                    break;
            }
        }
    }

    public static void printMaximum(ArrayDeque<Integer> stack) {
        ArrayDeque<Integer> copyStack = stack.clone();

        int max = Integer.MIN_VALUE;

        while (!copyStack.isEmpty()) {
            if (copyStack.peek() > max) {
                max = copyStack.peek();
            }
            copyStack.pop();
        }

        System.out.println(max);
    }
}
