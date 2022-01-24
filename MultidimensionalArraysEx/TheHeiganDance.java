package MultidimensionalArraysEx;

/*
At last, level 80. And what do level eighties do? Go raiding. This is where you are now – trying not to be wiped by the
famous dance boss, Heigan the Unclean. The fight is pretty straightforward - dance around the Plague Clouds and
Eruptions, and you’ll be just fine.
Heigan’s chamber is a 15-by-15 two-dimensional array. The player always starts at the exact center. For each turn,
Heigan uses a spell that hits a certain cell and the neighboring rows/columns. For example, if he hits (1,1), he also
hits (0,0, 0,1, 0,2, 1,0 … 2,2). If the player’s current position is within the area of damage, the player tries to move.
First, he tries to move up, if there’s damage/wall, he tries to move right, then down, then left. If he cannot move in
any direction, because the cell is damaged or there is a wall, the player stays in place and takes the damage.
Plague cloud does 3500 damage when it hits, and 3500 damage the next turn. Then it expires. Eruption does 6000
damage when it hits. If a spell hits a player that also has an active Plague Cloud from the previous turn, the cloud
damage is applied first. Both Heigan and the player may die in the same turn. If Heigan is dead, the spell he would
have cast is ignored.
The player always starts at 18500 hit points; Heigan starts at 3,000,000 hit points. Each turn, the player does
damage to Heigan. The fight is over either when the player is killed, or Heigan is defeated.
 */

import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        boolean[][] chamber = new boolean[15][15];

        int playerRow = 7;
        int playerCol = 7;

        double playerHealth = 18500;
        double heiganHealth = 3000000;

        String lastSpell = "";
        boolean activeCloud = false;

        double damage = Double.parseDouble(scan.nextLine());

        while (!heiganDefeated(heiganHealth) || !playerKilled(playerHealth)) {
            heiganHealth -= damage;

            if (activeCloud) {
                playerHealth -= 3500;
                activeCloud = false;

                if (playerKilled(playerHealth)) {
                    break;
                }
            }

            if (heiganDefeated(heiganHealth)) {
                break;
            }

            String[] input = scan.nextLine().split("\\s+");

            String spell = input[0];
            int row = Integer.parseInt(input[1]);
            int col = Integer.parseInt(input[2]);

            for (int i = row - 1; i <= row + 1; i++) {
                if (i >= 0 && i < chamber.length) {
                    for (int j = col - 1; j <= col + 1; j++) {
                        if (j >= 0 && j < chamber[row].length) {
                            chamber[i][j] = true;
                        }
                    }
                }
            }

            if (chamber[playerRow][playerCol]) {
                if (isRowValid(chamber, playerRow - 1) && !chamber[playerRow - 1][playerCol]) {
                    playerRow--; // move up
                } else if (isColValid(chamber, playerCol + 1) && !chamber[playerRow][playerCol + 1]) {
                    playerCol++; // move right
                } else if (isRowValid(chamber, playerRow + 1) && !chamber[playerRow + 1][playerCol]) {
                    playerRow++;
                } else if (isColValid(chamber, playerCol - 1) && !chamber[playerRow][playerCol - 1]) {
                    playerCol--;
                }

            if (chamber[playerRow][playerCol]) {
                switch (spell) {
                    case "Cloud":
                        playerHealth -= 3500;
                        activeCloud = true;
                        lastSpell = "Plague Cloud";
                        break;
                    case "Eruption":
                        playerHealth -= 6000;
                        lastSpell = spell;
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid spell: " + spell);
                }
            }
            }
        }

        if (heiganDefeated(heiganHealth)) {
            System.out.printf("Heigan: %.2f%n", heiganHealth);
        } else {
            System.out.println("Heigan: Defeated!");
        }
        if (playerKilled(playerHealth)) {
            System.out.printf("Player: %.0f%n", playerHealth);
        } else {
            System.out.println("Player: Killed by " + lastSpell);
        }

        System.out.println("Final position: " + playerRow + ", " + playerCol);

    }

    public static boolean playerKilled(double playerHealth) {
        return playerHealth <= 0;
    }

    public static boolean heiganDefeated(double heiganHealth) {
        return heiganHealth <= 0;
    }

    private static boolean isRowValid(boolean[][] chamber, int playerRow) {
        return playerRow >= 0 && playerRow < chamber[playerRow].length;
    }

    private static boolean isColValid(boolean[][] chamber, int playerCol) {
        return playerCol >= 0 && playerCol < chamber.length;
    }
}
