package tictactoe_ai;

import java.util.Scanner;

public class GameBoard {
    private String[][] board;

    //Constructor
    public GameBoard(String[][] board) {
        this.board = board;
    }

    //Getters and setters
    public String[][] getBoard() {
        return board;
    }

    public void setBoard(String[][] board) {
        this.board = board;
    }

    //Board specific methods.
    public void fillBoard(GameBoard board) {
        String[][] filledBoard = board.getBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                filledBoard[i][j] = "_";
            }
        }
        board.setBoard(filledBoard);
    }

    public void fillBoardFromInput(GameBoard board, Scanner s) {
        System.out.print("Enter the cells: ");
        String input = s.nextLine();
        while (!inputCheck(input)) {
            input = s.nextLine();
        }
        int count = 0;
        String[][] filledBoard = board.getBoard();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (input.charAt(count) == '_') {
                    filledBoard[i][j] = " ";
                    count++;
                    continue;
                }

                filledBoard[i][j] = String.valueOf(input.charAt(count));
                count++;
            }
        }
        board.setBoard(filledBoard);
    }

    public void printBoard(GameBoard board) {
        String[][] b = board.getBoard();
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    //Board setup input check methods.
    public static boolean inputCheck(String input) {
        if (input.length() != 9) {
            System.out.println("Input length incorrect.");
            return false;
        }
        return true;
    }
}
