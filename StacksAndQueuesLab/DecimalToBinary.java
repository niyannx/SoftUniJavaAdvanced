package StacksAndQueuesLab;

/*
Create a simple program that can convert a decimal number to its binary representation. Implement an elegant
solution using a Stack.
Print the binary representation back at the terminal.
 */

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int decimal = Integer.parseInt(scan.nextLine());

        if (decimal == 0) {
            stack.push(0);
        } else {
            while (decimal != 0) {
                // push - adds element to the top of stack
                stack.push(decimal % 2);
                decimal /= 2;
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.peek());
            stack.pop();
        }
    }
}
