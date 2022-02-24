package Exams.Exam20Feb2021;

/*
One of the mission that new agents have to complete is called BombField. Your task is to implement the mission into a simple program.
We get as input the size of the field in which our sapper moves. The field is always a square. After that we receive the
commands which represent the directions in which the sapper should move. The sapper starts from
s-position The commands will be: left/right/up/down. If the sapper reaches the side edge of the field (left, right,up
or down), it remains on his current position. The possible characters that may appear on the screen are:
    •	+ – regular position on the field.
    •	e – end of the route.
    •	B – bomb
    •	s – the place where the sapper starts
Each time when sapper finds a bomb, he deactivates it, and replace "B" with "+". Keep track of the count of the bombs.
Each time you find a bomb, you have to print the following message: "You found a bomb!". If sapper steps at the end of
the route game is over (the program stops) and you have to print the output as shown in the output section. After
executing all the commands there are only 2 possible outcomes (there are not going to be more cases):
    •	if you found all bombs – you win and the game ends
    •	if you reach the end point ("e"), you have to stop
Print the corresponding output depending on the case.

Input
    •	Field size – an integer number.
    •	Commands to move the sapper – an array of strings separated by ",".
    •	The field: some of the following characters (+, e, B, s), separated by whitespace (" ");

Output
    •	There are three types of output:
        o	If all the bombs have cleared print the following output: "Congratulations! You found all bombs!"
        o	If you reached the end, you have to stop moving and print the following line: "END! {bombs left} bombs left on the field"
        o	If there are no more commands and none of the above cases happens, you have to print the following message:
"{bombs left} bombs left on the field. Sapper position: ({row},{col})"
 */

import java.util.Scanner;

public class Bomb {
    public static char[][] matrix;

    public static int sapperRow;
    public static int sapperCol;

    public static int allBombsCount = 0;
    public static int deactivatedBombs = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());

        String[] commands = scan.nextLine().split(",");

        readMatrix(size, scan);

        boolean reachedEnd = false;

        for (String command : commands) {
            move(command);

            if (reachedEnd()) {
                reachedEnd = true;
                break;
            }

            if (reachedBomb()) {
                System.out.println("You found a bomb!");
                deactivatedBombs++;
            }

            if (allBombsCleared()) {
                break;
            }

            matrix[sapperRow][sapperCol] = '+';
        }

        if (reachedEnd) {
            System.out.println("END! " + (allBombsCount - deactivatedBombs) + " bombs left on the field");
        } else if (allBombsCleared()) {
            System.out.println("Congratulations! You found all bombs!");
        } else {
            System.out.println((allBombsCount - deactivatedBombs) + " bombs left on the field. Sapper position: (" + sapperRow + "," + sapperCol + ")");
        }
    }

    private static boolean allBombsCleared() {
        return allBombsCount == deactivatedBombs;
    }

    private static boolean reachedEnd() {
        return matrix[sapperRow][sapperCol] == 'e';
    }

    private static boolean reachedBomb() {
        return matrix[sapperRow][sapperCol] == 'B';
    }

    private static void move(String command) {
        matrix[sapperRow][sapperCol] = 's';

        switch (command) {
            case "up":
                if (sapperRow - 1 >= 0) {
                    sapperRow--;
                }
                break;
            case "down":
                if (sapperRow + 1 < matrix.length) {
                    sapperRow++;
                }
                break;
            case "left":
                if (sapperCol - 1 >= 0) {
                    sapperCol--;
                }
                break;
            case "right":
                if (sapperCol + 1 < matrix[0].length) {
                    sapperCol++;
                }
                break;
        }
    }

    private static void readMatrix(int size, Scanner scan) {
        matrix = new char[size][size];

        for (int row = 0; row < matrix.length; row++) {
            String[] elements = scan.nextLine().split("\\s+");

            for (int col = 0; col < elements.length; col++) {
                char currentChar = elements[col].charAt(0);

                if (currentChar == 's') {
                    sapperRow = row;
                    sapperCol = col;
                }

                if (currentChar == 'B') {
                    allBombsCount++;
                }

                matrix[row][col] = currentChar;
            }
        }
    }
}
