package tictactoe_ai;

import java.util.Scanner;

public interface Util {

    static void menu() {
        try (Scanner sc = new Scanner(System.in)) {
            GameBoard b = new GameBoard(new String[3][3]);
            while (true) {
                System.out.print("Input command: ");
                String input = sc.nextLine();
                switch (input.toLowerCase()) {
                    case "start user user":
                        playGame(sc, b, "user", "user");
                        break;

                    case "start user easy":
                        playGame(sc, b, "user", "easy");
                        break;

                    case "start easy user":
                        playGame(sc, b, "easy", "user");
                        break;

                    case "start easy easy":
                        playGame(sc, b, "easy", "easy");
                        break;

                    case "exit":
                        break;

                    default:
                        System.out.println("Bad parameters!");
                        continue;
                }
                break;
            }
        }
    }

    private static void playGame(Scanner sc, GameBoard b, String modeX, String modeO) {
        b.fillBoard(b);
        b.printBoard(b);

        boolean p1 = modeX.equals("user") ? false : true;
        boolean p2 = modeO.equals("user") ? false : true;
        while(true) {

            Player1.playerOneMove(b, sc, p1);
            b.printBoard(b);
            if (Gameplay.gameOver(b)) {break;}


            Player2.playerTwoMove(b, sc, p2);
            b.printBoard(b);
            if (Gameplay.gameOver(b)) {break;}
        }
    }
}
