package MultidimensionalArraysLab;

/*
Write a program that reads two char matrices (A[][] and B[][]) of the same order M * N and prints third matrix C[][]
which is filled with the intersecting elements of A and B, otherwise set the element to &#39;*&#39;. On the first two lines, you
receive M and N, then on 2 * M lines N characters – the matrices elements.
The matrix elements may be any ASCII char except &#39;*&#39;.
 */

import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%s ", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static String[][] findIntersections(String[][] first, String[][] second, int rows, int cols) {
        String[][] intersectingElements = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (first[i][j].equals(second[i][j])) {
                    intersectingElements[i][j] = first[i][j];
                } else {
                    intersectingElements[i][j] = "*";
                }
            }
        }

        return intersectingElements;
    }

    public static String[][] readMatrix(Scanner scan, int rows, int cols) {
        String[][] matrix = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] line = scan.nextLine().split("\\s+");

            matrix[i] = line;
        }

        return matrix;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = Integer.parseInt(scan.nextLine());
        int cols = Integer.parseInt(scan.nextLine());

        String[][] firstMatrix = readMatrix(scan, rows, cols);
        String[][] secondMatrix = readMatrix(scan, rows, cols);

        String[][] intersectingElements = findIntersections(firstMatrix, secondMatrix, rows, cols);
        printMatrix(intersectingElements);
    }
}
