package tictactoe_ai;

import java.util.Scanner;

public interface Util {

    static void menu() {
        try (Scanner sc = new Scanner(System.in)) {
            GameBoard b = new GameBoard(new String[3][3]);
            while (true) {
                System.out.print("Input command: ");
                String[] input = sc.nextLine().toLowerCase().split(" ");

                if (input[0].equals("start")) {
                    playGame(sc, b, input[1], input[2]);
                    break;
                } else if (input[0].equals("exit")) {
                    break;
                } else {
                    System.out.println("Bad parameters!");
                }
            }
        }
    }

    private static void playGame(Scanner sc, GameBoard b, String modeX, String modeO) {
        b.fillBoard(b);
        b.printBoard(b);
        int turnCount = 0;

        while(true) {

            Player1.playerOneMove(b, sc, modeX);
            b.printBoard(b);
            if (Gameplay.gameOver(b.getBoard())) {
                System.out.println("X wins");
                break;
            }
            turnCount++;

            if (turnCount == 9) {
                System.out.println("Draw");
                break;
            }

            Player2.playerTwoMove(b, sc, modeO);
            b.printBoard(b);
            if (Gameplay.gameOver(b.getBoard())) {
                System.out.println("O wins");
                break;
            }
            turnCount++;
        }
    }
}
