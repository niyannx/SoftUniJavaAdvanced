package StreamsFilesAndDirectoriesLab;

/*
Read the file named &quot;input.txt&quot; that is provided for this exercise and write all its content to a file while skipping
any punctuation. Skip the following symbols: &quot;,&quot;, &quot;.&quot;, &quot;!&quot;, &quot;?&quot;.
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class WriteToFile {
    public static void main(String[] args) {
        String pathIn = "src\\StreamsFilesAndDirectoriesLab\\Files\\input.txt";
        String pathOut = "src\\StreamsFilesAndDirectoriesLab\\Files\\02.WriteToFileOutput.txt";

        Set<Character> punctuation = new HashSet<>();

        Collections.addAll(punctuation, '!', ',', '.', '?');

        try (FileInputStream in = new FileInputStream(pathIn);
             FileOutputStream out = new FileOutputStream(pathOut)) {
            int oneByte = in.read();

            while (oneByte >= 0) {
                if (!punctuation.contains((char) oneByte)) {
                    out.write(oneByte);
                }

                oneByte = in.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
