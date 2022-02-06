package Exams.RetakeExam18Aug2021;

/*
You will be given an integer N for the size of the square matrix and then an integer for the count of commands. On the
next n lines, you will receive the rows of the matrix. The player starts at a random position (the player is marked
with "P") and all the empty slots will be filled with "." (dot). The goal is to reach the finish mark which will be
marked with "F". On the field there can also be bonuses and traps. Bonuses are marked with "B" and traps are marked
with "T".

Each turn you will be given commands for the player’s movement. If the player goes out of the matrix, he comes in from
the other side. For example, if the player is on 0, 0 and the next command is left, he goes to the last spot on the first row.
If the player steps on a bonus, he should move another step forward in the direction he is going. If the player steps
on a trap, he should move a step backwards.

When the player reaches the finish mark or the count of commands is reached, the game ends.

Input
•	On the first line, you are given the integer N – the size of the square matrix.
•	On the second you are given the count of commands.
•	The next N lines hold the values for every row.
•	On each of the next lines you will get commands for movement directions.

Output
•	If the player reaches the finish mark, print:
    o	"Well done, the player won first place!"
•	If the player reaches the commands count and hasn't reached the finish mark print:
    o	"Oh no, the player got lost on the track!"
•	In the end print the matrix.

Constraints
•	The size of the matrix will be between [2…20].
•	The players will always be indicated with "P".
•	If the player steps on the finish mark at the same time as his last command, he wins the game.
•	When the final matrix is printed and the vehicle has completed successfully, you must replace the "F" with the "P".
•	Commands will be in the format up, down, left or right.
•	There won't be a case where you bypass the finish while you are on a trap or a bonus.
•	A trap will never place you into a bonus or another trap and a bonus will never place you into a trap or another bonus.

 */

import java.util.Scanner;

public class FormulaOne {
    public static char[][] matrix;

    public static int playerRow;
    public static int playerCol;

    public static int finishRow;
    public static int finishCol;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());
        int numOfCommands = Integer.parseInt(scan.nextLine());

        readMatrix(size, scan);

        boolean won = false;
        for (int i = 0; i < numOfCommands; i++) {
            matrix[playerRow][playerCol] = '.';

            // read the command
            String command = scan.nextLine();

            // move according to it
            move(command);

            // if the player has reached a trap, move in the opposite direction of the last command
            if (reachedTrap()) {
                move(getOppositeOf(command));
            }

            // if the player has reached a bonus, move in the same direction of the last command
            if (reachedBonus()) {
                move(command);
            }

            matrix[playerRow][playerCol] = 'P';

            // if the player has reached the finish line, he has won the game, the loop stops
            if (reachedFinishLine()) {
                System.out.println("Well done, the player won first place!");
                won = true;
                break;
            }
        }

        // if the player hasn't won the game, then he's gotten lost on the track
        if (!won) {
            System.out.println("Oh no, the player got lost on the track!");
        }

        // print the matrix
        printMatrix();
    }

    // METHODS --------------------------------------------------------------------------------------------------------

    private static boolean reachedTrap() {
        return matrix[playerRow][playerCol] == 'T';
    }

    private static boolean reachedBonus() {
        return matrix[playerRow][playerCol] == 'B';
    }

    private static boolean reachedFinishLine() {
        return playerCol == finishCol && playerRow == finishRow;
    }

    // method for getting the opposite command (it may be done with a map too)
    private static String getOppositeOf(String command) {
        String newCommand = "";

        switch (command) {
            case "up":
                newCommand = "down";
                break;
            case "down":
                newCommand = "up";
                break;
            case "left":
                newCommand = "right";
                break;
            case "right":
                 newCommand = "left";
                break;
        }

        return newCommand;
    }

    private static void move(String command) {
        switch (command) {
            case "up":
                if (playerRow - 1 >= 0) {
                    playerRow--;
                } else {
                    playerRow = matrix.length - 1;
                }
                break;
            case "down":
                if (playerRow + 1 < matrix.length) {
                    playerRow++;
                } else {
                    playerRow = 0;
                }
                break;
            case "left":
                if (playerCol - 1 >= 0) {
                    playerCol--;
                } else {
                    playerCol = matrix[0].length - 1;
                }
                break;
            case "right":
                if (playerCol + 1 < matrix[0].length) {
                    playerCol++;
                } else {
                    playerCol = 0;
                }
                break;
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

    private static void readMatrix(int size, Scanner scan) {
        matrix = new char[size][size];

        for (int row = 0; row < matrix.length; row++) {
            String[] elements = scan.nextLine().split("");

            for (int col = 0; col < elements.length; col++) {
                char currentChar = elements[col].charAt(0);

                if (currentChar == 'P') {
                    playerRow = row;
                    playerCol = col;
                }

                if (currentChar == 'F') {
                    finishRow = row;
                    finishCol = col;
                }

                matrix[row][col] = currentChar;
            }
        }
    }
}
