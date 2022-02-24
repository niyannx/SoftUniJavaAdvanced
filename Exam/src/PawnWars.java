import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PawnWars {
    public static char[][] board;

    public static int blackRow;
    public static int blackCol;

    public static int whiteRow;
    public static int whiteCol;

    // if it's odd -> white's turn, if it's even -> black's turn
    public static int iteration;

    public static boolean whiteWinsByCapture;
    public static boolean blackWinsByCapture;

    public static boolean whiteWinsByPromotion;
    public static boolean blackWinsByPromotion;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        readMatrix(scan);

        iteration = 0;

        whiteWinsByCapture = false;
        blackWinsByCapture = false;

        whiteWinsByPromotion = false;
        blackWinsByPromotion = false;

        // while they aren't diagonal and nobody's been promoted!
        while (!areDiagonal() && !promotedToQueen()) {
            iteration++;

            board[blackRow][blackCol] = '-';
            board[whiteRow][whiteCol] = '-';

            // if they aren't diagonal and no one has been promoted to queen, the game continues
            // (the one whose turn it is, moves forward)
            if (iteration % 2 == 0) {
                moveForward("black");
            } else {
                moveForward("white");
            }

            board[blackRow][blackCol] = 'b';
            board[whiteRow][whiteCol] = 'w';
        }

        // if they are diagonal, one of them wins
        if (areDiagonal()) {
            iteration++;

            // if it's black's turn -> black wins by capture
            if (iteration % 2 == 0) {
                board[whiteRow][whiteCol] = 'b';
                board[blackRow][blackCol] = '-';

                blackRow = whiteRow;
                blackCol = whiteCol;

                blackWinsByCapture = true;
            // if it's white's turn -> white wins by capture
            } else {
                board[whiteRow][whiteCol] = '-';
                board[blackRow][blackCol] = 'w';

                whiteRow = blackRow;
                whiteCol = blackCol;

                whiteWinsByCapture = true;
            }
        }

        // check who's won and how
        if (whiteWinsByCapture) {
            System.out.printf("Game over! White capture on %s.\n", getCoordinates(whiteRow, whiteCol));
        }

        if (blackWinsByCapture) {
            System.out.printf("Game over! Black capture on %s.\n", getCoordinates(blackRow, blackCol));
        }

        if (whiteWinsByPromotion) {
            System.out.printf("Game over! White pawn is promoted to a queen at %s.\n", getCoordinates(whiteRow, whiteCol));
        }

        if (blackWinsByPromotion) {
            System.out.printf("Game over! Black pawn is promoted to a queen at %s.\n", getCoordinates(blackRow, blackCol));
        }
    }

    // get the chessboard's coordinates
    private static String getCoordinates(int row, int col) {
        StringBuilder output = new StringBuilder();

        Map<Integer, Integer> rows = new HashMap<>();
        Map<Integer, String> cols = new HashMap<>();

        rows.put(0, 8);
        rows.put(1, 7);
        rows.put(2, 6);
        rows.put(3, 5);
        rows.put(4, 4);
        rows.put(5, 3);
        rows.put(6, 2);
        rows.put(7, 1);
        rows.put(8, 0);

        cols.put(0, "a");
        cols.put(1, "b");
        cols.put(2, "c");
        cols.put(3, "d");
        cols.put(4, "e");
        cols.put(5, "f");
        cols.put(6, "g");
        cols.put(7, "h");

        output.append(cols.get(col)).append(rows.get(row));

        return output.toString();
    }

    // check if promoted
    private static boolean promotedToQueen() {
        // if black's on the last row, black gets promoted to queen
        if (blackRow == 7) {
            blackWinsByPromotion = true;
            return true;
        }

        // if white's on the first row, white gets promoted to queen
        if (whiteRow == 0) {
            whiteWinsByPromotion = true;
            return true;
        }

        return false;
    }

    // check if diagonal
    private static boolean areDiagonal() {
        if (whiteRow - 1 == blackRow && whiteCol - 1 == blackCol) {
            return true;
        }

        if (whiteRow + 1 == blackRow && whiteCol - 1 == blackCol) {
            return true;
        }

        if (whiteRow - 1 == blackRow && whiteCol + 1 == blackCol) {
            return true;
        }

        if (whiteRow + 1 == blackRow && whiteCol + 1 == blackCol) {
            return true;
        }

        return false;
    }

    // move forward method
    private static void moveForward(String color) {
        if (color.equals("black")) {
            blackRow++;
        } else {
            whiteRow--;
        }
    }

    // read matrix method
    private static void readMatrix(Scanner scan) {
        board = new char[8][8];

        for (int row = 0; row < board.length; row++) {
            String[] elements = scan.nextLine().split("");

            for (int col = 0; col < elements.length; col++) {
                char currentChar = elements[col].charAt(0);

                // get pawn coordinates
                if (currentChar == 'b') {
                    blackRow = row;
                    blackCol = col;
                }

                if (currentChar == 'w') {
                    whiteRow = row;
                    whiteCol = col;
                }

                board[row][col] = currentChar;
            }
        }
    }
}
