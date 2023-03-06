package tictactoe_ai;

import java.util.concurrent.ThreadLocalRandom;

public interface AI_Logic {

    //Makes random move
    static void easy(String[][] board, String xo) {
        System.out.println("Making move level \"easy\"");
        while (true) {
            int x = ThreadLocalRandom.current().nextInt(0, 2 + 1);
            int y = ThreadLocalRandom.current().nextInt(0, 2 + 1);

            if (board[x][y].equals("X") || board[x][y].equals("O")) {
                continue;
            }

            board[x][y] =  xo;
            break;
        }
    }

    static void med(GameBoard b, String[][] board, String xo) {
        System.out.println("Making move level \"medium\"");
        String oppSymbol = xo.equals("X") ? "O" : "X";
        while (true) {

            //Check for win, if so win.
            if (canWin(b, xo) != null) {
                int[] cord = canWin(b, xo);
                assert cord != null;
                int x = cord[0];
                int y = cord[1];

                board[x][y] = xo;
            }

            //Check if opponent can win, if so block it.
            else if (canWin(b, oppSymbol) != null) {
                int[] cord = canWin(b, oppSymbol);
                assert cord != null;
                int x = cord[0];
                int y = cord[1];

                board[x][y] = xo;
            }

            //Random move
            else {
                int x = ThreadLocalRandom.current().nextInt(0, 2 + 1);
                int y = ThreadLocalRandom.current().nextInt(0, 2 + 1);

                if (board[x][y].equals("X") || board[x][y].equals("O")) {
                    continue;
                }
                board[x][y] = xo;
            }
            break;
        }
    }


    private static int[] canWin(GameBoard b, String xo) {
        String[][] boardCopy = b.getBoardCopy(b.getBoard());
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (boardCopy[i][j].equals("X") || boardCopy[i][j].equals("O")) {
                    continue;
                }

                boardCopy[i][j] = xo;
                if (Gameplay.gameOver(boardCopy)) {
                    return new int[]{i, j};
                }
                boardCopy[i][j] = " ";
            }
        }
        return null;
    }
}
