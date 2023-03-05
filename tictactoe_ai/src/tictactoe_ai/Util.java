package tictactoe_ai;

import java.util.Scanner;

public interface Util {
    static void playGame() {
        try (Scanner sc = new Scanner(System.in)) {
            GameBoard b = new GameBoard(new String[3][3]);
            b.fillBoardFromInput(b, sc);
            b.printBoard(b);

            //while(true) {
                Gameplay.placePiece(b, "X", sc);
                b.printBoard(b);
                Gameplay.gameOver(b);


                //Gameplay.placePiece(b, "O", sc);
                //b.printBoard(b);

            //}
        }
    }
}
