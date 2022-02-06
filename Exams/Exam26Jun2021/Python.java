package Exams.Exam26Jun2021;

/*
One of the candidates-intern must solve the task - "Python". He must write a Java code that calculates whether the python wins or loses the game.
Here are the rules of the game:

The game starts with a python length of 1.
We get as input the size of the screen in which our python moves. The screen is always a square. After that we receive
the commands which represent the directions in which the python should move.The python starts from s-position.
The commands will be: left/right/up/down. If the python reaches the side edge of the screen (left or right), it goes
to the opposite side of the same row. If the python reaches the top/bottom edge of the screen it goes on the opposite
side of the same column . The possible characters that may appear on the screen are:
    •	* – empty space
    •	e – represents an enemy.
    •	f – this is the food
    •	s - the place where the game starts

Each time you eat a piece of food your length increases by one. Keep track of the length, because in case you win you
have to print it. If you step on an enemy the game is over (the python stops moving) and you have to print the output
as shown in the output section. After executing all the commands there are 3 possible outcomes:
    •	you have eaten all the food, and you win
    •	you get killed by an enemy
    •	there is still some food to be eaten
Print the corresponding output depending on the case.

Input
    •	Length of the screen side – an integer number.
    •	Commands to move the python – an array of strings separated by ",".

Output
    •	There are three types of output:
        o	If all the food is eaten print the following output: "You win! Final python length is {length}"
        o	If there are no left commands and there is still some food to be eaten: "You lose! There is still {left food} food to be eaten."
        o	If you step on the enemy the game is over, and you print "You lose! Killed by an enemy!"

Constraints
    •	The input numbers will be a 32-bit integer in the range [0 … 2 147 483 647].
    •	Allowed working time for your program: 0.1 seconds.
    •	Allowed memory: 16 MB.

 */

import java.util.Scanner;

public class Python {
    public static char[][] matrix;

    public static int snakeRow;
    public static int snakeCol;

    public static int snakeLength = 1;

    public static int foodEaten = 0;
    public static int amountOfFood = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());
        String[] commands = scan.nextLine().split(",\\s+");

        readMatrix(size, scan);

        boolean died = false;

        for (String command : commands) {
            matrix[snakeRow][snakeCol] = '*';

            move(command);

            if (reachedEnemy()) {
                died = true;
                break;
            }

            if (foodEaten == amountOfFood) {
                break;
            }

            matrix[snakeRow][snakeCol] = 's';
        }

        if (died) {
            System.out.println("You lose! Killed by an enemy!");
        } else {
            if (foodEaten == amountOfFood) {
                System.out.println("You win! Final python length is " + snakeLength);
            } else {
                System.out.println("You lose! There is still " + (amountOfFood - foodEaten) + " food to be eaten.");
            }
        }
    }

    private static boolean reachedEnemy() {
        return matrix[snakeRow][snakeCol] == 'e';
    }

    private static boolean reachedFood() {
        return matrix[snakeRow][snakeCol] == 'f';
    }

    private static void move(String command) {
        switch (command) {
            case "up":
                if (snakeRow - 1 >= 0) {
                    snakeRow--;
                } else {
                    snakeRow = matrix.length - 1;
                }
                break;
            case "down":
                if (snakeRow + 1 < matrix.length) {
                    snakeRow++;
                } else {
                    snakeRow = 0;
                }
                break;
            case "left":
                if (snakeCol - 1 >= 0) {
                    snakeCol--;
                } else {
                    snakeCol = matrix[0].length - 1;
                }
                break;
            case "right":
                if (snakeCol + 1 < matrix[0].length) {
                    snakeCol++;
                } else {
                    snakeCol = 0;
                }
                break;
        }

        if (reachedFood()) {
            snakeLength++;
            foodEaten++;
        }
    }

    private static void readMatrix(int size, Scanner scan) {
        matrix = new char[size][size];

        for (int row = 0; row < matrix.length; row++) {
            String[] elements = scan.nextLine().split(" ");

            for (int col = 0; col < elements.length; col++) {
                char currentChar = elements[col].charAt(0);

                if (currentChar == 's') {
                    snakeRow = row;
                    snakeCol = col;
                }

                if (currentChar == 'f') {
                    amountOfFood++;
                }

                matrix[row][col] = currentChar;
            }
        }
    }
}
