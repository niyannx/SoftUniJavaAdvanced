package MultidimensionalArraysEx;

/*
Filling a matrix in the regular way (top to bottom and left to right) is boring. Write two methods that fill a matrix with
size N x N in two different patterns. Both patterns are described below:
 */

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(", ");

        int[][] matrix = new int[Integer.parseInt(input[0])][Integer.parseInt(input[0])];

        if (input[1].equals("A")) {
            matrix = fillA(matrix);
        } else {
            matrix = fillB(matrix);
        }

        printMatrix(matrix);
    }

    public static int[][] fillA(int[][] matrix) {
        int currNumber = 1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][i] = currNumber;

                currNumber++;
            }
        }

        return matrix;
    }

    public static int[][] fillB(int[][] matrix) {
        int currNumber = 1;

        for (int i = 0; i < matrix.length; i++) {

            if (i % 2 == 0) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = currNumber;

                    currNumber++;
                }
            } else {
                for (int j = matrix.length - 1; j >= 0; j--) {
                    matrix[j][i] = currNumber;

                    currNumber++;
                }
            }
        }


        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%s ", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
