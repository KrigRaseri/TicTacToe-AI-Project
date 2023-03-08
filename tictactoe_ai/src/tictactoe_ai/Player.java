package tictactoe_ai;

import java.util.Scanner;

interface Player {

    static void playerMove(GameBoard b, Scanner sc, String player, String xo) {
        String[][] board = b.getBoard();

        //AI options.
        if (player.equals("easy")) {
            AI_Logic.easy(board, xo);
        } else if (player.equals("medium")) {
            AI_Logic.med(b, board, xo);
        } else if (player.equals("hard")) {
            AI_Logic.hard(b, board,xo);
        }

        //User
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

                board[x][y] = xo;
                break;
            }
        }
    }
}
