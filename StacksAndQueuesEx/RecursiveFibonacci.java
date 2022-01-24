package StacksAndQueuesEx;

/*
Each member of the Fibonacci sequence is calculated from the sum of the two previous members. The first two
elements are 1, 1. Therefore, the sequence goes like 1, 1, 2, 3, 5, 8, 13, 21, 34…
The following sequence can be generated with an array, but that’s easy, so your task is to implement it recursively.
If the function getFibonacci(n) returns the n th Fibonacci number, we can express it using getFibonacci(n) =
getFibonacci(n-1) + getFibonacci(n-2).
However, this will never end and in a few seconds, a Stack Overflow Exception is thrown. For the recursion to stop, it
has to have a &quot;bottom&quot;. The bottom of the recursion is getFibonacci(1), and should return 1. The same goes for
getFibonacci(0).
 */

import java.util.Scanner;

public class RecursiveFibonacci {
    private static long[] memo;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = Integer.parseInt(input.nextLine());

        memo = new long[n + 1];
        System.out.println(recursiveFibonacciWithMemoization(n));
    }

    // Top down DP: recursion + memoization
    private static long recursiveFibonacciWithMemoization(int n) {
        if (n <= 1) {
            return 1;
        }

        if (memo[n] != 0) {
            return memo[n];
        }

        memo[n] =
                recursiveFibonacciWithMemoization(n - 1) +
                        recursiveFibonacciWithMemoization(n - 2);
        return memo[n];
    }

    // Bottom up DP
    private static long fibonacciWithBottomUpDP(int n) {
        long[] fibonacciNumbers = new long[n + 1];

        fibonacciNumbers[0] = 1;
        fibonacciNumbers[1] = 1;
        for (int i = 2; i <= n; i++) {
            fibonacciNumbers[i] =
                    fibonacciNumbers[i - 1] + fibonacciNumbers[i - 2];
        }

        return fibonacciNumbers[n];
    }
}
