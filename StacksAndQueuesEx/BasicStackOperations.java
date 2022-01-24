package StacksAndQueuesEx;

/*
You will be given an integer N representing the number of elements to push into the stack, an integer S
representing the number of elements to pop from the stack, and finally an integer X, an element that you should
check whether is present in the stack. If it is, print &quot;true&quot; on the console. If it’s not, print the smallest element
currently present in the stack.
 */

import java.util.*;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] input = Arrays.stream(scan.nextLine().split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        int n = input[0];
        int s = input[1];
        int x = input[2];

        int[] reversedStack = Arrays.stream(scan.nextLine().split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        Deque<Integer> stack = new ArrayDeque<>(n);

        for (int number : reversedStack) {
            stack.push(number);
        }

        for (int i = 0; i < s; i++) {
            stack.pop();
        }

        if (!stack.isEmpty()) {
            if (stack.contains(x)) {
                System.out.println("true");
            } else {
                int smallest = Integer.MAX_VALUE;

                for (int number : stack) {
                    if (number < smallest) {
                        smallest = number;
                        stack.pop();
                    }
                }

                System.out.println(smallest);
            }
        } else {
            System.out.println(0);
        }
    }
}
