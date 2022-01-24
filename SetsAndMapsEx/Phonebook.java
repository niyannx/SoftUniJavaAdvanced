package SetsAndMapsEx;

/*
Write a program that receives some info from the console about people and their phone numbers.
You are free to choose how the data is entered. Each entry should have just one name and one number (both of
them strings). If you receive a name that already exists in the phonebook, simply update its number.
After filling this simple phonebook, upon receiving the command &quot;search&quot;, your program should be able to
perform a search of contact by name and print her details in the format &quot;{name} -&gt; {number}&quot;. In case the
contact isn&#39;t found, print &quot;Contact {name} does not exist.&quot;.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, String> phonebook = new HashMap<>();

        String input = scan.nextLine();

        while (!input.equals("search")) {
            String[] data = input.split("-");

            phonebook.put(data[0], data[1]);

            input = scan.nextLine();
        }

        input = scan.nextLine();

        while (!input.equals("stop")) {
            if (phonebook.containsKey(input)) {
                System.out.printf("%s -> %s\n", input, phonebook.get(input));
            } else {
                System.out.printf("Contact %s does not exist.\n", input);
            }

            input = scan.nextLine();
        }
    }
}
