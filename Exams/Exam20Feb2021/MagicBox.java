package Exams.Exam20Feb2021;

/*
Every purchase gives you two magic boxes, and they are represented as a sequence of integers. First, you will be given a
sequence of integers, representing the first magic box. Afterwards, you will be given another sequence of integers
representing the second magic box.
You need to start from the first item in the first box and sum it with the last item in the second box. If the sum of
their values is an even number, add the summed item to your collection of claimed items and remove them both from the
boxes. Otherwise, remove the last item from the second box and add it at the last position in the first box. You need to
stop summing items when one of the boxes becomes empty.

If the first magic box becomes empty print:
	"First magic box is empty."

If the second magic box becomes empty print:
	"Second magic box is empty."

In the end you need to determine the quality of your claimed items. If the sum of the claimed items is equal to or greater than 90, print:
	"Wow, your prey was epic! Value: {sum of claimed items}"

Else print:
	"Poor prey... Value: {sum of claimed items}"


Input
•	On the first line, you will receive the integers representing the first magic box, separated by a single space.
•	On the second line, you will receive the integers representing the second magic box, separated by a single space.

Output
•	On the first line of output – print which box got empty in the format described above.
•	On the second line – the quality of your prey in the format described above.

Constraints
•	All the given numbers will be valid integers in the range [0, 100].
•	There won’t be a case where both magic boxes become empty at the same time

 */

import java.util.*;

public class MagicBox {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> firstBoxQueue = readQueue(scan);
        ArrayDeque<Integer> secondBoxStack = readStack(scan);

        List<Integer> claimedItems = new ArrayList<>();

        while (!firstBoxQueue.isEmpty() && !secondBoxStack.isEmpty()) {
            int sum = firstBoxQueue.peek() + secondBoxStack.peek();

            if (sum % 2 == 0) {
                claimedItems.add(sum);

                firstBoxQueue.poll();
                secondBoxStack.pop();
            } else {
                int item = secondBoxStack.pop();
                firstBoxQueue.offer(item);
            }
        }

        printOutput(firstBoxQueue, claimedItems);
    }

    public static void printOutput(ArrayDeque<Integer> firstBoxQueue, List<Integer> claimedItems) {
        if (firstBoxQueue.isEmpty()) {
            System.out.println("First magic box is empty.");
        } else {
            System.out.println("Second magic box is empty.");
        }

        int sumOfClaimedItems = claimedItems.stream()
                .mapToInt(Integer::intValue)
                .sum();

        if (sumOfClaimedItems >= 90) {
            System.out.println("Wow, your prey was epic! Value: " + sumOfClaimedItems);
        } else {
            System.out.println("Poor prey... Value: " + sumOfClaimedItems);
        }
    }

    public static ArrayDeque<Integer> readQueue(Scanner scan) {
        ArrayDeque<Integer> firstBoxQueue = new ArrayDeque<>();

        int[] ints = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int currInt : ints) {
            firstBoxQueue.offer(currInt);
        }

        return firstBoxQueue;
    }

    public static ArrayDeque<Integer> readStack(Scanner scan) {
        ArrayDeque<Integer> secondBoxStack = new ArrayDeque<>();

        int[] ints = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();


        for (int currInt : ints) {
            secondBoxStack.push(currInt);
        }

        return secondBoxStack;
    }
}
