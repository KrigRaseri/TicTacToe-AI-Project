package tictactoe_ai;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public interface Player1 extends Gameplay {

    static void playerOneMove(GameBoard b, Scanner sc, boolean isAI) {
        String[][] board = b.getBoard();

        if (isAI) {
            System.out.println("Making move level \"easy\"");
            while (true) {
                int x = ThreadLocalRandom.current().nextInt(0, 2 + 1);
                int y = ThreadLocalRandom.current().nextInt(0, 2 + 1);

                if (board[x][y].equals("X") || board[x][y].equals("O")) {
                    continue;
                }

                board[x][y] = "X";
                break;
            }
        }

        else {
            while (true) {
                System.out.print("Enter the coordinates: ");
                String input = sc.nextLine();
                while (!Gameplay.checkPieceInput(input)) {
                    input = sc.nextLine();
                }

                int x = Integer.parseInt(input.substring(0, 1)) - 1;
                int y = Integer.parseInt(input.substring(2)) - 1;

                if (board[x][y].equals("X") || board[x][y].equals("O")) {
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                }

                board[x][y] = "X";
                break;
            }
        }
    }
}
