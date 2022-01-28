package FunctionalProgrammingEx;

/*
The Wire’s parents are on a vacation for the holidays, and he is planning an epic party at home. Unfortunately,
his organizational skills are next to non-existent, so you are given the task to help him with the reservations.
On the first line, you get a list of all the people that are coming. On the next lines, until you get the "Party!"
command, you may be asked to double or remove all the people that apply to the given criteria. There are three
different options:

•	Everyone that has a name starts with a given string.
•	Everyone that has a name ending with a given string.
•	Everyone that has a name with a given length.

When you print the guests that are coming to the party, you have to print them in ascending order. If nobody is going,
print "Nobody is going to the party!". See the examples below:

        Input                 Output
Peter Misha Stephan  |
Remove StartsWith P  |  Misha, Misha, Stephan are going to the party!
Double Length 5      |
Party!	             |



        Input                 Output
Peter                   |
Double StartsWith Pete  |  Peter, Peter, Peter, Peter are going to the party!
Double EndsWith eter    |
Party!                  |



        Input                 Output
Peter                   |
Remove StartsWith P     |   Nobody is going to the party!
Party!                  |
 */

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> party = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());

        String command = scan.nextLine();

        Predicate<String> filter = null;

        while (!command.equals("Party!")) {
            String[] input = command.split("\\s+");

            if (input[0].equals("Remove")) {
                switch (input[1]) {
                    case "StartsWith":
                        String startsWith = input[2];

                        filter = name -> !name.startsWith(startsWith);
                        break;
                    case "EndsWith":
                        String endsWith = input[2];

                        filter = name -> !name.endsWith(endsWith);
                        break;
                    case "Length":
                        int length = Integer.parseInt(input[2]);

                        filter = name -> name.length() != length;
                        break;
                }

                if (filter != null) {
                    party = party.stream().filter(filter).collect(Collectors.toList());
                }
            } else if (input[0].equals("Double")) {

                switch (input[1]) {
                    case "StartsWith":
                        String startsWith = input[2];

                        filter = name -> name.startsWith(startsWith);
                        break;
                    case "EndsWith":
                        String endsWith = input[2];

                        filter = name -> name.endsWith(endsWith);
                        break;
                    case "Length":
                        int length = Integer.parseInt(input[2]);

                        filter = name -> name.length() == length;
                        break;
                }

                if (filter != null) {
                    List<String> toDouble = party.stream().filter(filter).collect(Collectors.toList());
                    party.addAll(toDouble);
                }
            }

            command = scan.nextLine();
        }

        party = party.stream()
                .sorted()
                .collect(Collectors.toList());

        if (party.size() != 0) {
            System.out.printf("%s are going to the party!", String.join(", ", party));
        } else {
            System.out.println("Nobody is going to the party!");
        }
    }
}
