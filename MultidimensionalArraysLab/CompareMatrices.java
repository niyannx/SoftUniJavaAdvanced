package MultidimensionalArraysLab;

/*
Write a program that reads two integer matrices (2D arrays) from the console and compares them element by
element. For better code re-usability, you could do the comparison in a method, which returns true if they are equal
and false if not.
Each matrix definition on the console will contain a line with a positive integer number R – the number of rows in
the matrix and C – the number of columns – followed by R lines containing the C numbers, separated by spaces
(each line will have an equal amount of numbers)
The matrices will have at most 10 rows and most 10 columns.
Print "equal" if the matrices match, and "not equal" if they don’t match.
 */

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstMatrixSize = scanner.nextLine().split("\\s+");
        int firstMatrixRows = Integer.parseInt(firstMatrixSize[0]);
        int firstMatrixCols = Integer.parseInt(firstMatrixSize[1]);

        int[][] firstMatrix = new int[firstMatrixRows][firstMatrixCols];

        //read 1st matrix
        for (int row = 0; row < firstMatrixRows; row++) {
            int[] rowData = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            firstMatrix[row] = rowData;
        }

        //read 2nd matrix
        String[] secondMatrixSize = scanner.nextLine().split("\\s+");
        int secondMatrixRows = Integer.parseInt(secondMatrixSize[0]);
        int secondMatrixCols = Integer.parseInt(secondMatrixSize[1]);

        if (firstMatrixRows != secondMatrixRows || firstMatrixCols != secondMatrixCols) {
            System.out.println("not equal");
            return;
        }
        int[][] secondMatrix = new int[secondMatrixRows][secondMatrixCols];
        for (int row = 0; row < secondMatrixRows; row++) {
            String[] rowData = scanner.nextLine().split("\\s+");
            for (int col = 0; col < secondMatrixCols; col++) {
                secondMatrix[row][col] = Integer.parseInt(rowData[col]);
            }
        }

        for (int row = 0; row < firstMatrixRows; row++) {
            for (int col = 0; col < secondMatrixCols; col++) {
                if (firstMatrix[row][col] !=
                        secondMatrix[row][col]) {
                    System.out.println("not equal");
                    return;
                }
            }
        }

        System.out.println("equal");
    }
}