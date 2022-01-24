package StacksAndQueuesLab;

/*
Rework the previous problem so that a child is removed only on a composite (not prime) cycle (cycles start from 1).
If a cycle is prime, just print the child's name.
As before, print the name of the child that is left last.
 */

import java.util.ArrayDeque;
import java.util.Scanner;

public class MathPotato {
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
