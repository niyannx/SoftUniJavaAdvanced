package StacksAndQueuesLab;

/*
Hot potato is a game in which children form a circle and start passing a hot potato. The counting starts with the
first kid. Every n th toss the child left with the potato leaves the game. When a kid leaves the game, it passes the
potato forward. This continues repeating until there is only one kid left.
Create a program that simulates the game of Hot Potato. Print every kid that is removed from the circle. In the
end, print the kid that is left last.
 */

import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] children = scan.nextLine().split(" ");
        int numberOfTurns = Integer.parseInt(scan.nextLine());

        ArrayDeque<String> childrenQueue = new ArrayDeque<>();

        for (String child : children) {
            childrenQueue.offer(child);
        }

        while(childrenQueue.size() != 1){
            for (int i = 1; i < numberOfTurns; i++) {
                String currentChild = childrenQueue.poll();
                childrenQueue.offer(currentChild);
            }
            String childToRemove = childrenQueue.poll();
            System.out.println("Removed " + childToRemove);
        }
        String lastChild = childrenQueue.peek();
        System.out.printf("Last is %s", lastChild);
    }
}
