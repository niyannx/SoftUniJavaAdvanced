package StacksAndQueuesLab;

/*
Create a simple calculator that can evaluate simple expressions that will not hold any operator different from
addition and subtraction. There will not be parentheses or operator precedence.
Solve the problem using a Stack.
 */

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] tokens = scan.nextLine().split("\\s+");

        Deque<String> stack = new ArrayDeque<>();
        Collections.addAll(stack, tokens);

        while (stack.size() > 1) {
            int first = Integer.valueOf(stack.pop());
            String op = stack.pop();
            int second = Integer.valueOf(stack.pop());

            switch (op) {
                case "+" -> stack.push(String.valueOf(first + second));
                case "-" -> stack.push(String.valueOf(first - second));
            }

            System.out.println(stack.pop());
        }
    }
}
