package MultidimensionalArraysEx;

/*
Write a program to generate the following matrix of palindromes of 3 letters with r rows and c columns like the one
in the examples below.
 */

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scan.nextLine().split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        String[][] matrix = new String[dimensions[0]][dimensions[1]];

        fillMatrix(matrix);
        printMatrix(matrix);
    }

    public static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%s ", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void fillMatrix(String[][] matrix) {
        int currRow = 0;
        int currCol = 0;

        for (int i = 97; i < 97 + matrix.length; i++) {
            for (int j = i; j < i + matrix[0].length; j++) {

                matrix[currRow][currCol] = String.valueOf((char) i) + (char) j + (char) i;

                currCol++;
            }
            currCol = 0;
            currRow++;
        }
    }
}
