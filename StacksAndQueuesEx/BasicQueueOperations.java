package StacksAndQueuesEx;

/*
You will be given an integer N representing the number of elements to enqueue (add), an integer S representing the
number of elements to dequeue (remove/poll) from the queue, and finally an integer X, an element that you should
check whether is present in the queue. If it is print true on the console if it is not print the smallest element
currently present in the queue.
 */

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] input = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = input[0];
        int s = input[1];
        int x = input[2];

        ArrayDeque<Integer> queue = Arrays.stream(scan.nextLine().split("\\s+"))
            .mapToInt(Integer::parseInt).boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));

        for (int i = 0; i < s; i++) {
            queue.poll();
        }

        if (!queue.isEmpty()) {
            if (queue.contains(x)) {
                System.out.println("true");
            } else {
                int smallest = Integer.MAX_VALUE;

                for (int number : queue) {
                    if (number < smallest) {
                        smallest = number;
                        queue.poll();
                    }
                }

                System.out.println(smallest);
            }
        } else {
            System.out.println(0);
        }
    }
}
