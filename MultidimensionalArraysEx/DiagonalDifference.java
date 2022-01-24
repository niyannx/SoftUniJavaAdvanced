package MultidimensionalArraysEx;

/*
Write a program that finds the difference between the sums of the square matrix diagonals (absolute value).
 */

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
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

    public static int findSumOfArray(int[] array) {
        int sum = 0;

        for (int j : array) {
            sum += j;
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        int[][] matrix = readMatrix(scan, n);

        int sumD1 = findSumOfArray(findD1(matrix));
        int sumD2 = findSumOfArray(findD2(matrix));

        System.out.println(Math.abs(sumD1 - sumD2));
    }
}
