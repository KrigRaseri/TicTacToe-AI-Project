package tictactoe_ai;

import java.util.ArrayList;
import java.util.Arrays;

public interface Gameplay {

    //Checks the input for validity.
    static boolean checkPieceInput(String input) {
        try {
        int x = Integer.parseInt(input.substring(0, 1));
        int y = Integer.parseInt(input.substring(2));

        if (x < 1 || x > 3 || y < 1 || y > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        }

        } catch (NumberFormatException e) {
            System.out.println("You should enter numbers!");
            return false;
        }
        return true;
    }

    //Win conditions
    static String gameOver(String[][] board) {
        ArrayList<String> li = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            li.addAll(Arrays.asList(board[i]).subList(0, 3));
        }

        if (xWins(li)) {
            return "X";
        }

        if (oWins(li)) {
            return "O";
        }
        return " ";
    }

    static boolean isDraw(String[][] board) {
        ArrayList<String> li = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            li.addAll(Arrays.asList(board[i]).subList(0, 3));
        }

        if (li.contains(" ")) {
            return false;
        }
        return true;
    }

    private static boolean xWins(ArrayList<String> li) {
        return xWinsHor(li) || xWinsVert(li) || xWinsDiag(li);
    }

    private static boolean oWins(ArrayList<String> li) {
        return oWinsHor(li) || oWinsVert(li) || oWinsDiag(li);
    }
    

    private static boolean xWinsHor(ArrayList<String> arr) {
        if (arr.get(0).equals("X") && arr.get(1).equals("X") && arr.get(2).equals("X")) {
            return true;
        } else if (arr.get(3).equals("X") && arr.get(4).equals("X") && arr.get(5).equals("X")) {
            return true;
        } else return arr.get(6).equals("X") && arr.get(7).equals("X") && arr.get(8).equals("X");
    }

    private static boolean xWinsVert(ArrayList<String> arr) {
        if (arr.get(0).equals("X") && arr.get(3).equals("X") && arr.get(6).equals("X")) {
            return true;
        } else if (arr.get(1).equals("X") && arr.get(4).equals("X") && arr.get(7).equals("X")) {
            return true;
        } else return arr.get(2).equals("X") && arr.get(5).equals("X") && arr.get(8).equals("X");
    }

    private static boolean xWinsDiag(ArrayList<String> arr) {
        if (arr.get(0).equals("X") && arr.get(4).equals("X") && arr.get(8).equals("X")) {
            return true;
        } else return arr.get(2).equals("X") && arr.get(4).equals("X") && arr.get(6).equals("X");
    }


    private static boolean oWinsHor(ArrayList<String> arr) {
        if (arr.get(0).equals("O") && arr.get(1).equals("O") && arr.get(2).equals("O")) {
            return true;
        } else if (arr.get(3).equals("O") && arr.get(4).equals("O") && arr.get(5).equals("O")) {
            return true;
        } else return arr.get(6).equals("O") && arr.get(7).equals("O") && arr.get(8).equals("O");
    }

    private static boolean oWinsVert(ArrayList<String> arr) {
        if (arr.get(0).equals("O") && arr.get(3).equals("O") && arr.get(6).equals("O")) {
            return true;
        } else if (arr.get(1).equals("O") && arr.get(4).equals("O") && arr.get(7).equals("O")) {
            return true;
        } else return arr.get(2).equals("O") && arr.get(5).equals("O") && arr.get(8).equals("O");
    }

    private static boolean oWinsDiag(ArrayList<String> arr) {
        if (arr.get(0).equals("O") && arr.get(4).equals("O") && arr.get(8).equals("O")) {
            return true;
        } else return arr.get(2).equals("O") && arr.get(4).equals("O") && arr.get(6).equals("O");
    }
}
