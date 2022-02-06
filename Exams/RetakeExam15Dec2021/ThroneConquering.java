package Exams.RetakeExam15Dec2021;

/*
Paris has entered Sparta, and he has to fight in order to abduct the wife of Menelaus, Helen.

After Paris got into Sparta, he has to fight his way to Helen’s chamber. In order to do that, he has to walk through the
city where dangerous enemies are watching out for threats, but he also has to be careful not to get exhausted and not
be able to proceed with his mission. If Paris successfully reaches to her chamber, they safely escape from the Spartans.

A standard field of Sparta looks like this:
   Field of Sparta	     |              Legend
    ------H---           |  P  Paris, the player character
    -------S--           |  S  Spartan, enemy
    --S-------           |  H  Helen
    ----------           |  -  Empty space
    -----P----	         |



Each turn proceeds as follows:
    •	First, Spartan spawns on the given indices.
    •	Then, Paris moves in a direction, which decreases his energy by 1.
        o	It can be "up", "down", "left", "right".
        o	If Paris tries to move outside the field, he doesn't move but still has his energy decreased.
    •	If an enemy is on the same cell where Paris moves, Paris fights him, which decreases his energy by 2. If Paris’
    energy drops at 0 or below, he dies, and you should mark his position with ‘X’.
    •	If Paris kills the enemy successfully, the enemy disappears.
    •	If Paris reaches the index where Helen is, they both run away (disappear from the field), even if his energy is 0 or below.

Input
    •	On the first line of input, you will receive e – the energy Paris has.
    •	On the second line of input, you will receive n – the number of rows the field of Sparta will consist of range: [5-20].
    •	On the next n lines, you will receive how each row looks.
    •	Then, until Paris dies, or reaches Helen, you will receive a move command and spawn row and column.
Output
    •	If Paris is runs out of energy, print "Paris died at {row};{col}.".
    •	If Helen is abducted, print "Paris has successfully abducted Helen! Energy left: {energy}".
    •	Then, in all cases, print the final state of the field on the console.
Constraints
    •	The field will always be rectangular.
    •	Paris will always run out of energy or reach Helen.
    •	There will be no case with spawn on invalid indices.
    •	There will be no case with two enemies on the same cell.
    •	There will be no case with enemy spawning on the indices where Paris is.
    •	There will be no case with enemy spawning on the indices where Helen is.

 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ThroneConquering {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Integer> parisEnergy = new HashMap<>();

        int energy = Integer.parseInt(scan.nextLine());

        parisEnergy.put("Paris", energy);

        int sizeOfMatrix = Integer.parseInt(scan.nextLine());

        char[][] matrix = new char[sizeOfMatrix][sizeOfMatrix];

        //read matrix
        for (int row = 0; row < sizeOfMatrix; row++) {
            char[] rowData = Arrays.stream(scan.nextLine()
                    .chars()
                    .mapToObj(ch -> (char)ch)
                    .toArray(Character[]::new))
                    .map(Object::toString)
                    .collect(Collectors.joining())
                    .toCharArray();

            matrix[row] = rowData;
        }

        int rowHelen = 0;
        int colHelen = 0;

        int rowParis = 0;
        int colParis = 0;

        // loop rows
        for (int i = 0; i < matrix.length; i++) {
            // loop cols
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 'H') {
                    rowHelen = i;
                    colHelen = j;
                }

                if (matrix[i][j] == 'P') {
                    rowParis = i;
                    colParis = j;
                }
            }
        }


        while (!died(parisEnergy) || !successfullyAbducted(rowParis, colParis, rowHelen, colHelen)) {
            String[] input = scan.nextLine().split("\\s+");

            String directionParisMoves = input[0];
            int rowEnemySpawns = Integer.parseInt(input[1]);
            int colEnemySpawns = Integer.parseInt(input[2]);

            matrix[rowEnemySpawns][colEnemySpawns] = 'S';
            matrix[rowParis][colParis] = '-';

            switch (directionParisMoves) {
                case "up":
                    if (rowParis - 1 >= 0) {
                        rowParis--;
                    }
                    break;
                case "down":
                    if (rowParis + 1 < sizeOfMatrix) {
                        rowParis++;
                    }
                    break;
                case "left":
                    if (colParis - 1 < sizeOfMatrix && colParis - 1 >= 0) {
                        colParis--;
                    }
                    break;
                case "right":
                    if (colParis + 1 < sizeOfMatrix) {
                        colParis++;
                    }
                    break;
            }

            // decrease his energy for moving
            decreaseEnergy(parisEnergy, 1);

            if (died(parisEnergy)) {
                System.out.printf("Paris died at %d;%d.\n", rowParis, colParis);
                matrix[rowParis][colParis] = 'X';
                break;
            }

            // check if he's on the same cell as an enemy
            if (matrix[rowParis][colParis] == 'S') {
                decreaseEnergy(parisEnergy, 2);

                if (died(parisEnergy)) {
                    System.out.printf("Paris died at %d;%d.\n", rowParis, colParis);
                    matrix[rowParis][colParis] = 'X';
                    break;
                }
            }

            if (successfullyAbducted(rowParis, colParis, rowHelen, colHelen)) {
                System.out.println("Paris has successfully abducted Helen! Energy left: " + parisEnergy.get("Paris"));
                matrix[rowHelen][colHelen] = '-';
                break;
            }

            matrix[rowParis][colParis] = 'P';
        }

        printMatrix(matrix);
    }

    public static void printMatrix(char[][] matrix) {
        // rows
        for (int i = 0; i < matrix.length; i++) {
            // cols
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%c", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void decreaseEnergy(Map<String, Integer> parisEnergy, int points) {
        parisEnergy.put("Paris", parisEnergy.get("Paris") - points);
    }

    public static boolean died(Map<String, Integer> parisEnergy) {
        return parisEnergy.get("Paris") <= 0;
    }

    public static boolean successfullyAbducted(int rowParis, int colParis, int rowHelen, int colHelen) {
        return rowParis == rowHelen && colParis == colHelen;
    }
}
