package tictactoe_ai;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public interface AI_Logic {

    /**
     * Easy mode AI, just places X or O randomly.
     *
     * @param board is the game board.
     * @param xo represents either X or O
     * */
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

    static void hard(GameBoard b, String[][] board, String xo) {
        System.out.println("Making move level \"hard\"");
        String[][] boardCopy = b.getBoardCopy(b.getBoard());
        int[] move = makeBestMove(boardCopy, xo);
        System.out.println(Arrays.toString(move));
        board[move[0]][move[1]] = xo;

    }


    //Finds the best move using miniMax method.
    private static int[] makeBestMove(String[][] boardCopy, String xo) {
        int bestVal = Integer.MIN_VALUE;
        int[] best = {};

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (boardCopy[i][j].equals(" ")) {

                    boardCopy[i][j] = xo;
                    int moveVal = miniMax(boardCopy, 0, xo, false);
                    boardCopy[i][j] = " ";

                    if (moveVal > bestVal) {

                        best = new int[]{i, j};
                        bestVal = moveVal;
                    }
                }
            }
        }
        return best;
    }

    /**
     * Method to find the best outcomes using tree recursion. I'm also bleeding from the ears from this please help.
     *
     * @param depth represents the depth in the tree.
     * @param isMax represents if it calculates for the max, or the min.
     * */
    private static int miniMax(String[][] boardCopy, int depth, String xo, boolean isMax) {
        //Base case, returns when a win or draw is detected.
        String oppSymbol = xo.equals("X") ? "O" : "X";
        int score = checkWin(boardCopy, xo);
        if (score == 10) {
            return score;
        }

        if (score == -10) {
            return score;
        }

        if(Gameplay.isDraw(boardCopy)) {
            return 0;
        }

        //Calculates best moves for current AI.
        if (isMax) {
            int bestMoveMax = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (boardCopy[i][j].equals(" ")) {
                        boardCopy[i][j] = xo;
                        bestMoveMax = Math.max(bestMoveMax, miniMax(boardCopy, depth + 1, xo, false));
                        boardCopy[i][j] = " ";
                    }
                }
            }
            return bestMoveMax;
        }

        //Calculates best move for opponent.
        else {
            int bestMoveMin = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (boardCopy[i][j].equals(" ")) {
                        boardCopy[i][j] = oppSymbol;
                        bestMoveMin = Math.min(bestMoveMin, miniMax(boardCopy, depth + 1, xo, true));
                        boardCopy[i][j] = " ";
                    }
                }
            }
            return bestMoveMin;
        }
    }

    //Checks current board for win and returns 10 if xo wins, or -10 if the opposite symbol wins.
    private static int checkWin(String[][] board, String xo) {
        String oppSymbol = xo.equals("X") ? "O" : "X";
        if (Gameplay.gameOver(board).equals(xo)) {
            return 10;
        }

        if (Gameplay.gameOver(board).equals(oppSymbol)) {
            return -10;
        }
        return 0;
    }

    //Determines if either x or o can win, then returns int[] of coordinates.
    private static int[] canWin(GameBoard b, String xo) {
        String[][] boardCopy = b.getBoardCopy(b.getBoard());
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (boardCopy[i][j].equals("X") || boardCopy[i][j].equals("O")) {
                    continue;
                }

                boardCopy[i][j] = xo;
                if (Gameplay.gameOver(boardCopy).equals(xo)) {
                    return new int[]{i, j};
                }
                boardCopy[i][j] = " ";
            }
        }
        return null;
    }
}
