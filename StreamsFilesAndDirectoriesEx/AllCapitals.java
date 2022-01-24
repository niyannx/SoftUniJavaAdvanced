package StreamsFilesAndDirectoriesEx;

/*
Write a program that reads a text file (&quot;input.txt&quot; from the Resources - Exercises) and changes the casing of all
letters to the upper. Write the output to another file (&quot;output.txt&quot;).
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

public class AllCapitals {
    public static void main(String[] args) throws IOException {
        String inPath = "src\\StreamsFilesAndDirectoriesEx\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\input.txt";

        FileReader fileReader = new FileReader(inPath);
        BufferedReader in = new BufferedReader(fileReader);

        String line = in.readLine();

        while (line != null) {
            String output = line.toUpperCase(Locale.ROOT);

            System.out.println(output);

            line = in.readLine();
        }
    }
}
