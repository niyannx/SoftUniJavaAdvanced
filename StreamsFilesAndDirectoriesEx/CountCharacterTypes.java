package StreamsFilesAndDirectoriesEx;

/*
Write a program that reads a list of words from the file (&quot;input.txt&quot; from the Resources - Exercises) and finds the
count of vowels, consonants, and punctuation marks. Assume that:
 a, e, i, o, u are vowels, only lower case.
 All others are consonants.
 Punctuation marks are (! , . ?).
 Do not count whitespace.
Write the results to another file – &quot;output.txt&quot;.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        String inPath = "src\\StreamsFilesAndDirectoriesEx\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\input.txt";

        FileReader fileReader = new FileReader(inPath);
        BufferedReader in = new BufferedReader(fileReader);

        Set<Character> vowels = new HashSet<>();
        Set<Character> punctuation = new HashSet<>();

        Collections.addAll(vowels, 'a', 'e', 'i', 'o', 'u');
        Collections.addAll(punctuation, '!', ',', '.', '?');

        String line = in.readLine();

        int vowelsCount = 0;
        int punctuationCount = 0;
        int consonantsCount = 0;

        while (line != null) {
            for (char c : line.toCharArray()) {
                if (c != ' ') {
                    if (vowels.contains(c)) {
                        vowelsCount++;
                    } else if (punctuation.contains(c)) {
                        punctuationCount++;
                    } else {
                        consonantsCount++;
                    }
                }
            }

            line = in.readLine();
        }

        System.out.println("Vowels: " + vowelsCount);
        System.out.println("Consonants: " + consonantsCount);
        System.out.println("Punctuation: " + punctuationCount);
    }
}
