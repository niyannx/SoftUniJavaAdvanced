package SetsAndMapsLab;

/*
Write a program that:
 Reads 20 numbers for both players, separated with &quot; &quot; (single space).
o Every player can hold unique numbers.
Each Round both players get the top number from their deck. The player with the bigger number gets both numbers
and adds them to the bottom of his sequence.
The game ends after 50 rounds or if any player loses all of his numbers.
 */

import java.util.*;
import java.util.stream.Collectors;

public class Voina {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<Integer> firstPlayerCards = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)// mapToInt -> Stream<int>
                .boxed() // Stream<Integer>
                .collect(Collectors.toCollection(LinkedHashSet::new));

        Set<Integer> secondPlayerCards = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)// map -> Stream<Integer>
                .collect(Collectors.toCollection(LinkedHashSet::new));

        int rounds = 50;

        while (rounds-- > 0) {

            int firstPlayerNumber = firstPlayerCards.iterator().next();
            firstPlayerCards.remove(firstPlayerNumber);

            int secondPlayerNumber = secondPlayerCards.iterator().next();
            secondPlayerCards.remove(secondPlayerNumber);

            if (firstPlayerNumber > secondPlayerNumber) {
                firstPlayerCards.add(firstPlayerNumber);
                firstPlayerCards.add(secondPlayerNumber);
            } else if (secondPlayerNumber > firstPlayerNumber){
                secondPlayerCards.add(firstPlayerNumber);
                secondPlayerCards.add(secondPlayerNumber);
            }
            if (firstPlayerCards.isEmpty()
                    || secondPlayerCards.isEmpty()) {
                break;
            }
        }


        if (secondPlayerCards.size() > firstPlayerCards.size()) {
            System.out.println("Second player win!");
        } else if (firstPlayerCards.size() > secondPlayerCards.size()) {
            System.out.println("First player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}
