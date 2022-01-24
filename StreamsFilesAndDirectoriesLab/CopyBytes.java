package StreamsFilesAndDirectoriesLab;

/*
Read the file named &quot;input.txt&quot; and write to another file every character&#39;s ASCII representation.
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) {
        String pathIn = "src\\StreamsFilesAndDirectoriesLab\\Files\\input.txt";
        String pathOut = "src\\StreamsFilesAndDirectoriesLab\\Files\\03.CopyBytesOutput.txt";

        try (FileInputStream in = new FileInputStream(pathIn);
             FileOutputStream out = new FileOutputStream(pathOut)) {

            int oneByte = in.read();

            while (oneByte >= 0) {
                // if it's a space, write it as a space
                if (oneByte == 32 || oneByte == 10) {
                    out.write(oneByte);
                } else {
                    String digits = String.valueOf(oneByte);

                    for (int i = 0; i < digits.length(); i++) {
                        out.write(digits.charAt(i));
                    }
                }

                oneByte = in.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
