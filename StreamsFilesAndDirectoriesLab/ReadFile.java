package StreamsFilesAndDirectoriesLab;

/*
You are given a file named &quot;input.txt&quot;. Read and print all of its contents as a sequence of bytes (the binary
representation of the ASCII code for each character) separated by a single comma.
 */

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {
        String path = "src\\StreamsFilesAndDirectoriesLab\\Files\\input.txt";

        try (FileInputStream fileStream = new FileInputStream(path)) {
            int oneByte = fileStream.read();

            while (oneByte >= 0) {
                System.out.printf("%s ", Integer.toBinaryString(oneByte));
                oneByte = fileStream.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
