package StreamsFilesAndDirectoriesLab;

/*
Read the file provided, named &quot;input.txt&quot; and sort all lines. Write text to another text file. Use Path and Files
Classes.
 */

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class SortLines {
    public static void main(String[] args) throws IOException {
        String pathIn = "src\\StreamsFilesAndDirectoriesLab\\Files\\input.txt";
        String pathOut = "src\\StreamsFilesAndDirectoriesLab\\Files\\06.SortLinesOutput.txt";

        Path input = Paths.get(pathIn);
        Path output = Paths.get(pathOut);

        List<String> lines = Files.readAllLines(input);
        Collections.sort(lines);
        Files.write(output, lines);
    }
}
