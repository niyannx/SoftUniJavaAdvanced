package SetsAndMapsEx;

/*
You are given a sequence of people and for every person what cards he draws from the deck. The input will be
separate lines in the format:
&quot;{personName}: {PT, PT, PT,… PT}&quot;
Where P (2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, A) is the power of the card and T (S, H, D, C) is the type. The input ends
when a &quot;JOKER&quot; is drawn. The name can contain any ASCII symbol except &quot;:&quot;. The input will always be valid and in
the format described, there is no need to check it.
A single person cannot have more than one card with the same power and type, if he draws such a card he discards
it. The people are playing with multiple decks. Each card has a value that is calculated by the power multiplied by
the type. Powers 2 to 10 have the same value and J to A are 11 to 14. Types are mapped to multipliers the following
way (S -&gt; 4, H-&gt; 3, D -&gt; 2, C -&gt; 1).
Finally print out the total value each player has in his hand in the format:
&quot;{personName}: {value}&quot;
 */

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // name -> all of his cards without the doubled ones
        Map<String, Set<String>> scores = new LinkedHashMap<>();

        String[] input = scan.nextLine().split(": |, ");

        while (!input[0].equals("JOKER")) {
            // if this is the first time entering this players name, add it and create a new hashset
            if (!scores.containsKey(input[0])) {
                scores.put(input[0], new HashSet<>());
            }

            // put all the cards inside the set
            for (int i = 1; i < input.length; i++) {
                scores.get(input[0]).add(input[i]);
            }

            input = scan.nextLine().split(": |, ");
        }

        // print the output
        printOutput(scores);
    }

    public static void printOutput(Map<String, Set<String>> scores) {
        for (Map.Entry<String, Set<String>> entry : scores.entrySet()) {
            int valueOfHands = getValueOfHands(entry.getValue());

            System.out.printf("%s: %d\n", entry.getKey(), valueOfHands);
        }
    }

    public static int getValueOfHands(Set<String> cards) {
        String regex = "(?<power>[0-9]{1,2}|[A-Z])(?<type>[A-Z])";
        Pattern pattern = Pattern.compile(regex);

        int valueOfHands = 0;

        for (String card : cards) {
            Matcher matcher = pattern.matcher(card);

            int currentCardsValue = 0;

            if (matcher.find()) {
                String cardPower = matcher.group("power");
                String cardType = matcher.group("type");

                switch (cardPower) {
                    case "J":
                        currentCardsValue = 11;
                        break;
                    case "Q":
                        currentCardsValue = 12;
                        break;
                    case "K":
                        currentCardsValue = 13;
                        break;
                    case "A":
                        currentCardsValue = 14;
                        break;
                    default:
                        currentCardsValue = Integer.parseInt(cardPower);
                }

                switch (cardType) {
                    case "S":
                        currentCardsValue = currentCardsValue * 4;
                        break;
                    case "H":
                        currentCardsValue = currentCardsValue * 3;
                        break;
                    case "D":
                        currentCardsValue = currentCardsValue * 2;
                        break;
                }
            }
            valueOfHands += currentCardsValue;

        }
        return valueOfHands;
    }
}