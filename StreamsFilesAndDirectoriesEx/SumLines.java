package StreamsFilesAndDirectoriesEx;

/*
Write a program that reads a text file (&quot;input.txt&quot; from the Resources - Exercises) and prints on the console the sum
of the ASCII symbols of each of its lines. Use BufferedReader in combination with FileReader.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumLines {
    public static void main(String[] args) throws IOException {
        String inPath = "src\\StreamsFilesAndDirectoriesEx\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\input.txt";

        FileReader fileReader = new FileReader(inPath);
        BufferedReader in = new BufferedReader(fileReader);

        String line = in.readLine();

        while (line != null) {
            long sum = 0;

            for (char c : line.toCharArray()) {
                sum += c;
            }

            System.out.println(sum);
            line = in.readLine();
        }
    }
}
