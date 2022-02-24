package Exams.RetakeExam16Dec2020;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Selling {
    public static char[][] matrix;

    public static int playerRow = 0;
    public static int playerCol = 0;

    public static boolean disappeared = false;
    public static boolean pillarsExist = false;

    public static int moneyCollected = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());
        readMatrix(size, scan);

        while (!disappeared) {
            matrix[playerRow][playerCol] = '-';

            String command = scan.nextLine();
            move(command);

            if (reachedClient()) {
                moneyCollected += Integer.parseInt(String.valueOf(matrix[playerRow][playerCol]));
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
                            if (matrix[i][j] == 'O' && i != firstPillarRow && j != firstPillarCol) {
                                secondPillarRow = i;
                                secondPillarCol = j;
                            }
                        }
                    }

                    playerRow = secondPillarRow;
                    playerCol = secondPillarCol;
                }
            }

            if (!disappeared) {
                matrix[playerRow][playerCol] = 'S';
            } else {
                matrix[playerRow][playerCol] = '-';
            }

            if (moneyCollected >= 50) {
                break;
            }
        }

        printOutput();
    }

    private static void printOutput() {
        if (moneyCollected >= 50) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        } else {
            System.out.println("Bad news, you are out of the bakery.");
        }

        System.out.println("Money: " + moneyCollected);

        printMatrix();
    }

    public static boolean reachedPillar() {
        return matrix[playerRow][playerCol] == 'O';
    }

    public static boolean reachedClient() {
        return Pattern.matches("[0-9]", String.valueOf(matrix[playerRow][playerCol]));
    }

    private static void printMatrix() {
        for (char[] row : matrix) {
            for (char col : row) {
                System.out.print(col);
            }

            System.out.println();
        }
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

                if (currentChar == 'O') {
                    pillarsExist = true;
                }

                matrix[row][col] = currentChar;
            }
        }
    }
}
