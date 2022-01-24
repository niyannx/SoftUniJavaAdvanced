package MultidimensionalArraysEx;

/*
You will receive two integers, which represent the dimensions of a matrix. Then, you must fill the matrix with
increasing integers starting from 1, and continuing on every row, like this:
first row: 1, 2, 3, …, n
second row: n + 1, n + 2, n + 3, …, n + n
third row: 2 * n + 1, 2 * n + 2, …, 2 * n + n
You will also receive several commands in the form of 3 integers separated by a space. Those 3 integers will
represent a row in the matrix, a column, and a radius. You must then destroy the cells, which correspond to those
arguments cross-like.
Destroying a cell means that, that cell becomes completely nonexistent in the matrix. Destroying cells cross-like
means that you form a cross figure with center point - equal to the cell with coordinates – the given row and
column, and lines with length equal to the given radius. See the examples for more info.
The input ends when you receive the command &quot;Nuke it from orbit&quot;. When that happens, you must print
what has remained from the initial matrix.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scan.nextLine().split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        List<List<Integer>> matrix = new ArrayList<>();

        fillMatrix(matrix, rows, cols);


        String input = scan.nextLine();

        while (!input.equals("Nuke it from orbit")) {
            int rowCoordinates = Integer.parseInt(input.split("\\s+")[0]);
            int colCoordinates = Integer.parseInt(input.split("\\s+")[1]);
            int destructionRange = Integer.parseInt(input.split("\\s+")[2]);

            destroy(matrix, rowCoordinates, colCoordinates, destructionRange);

            input = scan.nextLine();
        }

        printOutput(matrix);
    }

    public static void fillMatrix(List<List<Integer>> matrix, int rows, int cols) {
        int num = 1;

        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                matrix.get(row).add(num++);
            }
        }
    }

    public static void destroy(List<List<Integer>> matrix, int rowCoordinates, int colCoordinates, int destructionRange) {
        for (int i = rowCoordinates - destructionRange; i <= rowCoordinates + destructionRange; i++) {
            if (isInRange(i, colCoordinates, matrix) && i != rowCoordinates) {
                matrix.get(i).remove(colCoordinates);
            }
        }

        for (int i = colCoordinates + destructionRange; i >= colCoordinates - destructionRange; i--) {
            if (isInRange(rowCoordinates, i, matrix)) {
                matrix.get(rowCoordinates).remove(i);
            }
        }

        matrix.removeIf(List::isEmpty);
    }

    public static boolean isInRange(int row, int col, List<List<Integer>> matrix) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }

    public static void printOutput(List<List<Integer>> matrix) {
        for(List<Integer> integers : matrix){
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
