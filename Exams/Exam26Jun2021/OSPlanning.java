package Exams.Exam26Jun2021;

/*
You are hired to create a program that schedules the work of a OS and avoids tasks that could harm it.
On the first line you will be given some tasks as integer values, separated by comma and space ", ". On the second line you will be given some threads as integer values, separated by a single space. On the third line, you will receive the integer value of a task that you need to kill. Your job is to stop the work of the OS as soon as you get to this task, otherwise your OS will crash. The thread that gets first to this task, kills it.

The OS works in the following way:
    •	It takes the first given thread value and the last given task value.
    •	If the thread value is greater than or equal to the task value, the task and thread get removed.
    •	If the thread value is less than the task value, the thread gets removed, but the task remains.

After you finish the needed task, print on a single line:
    "Thread with value {thread} killed task {taskToBeKilled}"
Then print the remaining threads (including the one that killed the task) starting from the first on a single line, separated by a single space.

Input
    •	On the first line you will receive the tasks, separated by ", ".
    •	On the second line you will the threads, separated by a single space.
    •	On the third line, you will receive a single integer – value of the task to be killed.

Output
    •	Print the thread that killed the task and task itself in the format given above.
    •	Print the remaining threads starting from the first on a single line, separated by a single space.

Constraints
    •	The needed task will always be with a unique value
    •	You will always have enough threads to get to the needed task

 */

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class OSPlanning {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> tasksStack = readStack(scan);
        ArrayDeque<Integer> threadsQueue = readQueue(scan);

        int threadToKill = Integer.parseInt(scan.nextLine());
        int threadKillerValue;

        while (true) {
            int currTask = tasksStack.peek();
            int currThread = threadsQueue.peek();

            if (currTask == threadToKill) {
                threadKillerValue = currThread;
                break;
            }

            if (currThread >= currTask) {
                tasksStack.pop();
            }
            threadsQueue.poll();
        }

        System.out.printf("Thread with value %d killed task %d\n", threadKillerValue, threadToKill);
        printRemainingThreads(threadsQueue);
    }

    public static void printRemainingThreads(ArrayDeque<Integer> threads) {
        while (!threads.isEmpty()) {
            System.out.print(threads.pop() + " ");
        }
    }

    public static ArrayDeque<Integer> readQueue(Scanner scan) {
        ArrayDeque<Integer> threadsQueue = new ArrayDeque<>();

        int[] threads = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int thread : threads) {
            threadsQueue.offer(thread);
        }

        return threadsQueue;
    }

    public static ArrayDeque<Integer> readStack(Scanner scan) {
        ArrayDeque<Integer> tasksStack = new ArrayDeque<>();

        int[] tasks = Arrays.stream(scan.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();


        for (int task : tasks) {
            tasksStack.push(task);
        }

        return tasksStack;
    }
}
