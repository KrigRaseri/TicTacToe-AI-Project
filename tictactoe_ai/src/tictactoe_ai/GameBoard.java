package tictactoe_ai;

public class GameBoard {
    //Field
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

    public String[][] getBoardCopy(String[][] board) {
        String[][] boardCopy = new String[3][3];

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; j++) {
                boardCopy[i][j] = board[i][j];
            }
        }
        return boardCopy;
    }

    //Board specific methods
    public void fillBoard(GameBoard board) {
        String[][] filledBoard = board.getBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                filledBoard[i][j] = " ";
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
}
