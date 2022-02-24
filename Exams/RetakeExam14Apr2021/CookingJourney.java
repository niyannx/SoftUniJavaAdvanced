package Exams.RetakeExam14Apr2021;

/*
You successfully started your cooking journey, so now you need to sell the products from your basket in the pastry shop
in order to collect your price.
You will be given an integer n for the size of the pastry shop with square shape. On the next n lines, you will receive
the rows of the pastry shop. You will be placed on a random position, marked with the letter 'S'. On random positions
there will be clients, marked with a single digit. There may also be pillars. Their count will be either 0 or 2, and they
are marked with the letter - 'P'. All the empty positions will be marked with '-'.
Each turn, you will be given commands for your movement. Move commands will be: "up", "down", "left", "right". If you
move to a client, you collect the price equal to the digit there and the client disappears. If you move to a pillar, you
move on the position of the other pillar and then both pillars disappear. If you go out of the pastry shop, you disappear
from the pastry shop, and you are out of there. You need at least 50 dollars to rent your own Pastry shop.
When you are out of the pastry shop, or you collect enough money, the program ends.

Input
•	On the first line, you are given the integer n – the size of the square matrix.
•	The next n lines holds the values for every row.
•	On each of the next lines you will get a move command.

Output
•	On the first line:
    o	If the player goes to the void, print: "Bad news! You are out of the pastry shop."
    o	If the player collects enough star power, print: "Good news! You succeeded in collecting enough money!"
•	On the second line print all star power collected: "Money: {money}"
•	In the end print the matrix.

Constraints
•	The size of the square matrix will be between [2…10].
•	There will always be 0 or 2 pillars, marked with the letter - 'P'.
•	Your position will be marked with 'S'.
•	You will always go out of the pastry shop or collect enough money.

 */

import java.util.Scanner;
import java.util.regex.Pattern;

public class CookingJourney {
    public static char[][] matrix;

    public static int playerRow = 0;
    public static int playerCol = 0;

    public static int collectedMoney = 0;

    public static boolean pillarsExist = false;
    public static boolean disappeared = false;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());
        readMatrix(size, scan);

        String command = scan.nextLine();

        while (true) {
            matrix[playerRow][playerCol] = '-';

            move(command);

            if (disappeared) {
                System.out.println("Bad news! You are out of the pastry shop.");
                break;
            }

            if (reachedClient()) {
                collectedMoney += Integer.parseInt(String.valueOf(matrix[playerRow][playerCol]));
            }

            if (pillarsExist) {
                if (reachedPillar()) {
                    int firstPillarRow = playerRow;
                    int firstPillarCol = playerCol;

                    matrix[firstPillarRow][firstPillarCol] = '-';

                    int secondPillarRow = 0;
                    int secondPillarCol = 0;

                    for (int i = 0; i < matrix.length; i++) {
                        for (int j = 0; j < matrix[0].length; j++) {
                            if (matrix[i][j] == 'P' && i != firstPillarRow && j != firstPillarCol) {
                                secondPillarRow = i;
                                secondPillarCol = j;
                            }
                        }
                    }

                    playerRow = secondPillarRow;
                    playerCol = secondPillarCol;
                }
            }

            matrix[playerRow][playerCol] = 'S';

            if (collectedMoney >= 50) {
                System.out.println("Good news! You succeeded in collecting enough money!");
                break;
            }

            command = scan.nextLine();
        }

        System.out.println("Money: " + collectedMoney);
        printMatrix();
    }

    public static boolean reachedPillar() {
        return matrix[playerRow][playerCol] == 'P';
    }

    public static boolean reachedClient() {
        return Pattern.matches("[0-9]", String.valueOf(matrix[playerRow][playerCol]));
    }

    private static void move(String command) {
        switch (command) {
            case "up":
                if (playerRow - 1 >= 0) {
                    playerRow--;
                } else {
                    disappeared = true;
                }
                break;
            case "down":
                if (playerRow + 1 < matrix.length) {
                    playerRow++;
                } else {
                    disappeared = true;
                }
                break;
            case "left":
                if (playerCol - 1 >= 0) {
                    playerCol--;
                } else {
                    disappeared = true;
                }
                break;
            case "right":
                if (playerCol + 1 < matrix[0].length) {
                    playerCol++;
                } else {
                    disappeared = true;
                }
                break;
        }
    }

    private static void readMatrix(int size, Scanner scan) {
        matrix = new char[size][size];

        for (int row = 0; row < matrix.length; row++) {
            String[] elements = scan.nextLine().split("");

            for (int col = 0; col < elements.length; col++) {
                char currentChar = elements[col].charAt(0);

                if (currentChar == 'S') {
                    playerRow = row;
                    playerCol = col;
                }

                if (currentChar == 'P') {
                    pillarsExist = true;
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
