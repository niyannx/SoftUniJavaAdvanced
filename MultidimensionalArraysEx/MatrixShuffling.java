package MultidimensionalArraysEx;

/*
Write a program, which reads a string matrix from the console and performs certain operations with its elements.
User input is provided in a similar way as in the problems above – first, you read the dimensions and then the data.
Your program should then receive commands in the format: &quot;swap row1 col1 row2c col2&quot; where row1, row2,
col1, col2 are coordinates in the matrix. For a command to be valid, it should start with the &quot;swap&quot; keyword along
with four valid coordinates (no more, no less). You should swap the values at the given coordinates (cell [row1,
col1] with cell [row2, col2]) and print the matrix at each step (this you&#39;ll be able to check if the operation was
performed correctly).
If the command is not valid (doesn't contain the keyword &quot;swap&quot;, has fewer or more coordinates entered or the
given coordinates do not exist), print &quot;Invalid input!&quot; and move on to the next command. Your program should
finish when the string &quot;END&quot; is entered.
 */

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[][] matrix = readMatrix(scan);

        String[] input = scan.nextLine().split("\\s+");

        while (!input[0].equals("END")) {
            if (input[0].equals("swap")) {
                if (input.length == 5) {
                    if (coordinatesAreValid(input, matrix)) {
                        swap(matrix, Integer.parseInt(input[1]), Integer.parseInt(input[2]), Integer.parseInt(input[3]), Integer.parseInt(input[4]));
                        printMatrix(matrix);
                    } else {
                        System.out.println("Invalid input!");
                    }
                } else {
                    System.out.println("Invalid input!");
                }
            } else {
                System.out.println("Invalid input!");
            }

            input = scan.nextLine().split("\\s+");
        }

    }

    public static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%s ", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void swap(String[][] matrix, int row1, int col1, int row2, int col2) {
        String temp;

        temp = matrix[row1][col1];
        matrix[row1][col1] = matrix[row2][col2];
        matrix[row2][col2] = temp;
    }

    public static boolean coordinatesAreValid(String[] input, String[][] matrix) {
        int row1 = Integer.parseInt(input[1]);
        int col1 = Integer.parseInt(input[2]);
        int row2 = Integer.parseInt(input[3]);
        int col2 = Integer.parseInt(input[4]);

        if (row1 < 0 || row1 >= matrix.length) {
            return false;
        }

        if (row2 < 0 || row2 >= matrix.length) {
            return false;
        }

        if (col1 < 0 || col1 >= matrix[0].length) {
            return false;
        }

        if (col2 < 0 || col2 >= matrix[0].length) {
            return false;
        }

        return true;
    }


    public static String[][] readMatrix(Scanner scan) {
        int[] dimensions = Arrays.stream(scan.nextLine().split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        String[][] matrix = new String[dimensions[0]][dimensions[1]];

        for (int i = 0; i < matrix.length; i++) {
            String[] row = scan.nextLine().split("\\s+");

            matrix[i] = row;

        }

        return matrix;
    }
}
