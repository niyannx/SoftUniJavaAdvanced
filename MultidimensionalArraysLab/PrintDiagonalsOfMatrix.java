package MultidimensionalArraysLab;

/*
Write a program that reads a matrix from the console. Then print the diagonals. The matrix will always be square.
On the first line, you read a single integer N the matrix size. Then on each line N elements. The first diagonal should
always start with the element at the first row and col, the second diagonal should start with the element at the last
row and first col.
 */

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfMatrix {
    public static int[] reverse(int[] diagonal) {
        int temp;

        for (int i = 0; i < diagonal.length / 2; i++) {
            temp = diagonal[i];
            diagonal[i] = diagonal[diagonal.length - i - 1];
            diagonal[diagonal.length - i - 1] = temp;
        }

        return diagonal;
    }

    public static void printDiagonals(int[] d1, int[] d2) {
        for (int num : d1) {
            System.out.printf("%d ", num);
        }

        System.out.println();

        for (int num : d2) {
            System.out.printf("%d ", num);
        }
    }

    public static int[] findD1(int[][] matrix) {
        int[] d1 = new int[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            d1[i] = matrix[i][i];
        }

        return d1;
    }

    public static int[] findD2(int[][] matrix) {
        int[] d2 = new int[matrix.length];

        int i = 0;

        for (int j = matrix.length - 1; j >= 0; j--) {
            d2[i] = matrix[i][j];
            i++;
        }

        d2 = reverse(d2);

        return d2;
    }

    public static int[][] readMatrix(Scanner scan, int n) {
        int[][] matrix = new int[n][n];

        for (int i = 0; i < matrix.length; i++) {
            int[] input = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[i] = input;
        }

        return matrix;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        int[][] matrix = readMatrix(scan, n);

        int[] d1 = findD1(matrix);
        int[] d2 = findD2(matrix);

        printDiagonals(d1, d2);
    }
}
