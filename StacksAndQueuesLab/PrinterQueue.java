package StacksAndQueuesLab;

/*
The printer queue is a simple way to control the order of files sent to a printer device. We know that a single printer
can be shared between multiple devices. So to preserve the order of the files sent, we can use a queue.
Write a program, which takes filenames until the &quot;print&quot; command is received. Then as output print the filenames
in the order of printing. Some tasks may be canceled if you receive &quot;cancel&quot; you have to remove the first file
to be printed. If there is no current file to be printed, print "Printer is on standby".
 */

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> queue = new ArrayDeque<>();

        String input = scan.nextLine();

        while (!input.equals("print")) {
            if (input.equals("cancel")) {
                if (queue.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.println("Canceled " + queue.peek());
                    queue.remove();
                }
            } else {
                queue.add(input);
            }

            input = scan.nextLine();
        }

        while (!queue.isEmpty()) {
            System.out.println(queue.peek());
            queue.remove();
        }
    }
}
