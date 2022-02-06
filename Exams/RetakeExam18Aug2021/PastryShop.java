package Exams.RetakeExam18Aug2021;

/*
You are asked to cook pastries and cakes for the near pastry shop, because your recipes are so great. You need to mix
liquids with ingredients to cook the required delicacies.
First, you will be given a sequence of integers, representing liquids. Afterwards, you will be given another sequence
of integers representing ingredients.
You need to start from the first liquid and try to mix it with the last ingredient. If the sum of their values is equal
to any of the items in the table below – cook the food corresponding to the value and remove both the liquid and the
ingredient. Otherwise, remove only the liquid and increase the value of the ingredient by 3. You need to stop combining
when you have no more liquids or ingredients.

  Food	 | Value needed
Biscuit	 |      25
  Cake	 |      50
 Pastry  |	    75
  Pie	 |     100

Input
•	On the first line, you will receive the integers representing the liquids, separated by a single space. 
•	On the second line, you will receive the integers representing the ingredients, separated by a single space.

Output

•	On the first line of output print one of the following outputs:
    o	"Great! You succeeded in cooking all the food!" -if you have at least
one of each of the foods, after completing combining.
    o	"What a pity! You didn't have enough materials to cook everything." – if you did not collect one of each of the
foods, after completing combining.

•	On the second line - print all liquids you have left:
    o	If there are no liquids: "Liquids left: none"
    o	If there are liquids: "Liquids left: {liquid1}, {liquid2}, {liquid3}, (…)"

•	On the third line - print all physical materials you have left:
    o	If there are no items: "Ingredients left: none"
    o	If there are items: "Ingredients left: {ingredient}, {ingredient}, {ingredient}, (…)"

•	Then, you need to print all Advanced Materials and the amount you have of them, ordered:
    o	"Biscuit: {amount}"
    o	"Cake: {amount}"
    o	"Pie: {amount}"
    o	"Pastry: {amount}"

 */

import java.util.*;
import java.util.stream.Collectors;

public class PastryShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Integer> foods = new LinkedHashMap<>();

        ArrayDeque<Integer> liquidsQueue = readQueue(scan);
        ArrayDeque<Integer> ingredientsStack = readStack(scan);

        int biscuits = 0;
        int cakes = 0;
        int pastries = 0;
        int pies = 0;

        while (!ingredientsStack.isEmpty() && !liquidsQueue.isEmpty()) {
            boolean crafted = false;

            int liquid = liquidsQueue.peek();
            int ingredient = ingredientsStack.peek();

            int sum = liquid + ingredient;

            switch (sum) {
                case 25:
                    crafted = true;
                    biscuits++;
                    break;
                case 50:
                    crafted = true;
                    cakes++;
                    break;
                case 75:
                    crafted = true;
                    pastries++;
                    break;
                case 100:
                    crafted = true;
                    pies++;
                    break;
                default:
                    liquidsQueue.poll();
                    int valueIngredient = ingredientsStack.pop() + 3;
                    ingredientsStack.push(valueIngredient);
            }
            if (crafted) {
                liquidsQueue.poll();
                ingredientsStack.pop();
            }
        }

        foods.put("Biscuit", biscuits);
        foods.put("Cake", cakes);
        foods.put("Pie", pastries);
        foods.put("Pastry", pies);

        printOutput(biscuits, cakes, pastries, pies, liquidsQueue, ingredientsStack, foods);
    }

    public static void printOutput(int biscuits, int cakes, int pastries, int pies, ArrayDeque<Integer> liquidsQueue, ArrayDeque<Integer> ingredientsStack, Map<String, Integer> foods) {
        if (biscuits > 0 && cakes > 0 && pastries > 0 && pies > 0) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        System.out.println("Liquids left: " + left(liquidsQueue));
        System.out.println("Ingredients left: " + left(ingredientsStack));

        foods.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    public static String left(ArrayDeque<Integer> queueOrStack) {
        StringBuilder sb = new StringBuilder();

        if (queueOrStack.isEmpty()) {
            sb.append("none");
        } else {
            sb.append(queueOrStack.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(", ")));
        }

        return sb.toString();
    }

    public static ArrayDeque<Integer> readQueue(Scanner scan) {
        ArrayDeque<Integer> liquidsQueue = new ArrayDeque<>();

        int[] liquids = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int liquid : liquids) {
            liquidsQueue.offer(liquid);
        }

        return liquidsQueue;
    }

    public static ArrayDeque<Integer> readStack(Scanner scan) {
        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();

        int[] ingredients = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();


        for (int ingredient : ingredients) {
            ingredientsStack.push(ingredient);
        }

        return ingredientsStack;
    }
}