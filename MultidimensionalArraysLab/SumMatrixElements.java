package MultidimensionalArraysLab;

/*
Write a program that reads a matrix from the console and prints:
 The count of rows
 The count of columns
 The sum of all matrix’s elements
On the first line, you will get the dimensions of the matrix in the format &quot;{rows, columns}&quot;. On the next lines,
you will get the elements for each row separated by a comma.
 */

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void printOutput(int rows, int cols, int sum) {
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);
    }

    public static int findSum(int[][] matrix) {
        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                sum += matrix[i][j];
            }
        }

        return sum;
    }

    public static int[][] readMatrix(Scanner scan, int rows, int cols) {
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            int[] line = Arrays.stream(scan.nextLine().split(",\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[i] = line;
        }

        return matrix;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scan.nextLine().split(",\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = readMatrix(scan, rows, cols);

        int sum = findSum(matrix);

        printOutput(rows, cols, sum);
    }
}
