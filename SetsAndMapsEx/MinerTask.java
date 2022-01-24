package SetsAndMapsEx;

/*
You are given a sequence of strings, each on a new line. Every odd line on the console is representing a resource
(e.g. Gold, Silver, Copper, and so on), and every even – quantity. Your task is to collect the resources and print them
each on a new line.
Print the resources and their quantities in the format:
"{resource} –> {quantity}";
 */

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Integer> mine = new LinkedHashMap<>();

        String input = scan.nextLine();

        while (!input.equals("stop")) {
            String resource = input;
            int quantity = Integer.parseInt(scan.nextLine());

            if (mine.containsKey(resource)) {
                mine.put(resource, mine.get(resource) + quantity);
            } else {
                mine.put(resource, quantity);
            }

            input = scan.nextLine();
        }

        for (Map.Entry<String, Integer> entry : mine.entrySet()) {
            System.out.printf("%s -> %d\n", entry.getKey(), entry.getValue());
        }
    }
}
