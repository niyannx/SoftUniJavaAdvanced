package Exams.RetakeExam15Dec2021;

/*
The first line will give you a sequence of integers representing males. Afterwards you will be given another sequence
of integers representing females.

You have to start from the first female and try to match it with the last male.

    •	If their values are equal, you have to match them and remove both of them. Otherwise, you should remove only the
female and decrease the value of the male by 2.
    •	If someone’s value is equal to or below 0, you should remove him/her from the records before trying to match him/her
with anybody.
    •	Special case - if someone’s value divisible by 25 without remainder, you should remove him/her and the next person
of the same gender.

You need to stop matching people when you have no more females or males.

Input / Constraints
•	On the first line, you will receive the integers, representing the males, separated by a single space. 
•	On the second line, you will receive the integers, representing the females, separated by a single space.
•	All the given numbers will be valid integers in the range [-100, 100].
Output
•	On the first line - print the number of successful matches:
o	"Matches: {matchesCount}"
•	On the second line - print all males left:
o	If there are no males: "Males left: none"
o	If there are males: "Males left: {male1}, {male2}, {male3}, (…)"
•	On the third line - print all females left:
o	If there are no females: "Females left: none"
o	If there are females: "Females left: {female1}, {female2}, {female3}, (…)"

 */

import java.util.*;
import java.util.stream.Collectors;

public class Meeting {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // initiate stack and queue
        ArrayDeque<Integer> maleStack = new ArrayDeque<>();
        ArrayDeque<Integer> femaleQueue = new ArrayDeque<>();

        // read them in the form of arrays
        int[] males = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] females = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        // add them to their respective arraydeques
        for (int male : males) {
            maleStack.push(male);
        }

        for (int female : females) {
            femaleQueue.offer(female);
        }

        // variable for matches
        int matches = 0;

        while (!femaleQueue.isEmpty() || !maleStack.isEmpty()) {
            if (femaleQueue.isEmpty() || maleStack.isEmpty()) {
                break;
            }

            int female = femaleQueue.peek();
            int male = maleStack.peek();

            // if someone's value is less or equal to 0, they get removed
            if (female <= 0) {
                femaleQueue.poll();
            } else if (male <= 0) {
                maleStack.pop();

                // special case -> if someone's value is divisible by 25, remove them and the next person of the same gender
            } else if (male % 25 == 0) {
                maleStack.pop();
                try {
                    maleStack.pop();
                } catch (Exception ignored) {

                }

            } else if (female % 25 == 0) {
                femaleQueue.poll();
                try {
                    femaleQueue.poll();
                } catch (Exception ignored) {

                }

                // if their values are equal, remove from females and remove from males
            } else if (female == male) {
                femaleQueue.poll();
                maleStack.pop();

                matches++;
                // if their values are NOT equal, remove from females and remove 2 from male's value
            } else {
                femaleQueue.poll();

                int newMaleValue = male - 2;
                maleStack.pop();
                maleStack.push(newMaleValue);
            }
        }
        printOutput(matches, maleStack, femaleQueue);
    }

    // method for printing output
    public static void printOutput(int matches, ArrayDeque<Integer> males, ArrayDeque<Integer> females) {
        System.out.println("Matches: " + matches);

        System.out.print("Males left: ");
        if (males.size() == 0) {
            System.out.print("none");
        } else {
            System.out.print(males.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(", ")));
        }
        System.out.println();

        System.out.print("Females left: ");
        if (females.size() == 0) {
            System.out.print("none");
        } else {
            System.out.print(females.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(", ")));
        }
        System.out.println();
    }
}