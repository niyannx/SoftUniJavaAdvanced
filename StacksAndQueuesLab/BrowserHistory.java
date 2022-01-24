package StacksAndQueuesLab;

/*
Write a program, which takes 2 types of browser instructions:
 Normal navigation: a URL is set, given by a string;
 The string &quot;back&quot; that sets the current URL to the last set URL
After each instruction, the program should print the current URL. If the back instruction can’t be executed, print
"no previous URLs". The input ends with the "Home" command and then simply you have to stop the program.
 */

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();

        String input = scan.nextLine();

        stack.push(input);

        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (stack.size() > 2) {
                    stack.pop();
                    System.out.println(stack.peek());
                } else {
                    System.out.println("no previous URLs");
                }
            } else {
                stack.push(input);
                System.out.println(input);
            }

            input = scan.nextLine();
        }
    }
}
