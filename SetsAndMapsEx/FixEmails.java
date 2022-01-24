package SetsAndMapsEx;

/*
You are given a sequence of strings, each on a new line until you receive the &quot;stop&quot; command. The first string is a
name of a person. On the second line, you receive his email. Your task is to collect their names and emails and
remove emails whose domain ends with &quot;us&quot;, &quot;uk&quot; or &quot;com&quot; (case insensitive). Print in the following format:
&quot;{name} – &gt; {email}&quot;
 */

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, String> emailBook = new LinkedHashMap<>();

        String input = scan.nextLine();

        while (!input.equals("stop")) {
            String name = input;
            String email = scan.nextLine();

            if (!email.toLowerCase(Locale.ROOT).contains(".com") && !email.toLowerCase(Locale.ROOT).contains(".uk") && !email.toLowerCase(Locale.ROOT).contains(".us")) {
                emailBook.put(name, email);
            }

            input = scan.nextLine();
        }

        for (Map.Entry<String, String> entry : emailBook.entrySet()) {
            System.out.printf("%s -> %s\n", entry.getKey(), entry.getValue());
        }

    }
}
