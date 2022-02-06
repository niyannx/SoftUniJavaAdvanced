package Exams.Exam23Oct2021;

/*
Summer is over, autumn has come. For this purpose, we have prepared several cocktails that we think you will like.
First, you will receive a sequence of integers, representing the number of ingredients in a single bucket. After that, you will be given another sequence of integers - the freshness level of the ingredients.
Your task is to mix them, so you can produce the cocktails, listed in the table below with the exact freshness level.

   Cocktail	   | Freshness Level needed
  Pear Sour	   |           150
 The Harvest   |           250
 Apple Hinny   |           300
 High Fashion  |           400

To mix a cocktail, you have to take the first bucket of ingredients and the last freshness level value. The total freshness level is calculated by their multiplication. If the product of this operation equals one of the levels described in the table, you make the cocktail and remove both buckets with ingredients and freshness value. Otherwise, you should remove the freshness level, increase the ingredient value by 5, then remove it from the first position and add it at the end. In case you have an ingredient with a value of 0 you have to remove it and continue mixing the cocktails.
You need to stop making cocktails when you run out of buckets with ingredients or freshness level values.
Your task is considered done if you make at least four cocktails - one of each type.
Input
•	The first line of input will represent the values of buckets with ingredients - integers, separated by a single space.
•	On the second line, you will be given the freshness values - integers again, separated by a single space.
Output
•	On the first line of output - print whether you've succeeded in preparing the cocktails
o	"It's party time! The cocktails are ready!".
o	"What a pity! You didn't manage to prepare all cocktails.".
•	On the next output line - print the sum of the ingredients only if they are left any
o	"Ingredients left: {sum of the left ingredients}".
•	On the last few lines, you have to print the cocktails you have made at least once, ordered alphabetically in the format:
" # {cocktail name} --> {amount}".

 */

import java.util.*;

public class AutumnCocktails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Integer> cocktails = new TreeMap<>();

        ArrayDeque<Integer> ingredientsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> freshnessStack = new ArrayDeque<>();

        int[] ingredients = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] freshness = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int ingredient : ingredients) {
            ingredientsQueue.offer(ingredient);
        }

        for (int fresh : freshness) {
            freshnessStack.push(fresh);
        }

        int pearSour = 0;
        int theHarvest = 0;
        int appleHinny = 0;
        int highFashion = 0;

        while (ingredientsQueue.size() > 0 && freshnessStack.size() > 0) {
            int currIngredient = ingredientsQueue.peek();
            int currFreshness = freshnessStack.peek();

            int product = currFreshness * currIngredient;

            if (currIngredient == 0) {
                ingredientsQueue.poll();

            } else if (product == 150 || product == 250 || product == 300 || product == 400) {
                String cocktail;
                if (product == 150) {
                    pearSour++;
                    cocktail = "Pear Sour";

                } else if (product == 250) {
                    theHarvest++;
                    cocktail = "The Harvest";

                } else if (product == 300) {
                    appleHinny++;
                    cocktail = "Apple Hinny";

                } else {
                    highFashion++;
                    cocktail = "High Fashion";
                }

                ingredientsQueue.poll();
                freshnessStack.pop();

                cocktails.putIfAbsent(cocktail, 0);
                cocktails.put(cocktail, cocktails.get(cocktail) + 1);

            } else {
                freshnessStack.pop();

                // increase the ingredient value by 5 and add at the end
                int newIngredientValue = currIngredient + 5;
                ingredientsQueue.poll();
                ingredientsQueue.offer(newIngredientValue);
            }
        }

        printOutput(cocktails, pearSour, theHarvest, appleHinny, highFashion, ingredientsQueue);
    }

    public static void printOutput(Map<String, Integer> cocktails, int pearSour, int theHarvest, int appleHinny, int highFashion, ArrayDeque<Integer> ingredientsQueue) {
        if (pearSour > 0 && theHarvest > 0 && appleHinny > 0 && highFashion > 0) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        int leftovers = ingredientsQueue.stream().mapToInt(i -> i).sum();

        if (leftovers > 0) {
            System.out.println("Ingredients left: " + leftovers);
        }

        cocktails.forEach((key, value) -> System.out.printf(" # %s --> %d%n", key, value));
    }
}
