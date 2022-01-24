package SetsAndMapsEx;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SerbianUnleashed {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String regex = "(?<singer>[A-Za-z ]+) @(?<venue>[A-Za-z ]+) (?<ticketsPrice>[0-9]+) (?<ticketsCount>[0-9]+)";
        Pattern pattern = Pattern.compile(regex);

        Map<String, Map<String, Integer>> data = new LinkedHashMap<>();

        String input = scan.nextLine();

        while (!input.equals("End")) {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String singer = matcher.group("singer");
                String venue = matcher.group("venue");
                int ticketsPrice =  Integer.parseInt(matcher.group("ticketsPrice"));
                int ticketsCount = Integer.parseInt(matcher.group("ticketsCount"));

                int total = ticketsCount * ticketsPrice;

                data.putIfAbsent(venue, new LinkedHashMap<>());
                data.get(venue).putIfAbsent(singer, 0);
                data.get(venue).put(singer, data.get(venue).get(singer) + total);
            }

            input = scan.nextLine();
        }

        printOutput(data);
    }

    public static void printOutput(Map<String, Map<String, Integer>> data) {
        for (Map.Entry<String, Map<String, Integer>> entry : data.entrySet()) {
            System.out.printf("%s \n", entry.getKey());

            LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();

            entry.getValue().entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

            for (Map.Entry<String, Integer> singersEntry : sortedMap.entrySet()) {
                System.out.printf("#  %s -> %d\n", singersEntry.getKey(), singersEntry.getValue());
            }
        }
    }
}
