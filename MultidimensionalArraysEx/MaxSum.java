package MultidimensionalArraysEx;

/*
Write a program that reads a rectangular integer matrix of size N x M and finds in it the square 3 x 3 that has a
maximal sum of its elements.
 */

import java.util.Arrays;
import java.util.Scanner;

public class MaxSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[][] matrix = readMatrix(scan);

        findLargestMatrix(matrix);
    }

    public static void printOutput(int[][] matrix, int sum) {
        System.out.println("Sum = " + sum);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%d ", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static int findSumOfMatrix(int[][] matrix, int positionRow, int positionCol) {
        int sum = 0;

        for (int i = positionRow; i < positionRow + 3; i++) {
            for (int j = positionCol; j < positionCol + 3; j++) {
                sum += matrix[i][j];
            }
        }

        return sum;
    }

    public static int[][] getLargestFromPositions(int[][] matrix, int row, int col) {
        int[][] largestMatrix = new int[3][3];

        int currRow = 0;
        int currCol = 0;

        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                largestMatrix[currRow][currCol] = matrix[i][j];
                currCol++;
            }

            currCol = 0;
            currRow++;
        }

        return largestMatrix;
    }

    public static void findLargestMatrix(int[][] matrix) {
        int rowOfLargest = 0;
        int colOfLargest = 0;

        int largestSum = Integer.MIN_VALUE;

        for (int i = 0; i < matrix.length - 2; i++) {
            for (int j = 0; j < matrix[0].length - 2; j++) {
                if (findSumOfMatrix(matrix, i, j) > largestSum) {
                    largestSum = findSumOfMatrix(matrix, i, j);

                    rowOfLargest = i;
                    colOfLargest = j;
                }
            }
        }

        printOutput(getLargestFromPositions(matrix, rowOfLargest, colOfLargest), largestSum);
    }


    public static int[][] readMatrix(Scanner scan) {
        int[] dimensions = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] matrix = new int[dimensions[0]][dimensions[1]];

        for (int i = 0; i < matrix.length; i++) {
            int[] input = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[i] = input;
        }

        return matrix;
    }
}
