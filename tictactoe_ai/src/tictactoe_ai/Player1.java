package tictactoe_ai;

import java.util.Scanner;

public interface Player1 {

    static void playerOneMove(GameBoard b, Scanner sc, String player) {
        String[][] board = b.getBoard();

        if (player.equals("easy")) {
            AI_Logic.easy(board, "X");
        } else if (player.equals("medium")) {
            AI_Logic.med(b, board, "X");
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
