package MultidimensionalArraysLab;

/*
Write a program that reads a matrix of integers from the console, then a number, and prints all the positions at
which that number appears in the matrix.
The matrix definition on the console will contain a line with two positive integer numbers R and C – the number of
rows and columns in the matrix – followed by R lines, each containing C numbers (separated by spaces),
representing each row of the matrix.
The number you will need to find the positions of will be entered on a single line, after the matrix.
You should print each position on a single line – first print the row, then the column at which the number appears.
If the number does not appear in the matrix, print &quot;not found&quot;.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[][] matrix = readMatrix(scan);
        int number = Integer.parseInt(scan.nextLine());

        boolean found = false;

        List<String> coordinates = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == number) {
                    found = true;
                    coordinates.add(i + " " + j);
                }
            }
        }

        if (found) {
            for (String coordinate : coordinates) {
                System.out.println(coordinate);
            }
        } else {
            System.out.println("not found");
        }
    }

    public static int[][] readMatrix(Scanner scan) {
        int[] dimensions = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            int[] currRow = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[i] = currRow;
        }

        return matrix;
    }
}