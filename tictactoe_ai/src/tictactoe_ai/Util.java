package tictactoe_ai;

import java.util.Scanner;

public interface Util {

    //Runs the menu interface.
    static void menu() {
        try (Scanner sc = new Scanner(System.in)) {
            GameBoard b = new GameBoard(new String[3][3]);
            while (true) {
                System.out.print("Input command: ");
                String[] input = sc.nextLine().toLowerCase().split(" ");

                if (input[0].equals("start") && input.length == 3) {
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

    /**
     * Starts the game with the chosen game modes.
     *
     * @param b represents a GameBoard object.
     * @param (modeX, modeY) represents the chosen game mode for X/Y. Easy/Med/Hard.
     * */
    private static void playGame(Scanner sc, GameBoard b, String modeX, String modeO) {
        b.fillBoard(b);
        b.printBoard(b);

        while(true) {

            Player.playerMove(b, sc, modeX, "X");
            b.printBoard(b);
            if (Gameplay.gameOver(b.getBoard()).equals("X")) {
                System.out.println("X wins");
                break;
            }

            if (Gameplay.isDraw(b.getBoard())) {
                System.out.println("Draw");
                break;
            }

            Player.playerMove(b, sc, modeO, "O");
            b.printBoard(b);
            if (Gameplay.gameOver(b.getBoard()).equals("O")) {
                System.out.println("O wins");
                break;
            }
        }
    }
}
