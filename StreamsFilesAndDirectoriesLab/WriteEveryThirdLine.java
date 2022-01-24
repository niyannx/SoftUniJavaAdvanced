package StreamsFilesAndDirectoriesLab;

import java.io.*;
import java.util.Scanner;

/*
Read the file provided, named &quot;input.txt&quot; and write to another file all lines which number is divisible by 3. Line
numbers start from one.
 */

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        String pathIn = "src\\StreamsFilesAndDirectoriesLab\\Files\\input.txt";
        String pathOut = "src\\StreamsFilesAndDirectoriesLab\\Files\\05.WriteEveryThirdLineOutput.txt";

        Scanner in = new Scanner(new FileReader(pathIn));
        PrintWriter out = new PrintWriter(new FileWriter(pathOut));

        int counter = 1;
        String line = in.nextLine();

        while (in.hasNextLine()) {
            if (counter % 3 == 0) {
                out.println(line);
            }

            counter++;

            line = in.nextLine();
            out.flush();
        }
        out.close();
        in.close();
    }
}
