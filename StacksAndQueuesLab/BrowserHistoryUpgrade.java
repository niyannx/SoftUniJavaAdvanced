package StacksAndQueuesLab;

/*
Extend "Browser History" with a "forward" instruction, which visits URLs that were navigated away from by
"back".
Each forward instruction visits the next most recent such URL. If normal navigation happens, all potential forward
URLs are removed until a new back instruction is given if the forward instruction can’t be executed, print
"no next URLs".
 */

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> backwardsStack = new ArrayDeque<>();
        ArrayDeque<String> forwardsStack = new ArrayDeque<>();

        String input = scan.nextLine();

        while (!input.equals("Home")) {
            // if the user wants to go back
            if (input.equals("back")) {
                // check if there is anything to go back to
                if (backwardsStack.size() > 1) {
                    // add the page we are going back from to the pages we can go forward to
                    forwardsStack.addFirst(backwardsStack.pop());
                    // print the current page we are at
                    System.out.println(backwardsStack.peek());
                // if there's not anything to go back to, print that there aren't any previous pages
                } else {
                    System.out.println("no previous URLs");
                }
            // if the user wants to go forward
            } else if (input.equals("forward")) {
                // check if there's anything to go forwards to
                if (forwardsStack.size() >= 1) {
                    // print the topmost element
                    System.out.println(forwardsStack.peek());
                    // add the topmost element to the pages we can go back to
                    backwardsStack.push(forwardsStack.pop());
                // if there's not anything to go forwards to, print that there aren't any previous pages
                } else {
                    System.out.println("no next URLs");
                }
            // if the user wants to add a page
            } else {
                // add the page to the pages we can go back to
                backwardsStack.push(input);
                // clear the forwards stack
                forwardsStack.clear();
                // print the current page
                System.out.println(backwardsStack.peek());
            }

            input = scan.nextLine();
        }
    }
}
