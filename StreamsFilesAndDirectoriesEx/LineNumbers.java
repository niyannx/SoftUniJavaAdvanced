package StreamsFilesAndDirectoriesEx;

/*
Write a program that reads a text file (&quot;inputLineNumbers.txt&quot; from the Resources - Exercises) and inserts line
numbers in front of each of its lines. The result should be written to another text file – &quot;output.txt&quot;.
 */

import java.io.*;

public class LineNumbers {
    public static void main(String[] args) throws IOException {
        String pathIn = "src\\StreamsFilesAndDirectoriesEx\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        String pathOut = "src\\StreamsFilesAndDirectoriesEx\\output.txt";

        FileReader fileReader = new FileReader(pathIn);
        FileWriter fileWriter = new FileWriter(pathOut);

        BufferedReader in = new BufferedReader(fileReader);
        PrintWriter out = new PrintWriter(fileWriter);

        String line = in.readLine();

        int countOfLine = 0;

        while (line != null) {
            countOfLine++;

            out.println(countOfLine + ". " + line);

            line = in.readLine();
        }

        out.close();
        in.close();
    }
}
