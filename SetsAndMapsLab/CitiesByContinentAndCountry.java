package SetsAndMapsLab;

/*
Write a program to read continents, countries, and their cities put them in a nested map, and print them in the
order of the first appearance.
 */

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, LinkedHashMap<String, ArrayList<String>>> data = new LinkedHashMap<>();

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");

            String continent = input[0];
            String country = input[1];
            String city = input[2];

            if (!data.containsKey(continent)) {
                data.put(continent, new LinkedHashMap<>());
            }

            if (!data.get(continent).containsKey(country)) {
                data.get(continent).put(country, new ArrayList<>());
            }

            data.get(continent).get(country).add(city);
        }

        for (Map.Entry<String, LinkedHashMap<String, ArrayList<String>>> entry : data.entrySet()) {
            System.out.printf("%s: ", entry.getKey());
            System.out.println();

            for (Map.Entry<String, ArrayList<String>> entryCountries : entry.getValue().entrySet()) {
                System.out.printf("  %s -> ", entryCountries.getKey());
                System.out.print(entryCountries.getValue().stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(", ")));

                System.out.println();
            }
        }
    }
}
