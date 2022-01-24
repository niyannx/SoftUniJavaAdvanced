package StacksAndQueuesLab;

/*
We are given an arithmetical expression with brackets. Scan through the string and extract each sub-expression.
Print the result back at the terminal.
 */

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        String expression = scan.nextLine();

        for (int i = 0; i < expression.length(); i++) {
            char currCh = expression.charAt(i);

            if (currCh == '(') {
                stack.push(i);
            } else if (currCh == ')') {
                int startIndex = stack.pop();
                String contents = expression.substring(startIndex, i + 1);
                System.out.println(contents);
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.peek());
            stack.pop();
        }
    }
}
