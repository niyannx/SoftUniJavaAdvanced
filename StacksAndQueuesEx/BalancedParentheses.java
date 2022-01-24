package StacksAndQueuesEx;

/*
Given a sequence consisting of parentheses, determine whether the expression is balanced. A sequence of
parentheses is balanced if every open parenthesis can be paired uniquely with a closing parenthesis that occurs
after the former. Also, the interval between them must be balanced.
You will be given three types of parentheses:(, {, and [.

{[()]} - This is a balanced parenthesis.
{[(])} - This is not a balanced parenthesis.
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char[] parentheses = scan.nextLine().toCharArray();

        Deque<Character> stack = new ArrayDeque<>();

        boolean result = true;

        for (char current : parentheses) {
            switch (current) {
                case '(':
                    stack.push(')');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case ')':
                case ']':
                case '}':
                    if (stack.isEmpty() || stack.pop() != current) {
                        result = false;
                    }
                    break;
                default:
                    break;
            }

            if (!result) {
                break;
            }
        }

        result &= stack.isEmpty();

        System.out.println(result ? "YES" : "NO");
    }
}
