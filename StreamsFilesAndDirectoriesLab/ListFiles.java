package StreamsFilesAndDirectoriesLab;

/*
You are provided a folder named &quot;Files-and-Streams&quot;. Create a program that lists the names and file sizes (in bytes)
of all files that are placed directly in it (do not include files in nested folders).
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

public class ListFiles {
    public static void main(String[] args) throws IOException {
        File file = new File("src\\StreamsFilesAndDirectoriesLab\\Files\\Files-and-Streams");
        String pathOut = "src\\StreamsFilesAndDirectoriesLab\\Files\\Files-and-Streams\\Files-and-Streams\\output.txt";

        File[] filesInsideDir = file.listFiles();
        PrintWriter out = new PrintWriter(new FileWriter(pathOut));

        if (filesInsideDir != null) {
            for (File currFile : filesInsideDir) {
                if (currFile.isFile()) {
                    long fileSize = Files.size(currFile.toPath());
                    out.println(currFile.getName() + ": [" + fileSize + "]");
                }
            }
        }

        out.close();
    }
}
