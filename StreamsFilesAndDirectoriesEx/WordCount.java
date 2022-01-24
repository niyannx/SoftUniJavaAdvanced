package StreamsFilesAndDirectoriesEx;

/*
Write a program that reads a list of words from the file &quot;words.txt&quot; (from the Resources - Exercises) and finds how
many times each of the words is contained in another file &quot;text.txt&quot; (from the Resources - Exercises). Matching
should be case-insensitive.
Write the results in file &quot;results.txt&quot;. Sort the words by frequency in descending order.
 */

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class WordCount {
    public static void main(String[] args) throws IOException {
        String pathListOfWords = "src\\StreamsFilesAndDirectoriesEx\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
        String pathText = "src\\StreamsFilesAndDirectoriesEx\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
        String pathOut = "src\\StreamsFilesAndDirectoriesEx\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\results.txt";

        FileReader fileReaderOfWords = new FileReader(pathListOfWords);
        FileReader fileReaderOfText = new FileReader(pathText);
        FileWriter fileWriter = new FileWriter(pathOut);

        BufferedReader inWords = new BufferedReader(fileReaderOfWords);
        BufferedReader inText = new BufferedReader(fileReaderOfText);
        PrintWriter out = new PrintWriter(fileWriter);

        String wordLine = inWords.readLine();
        String textLine = inText.readLine();

        LinkedHashMap<String, Integer> results = new LinkedHashMap<>();

        while (wordLine != null) {
            while (textLine != null) {

                String[] searchedWords = wordLine.split("\\s+");
                String[] textWords = textLine.split("\\s+");

                for (String searchedWord : searchedWords) {
                    for (String textWord : textWords) {
                        if (searchedWord.equals(textWord)) {
                            if (!results.containsKey(searchedWord)) {
                                results.put(searchedWord, 0);
                            }
                            results.put(searchedWord, results.get(searchedWord) + 1);
                        }
                    }
                }
                textLine = inText.readLine();
            }
        wordLine = inWords.readLine();
        }

        results.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach((e1) -> {
                    String output = e1.toString().replace("=", " - ");

                    out.println(output);
                });

        out.close();
        inWords.close();
        inText.close();
    }
}
