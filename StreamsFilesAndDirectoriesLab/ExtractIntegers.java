package StreamsFilesAndDirectoriesLab;

/*
Read the file provided, named &quot;input.txt&quot; and extracts all integers that are not a part of a word in a separate file. A
valid integer is surrounded by white spaces.
 */

import java.io.*;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws FileNotFoundException {
        String fileInput = "src\\StreamsFilesAndDirectoriesLab\\Files\\input.txt";
        String fileOutput = "src\\StreamsFilesAndDirectoriesLab\\Files\\04.ExtractIntegersOutput.txt";

        FileInputStream in = new FileInputStream(fileInput);
        PrintWriter out = new PrintWriter(new FileOutputStream(fileOutput));

        Scanner scan = new Scanner(in);

        while (scan.hasNext()) {
            if (scan.hasNextInt()) {
                out.println(scan.nextInt());
            }

            scan.next();
        }

        out.close();
    }
}
