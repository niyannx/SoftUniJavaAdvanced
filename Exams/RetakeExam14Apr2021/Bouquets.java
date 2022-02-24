package Exams.RetakeExam14Apr2021;

/*
You want to go on a bouquets' competition but to participate you have to make at least 5 bouquets.

You will be given two sequences of integers, representing daffodils and tulips. You need to start making bouquets
knowing that one bouquet needs 15 flowers. Your goal is to make at least 5 bouquets.
You will start crafting from the last tulips and the first daffodils. If the sum of their values is equal to 15 – create
one bouquet and remove them. While the sum is bigger than 15, keep decreasing the value of the tulips by 2. If the sum
is less than 15 you have to store them for later and remove them. You need to stop combining when you have no more
daffodils or tulips. In the end, if you have any stored flowers you should make as many bouquets as you can with them.
Input
•	On the first line, you will receive the integers representing the tulips, separated by ", ".
•	On the second line, you will receive the integers representing the daffodils, separated by ", ".
Output
•	Print whether you have succeeded making at least 5 bouquets:
o	"You made it! You go to the competition with {count of bouquets} bouquets!"
o	"You failed... You need more {number} bouquets."
Constraints
•	All the given numbers will be valid integers in the range [0, 120].
•	Don't have situation with negative number.

 */

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Bouquets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> tulipsStack = readStack(scan);
        ArrayDeque<Integer> daffodilsQueue = readQueue(scan);

        int bouquets = 0;

        int flowersForLater = 0;

        while (!tulipsStack.isEmpty() && !daffodilsQueue.isEmpty()) {
            int sum = tulipsStack.peek() + daffodilsQueue.peek();

            if (sum == 15) {
                bouquets++;
                tulipsStack.pop();
                daffodilsQueue.poll();
            } else if (sum > 15) {
                int currTulip = tulipsStack.pop() - 2;
                tulipsStack.push(currTulip);
            } else {
                flowersForLater += sum;
                tulipsStack.pop();
                daffodilsQueue.poll();
            }
        }

        if (flowersForLater >= 15) {
            bouquets += flowersForLater / 15;
        }

        if (bouquets >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!\n", bouquets);
        } else {
            System.out.printf("You failed... You need more %d bouquets.\n", 5 - bouquets);
        }

    }

    public static ArrayDeque<Integer> readQueue(Scanner scan) {
    ArrayDeque<Integer> daffodilsQueue = new ArrayDeque<>();

        int[] daffodils = Arrays.stream(scan.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int daffodil : daffodils) {
            daffodilsQueue.offer(daffodil);
        }

        return daffodilsQueue;
    }

    public static ArrayDeque<Integer> readStack(Scanner scan) {
        ArrayDeque<Integer> tulipsStack = new ArrayDeque<>();

        int[] tulips = Arrays.stream(scan.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();


        for (int tulip : tulips) {
            tulipsStack.push(tulip);
        }

        return tulipsStack;
    }
}
