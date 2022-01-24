package MultidimensionalArraysEx;

/*
You are given a sequence of text lines. Assume these text lines form a matrix of characters (pad the missing
positions with spaces to build a rectangular matrix). Write a program to rotate the matrix by 90, 180, 270, 360,…
degrees. Print the result at the console as a sequence of strings after receiving the "END" command.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String rotation = scan.nextLine();
        int angleRotation = Integer.parseInt(rotation.split("[()]+")[1]) % 360;

        ArrayList<String> linesForMatrix = new ArrayList<>();

        int maxLength = 0;

        while (true) {
            String line = scan.nextLine();

            if (line.equals("END")) {
                break;
            }
            linesForMatrix.add(line);

            if (line.length() > maxLength) {
                maxLength = line.length();
            }
        }

        int rows = linesForMatrix.size();
        int cols = maxLength;

        char[][] matrix = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (j < linesForMatrix.get(i).length()) {
                    matrix[i][j] = linesForMatrix.get(i).charAt(j);
                } else {
                    matrix[i][j] = ' ';
                }
            }
        }

        rotate(angleRotation, rows, cols, matrix);
    }

    public static void rotate(int angleRotation, int rows, int cols, char[][] matrix) {
        if (angleRotation == 90) {

            for (int col = 0; col < cols; col++) {
                for (int row = rows - 1; row >= 0; row--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }

        } else if (angleRotation == 180) {

            for (int row = rows - 1; row >= 0; row--) {
                for (int col = cols - 1; col >= 0; col--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }

        } else if (angleRotation == 270) {

            for (int col = cols - 1; col >= 0; col--) {
                for (int row = 0; row < rows; row++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }

        } else {

            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }
    }
}
