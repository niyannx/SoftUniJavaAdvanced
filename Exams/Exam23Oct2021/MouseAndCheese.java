package Exams.Exam23Oct2021;

/*
You will be given an integer n for the size of the mouse territory with a square shape. On the next n lines, you will
receive the rows of the territory. The mouse will be placed in a random position, marked with the letter 'M'. On random
positions, there will be cheese, marked with 'c'. There may also be a bonus on the territory. There will always be only
one bonus. It will be marked with the letter - 'B'. All the empty positions will be marked with '-'.
Each turn, you will be given a command for the mouse’s movement.
The commands will be: "up", "down", "left", "right", "end".
If the mouse moves to cheese, it eats the cheese and increases the cheese it has eaten by one.
If it goes to a bonus, the mouse gets a bonus one move forward and then the bonus disappears. If the mouse goes out she can't return and the program ends. If the mouse receives "end" command the program ends. The mouse needs at least 5 eaten cheeses.
Input
•	On the first line, you are given the integer n – the size of the square matrix.
•	The next n lines hold the values for every row.
•	On each of the next lines, until you receive "end" command,  you will receive a move command.
Output
•	On the first line:
o	If the mouse goes out of its territory print: "Where is the mouse?".
•	On the second line:
o	 If the mouse couldn't eat enough cheeses print: "The mouse couldn't eat the cheeses, she needed {needed} cheeses more.".
o	If the mouse has successfully eaten enough cheeses print: "Great job, the mouse is fed {eaten cheeses} cheeses!".
•	At the end print the matrix.

 */

import java.util.Scanner;

public class MouseAndCheese {
    public static char[][] matrix;

    public static int mouseRow;
    public static int mouseCol;

    public static int cheeseEaten = 0;

    public static boolean mouseLost = false;
    public static boolean eatenEnoughCheese = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        matrix = new char[size][size];
        readTerritory(scanner);

        String input = scanner.nextLine();
        while (!input.equals("end")) {

            matrix[mouseRow][mouseCol] = '-';
            moveMouse(input);

            if (mouseLost) {
                break;
            }

            input = scanner.nextLine();
        }

        if (mouseLost) {
            System.out.println("Where is the mouse?");
        }

        if (cheeseEaten >= 5) {
            eatenEnoughCheese = true;
        }

        if (eatenEnoughCheese) {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", cheeseEaten);

        } else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - cheeseEaten);
        }

        printMatrix();
    }

    private static void moveMouse(String direction) {
        int row = mouseRow;
        int col = mouseCol;

        switch (direction) {
            case "up":
                row--;
                break;

            case "down":
                row++;
                break;

            case "left":
                col--;
                break;

            case "right":
                col++;
                break;
        }

        boolean inBounds = checkIfInBounds(row, col);
        if (inBounds) {
            char currentCell = matrix[row][col];

            switch (currentCell) {
                case 'c':
                    cheeseEaten++;
                    break;

                case 'B':
                    matrix[row][col] = '-';

                    switch (direction) {
                        case "up":
                            row--;
                            break;

                        case "down":
                            row++;
                            break;

                        case "left":
                            col--;
                            break;

                        case "right":
                            col++;
                            break;
                    }

                    if (matrix[row][col] == 'c') {
                        cheeseEaten++;
                    }
                    break;
            }

            mouseRow = row;
            mouseCol = col;

            matrix[mouseRow][mouseCol] = 'M';

        } else {
            mouseLost = true;
        }
    }

    private static boolean checkIfInBounds(int row, int col) {
        return (row >= 0) && (row < matrix.length) &&
                (col >= 0) && (col < matrix[row].length);
    }

    private static void readTerritory(Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            String[] elements = scanner.nextLine().split("");

            for (int col = 0; col < elements.length; col++) {
                char currentChar = elements[col].charAt(0);

                if (currentChar == 'M') {
                    mouseRow = row;
                    mouseCol = col;
                }

                matrix[row][col] = currentChar;
            }
        }
    }

    private static void printMatrix() {
        for (char[] row : matrix) {
            for (char col : row) {
                System.out.print(col);
            }

            System.out.println();
        }
    }
}