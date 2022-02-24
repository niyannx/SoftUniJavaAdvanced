package Exams.RetakeExam16Dec2020;

import java.util.*;
import java.util.stream.Collectors;

public class Cooking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> liquidQueue = readQueue(scan);
        ArrayDeque<Integer> ingredientsStack = readStack(scan);

        Map<String, Integer> foods = new TreeMap<>();

        int cakes = 0;
        int bread = 0;
        int fruitPie = 0;
        int pastries = 0;

        while (!liquidQueue.isEmpty() && !ingredientsStack.isEmpty()) {
            int sum = liquidQueue.peek() + ingredientsStack.peek();

            boolean crafted = false;

            switch (sum) {
                case 25:
                    bread++;
                    crafted = true;
                    break;
                case 50:
                    cakes++;
                    crafted = true;
                    break;
                case 75:
                    pastries++;
                    crafted = true;
                    break;
                case 100:
                    fruitPie++;
                    crafted = true;
                    break;
                default:
                    liquidQueue.poll();
                    int valueIngredient = ingredientsStack.pop() + 3;
                    ingredientsStack.push(valueIngredient);
            }

            if (crafted) {
                liquidQueue.poll();
                ingredientsStack.pop();
            }
        }

        foods.put("Bread", bread);
        foods.put("Cake", cakes);
        foods.put("Fruit Pie", fruitPie);
        foods.put("Pastry", pastries);

        printOutput(foods, bread, cakes, fruitPie, pastries, liquidQueue, ingredientsStack);
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

    public static void printOutput(Map<String, Integer> foods, int bread, int cakes, int pies, int pastries, ArrayDeque<Integer> liquids, ArrayDeque<Integer> ingredients) {
        if (bread > 0 && cakes > 0 && pies > 0 && pastries > 0) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        System.out.println("Liquids left: " + left(liquids));
        System.out.println("Ingredients left: " + left(ingredients));

        foods.forEach((key, value) -> System.out.println(key + ": " + value));
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
