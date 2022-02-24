import java.util.*;

public class FoodFinder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Character> vowelsQueue = readQueue(scan);
        ArrayDeque<Character> consonantsStack = readStack(scan);

        List<String> words = new ArrayList<>();
        words.add("pear");
        words.add("flour");
        words.add("pork");
        words.add("olive");

        List<Character> lettersContained = new ArrayList<>();
        List<String> correctWords = new ArrayList<>();

        while (!vowelsQueue.isEmpty() && !consonantsStack.isEmpty()) {
            char currChar1 = vowelsQueue.peek();
            char currChar2 = consonantsStack.peek();

            // iterate through all words
            for (String word : words) {
                // if the word contains the character, add it to the letters collection
                if (word.contains(String.valueOf(currChar1))) {
                    if (!lettersContained.contains(currChar1)) {
                        lettersContained.add(currChar1);
                    }
                }

                if (word.contains(String.valueOf(currChar2))) {
                    if (!lettersContained.contains(currChar2)) {
                        lettersContained.add(currChar2);
                    }
                }
            }

            // add the vowel to the back
            vowelsQueue.pop();
            vowelsQueue.add(currChar1);
            // remove the consonant
            consonantsStack.pop();
        }

        // iterate through words
        for (String word : words) {
            int correctLetters = 0;

            // iterate through individual characters
            for (int i = 0; i < word.length(); i++) {
                // if the 'letters' collection contains the individual character from the word,
                // increment the value of correct letters
                if (lettersContained.contains(word.charAt(i))) {
                    correctLetters++;
                }

                // if the number of correct letters is the word's length, add to the list of correct words
                if (correctLetters == word.length()) {
                    correctWords.add(word);
                }
            }
        }

        printOutput(correctWords);

    }

    public static void printOutput(List<String> correctWords) {
        System.out.println("Words found: " + correctWords.size());

        for (String word : correctWords) {
            System.out.println(word);
        }
    }

    public static ArrayDeque<Character> readQueue(Scanner scan) {
        ArrayDeque<Character> firstQueue = new ArrayDeque<>();

        String[] words = scan.nextLine().split("\\s+");
        char[] chars = new char[words.length];

        for (int i = 0; i < words.length; i++) {
            char ch = words[i].charAt(0);
            chars[i] = ch;
        }

        for (char currChar : chars) {
            firstQueue.offer(currChar);
        }

        return firstQueue;
    }

    public static ArrayDeque<Character> readStack(Scanner scan) {
        ArrayDeque<Character> secondStack = new ArrayDeque<>();

        String[] words = scan.nextLine().split("\\s+");
        char[] chars = new char[words.length];

        for (int i = 0; i < words.length; i++) {
            char ch = words[i].charAt(0);
            chars[i] = ch;
        }

        for (char currChar : chars) {
            secondStack.push(currChar);
        }

        return secondStack;
    }
}
