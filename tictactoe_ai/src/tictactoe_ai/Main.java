package tictactoe_ai;

/**
 * Tic-Tac-Toe with a setting of either user to play manually, or either easy/medium/hard to chose AI. Easy chooses
 * randomly. Medium chooses place to win if it can, if not it will block other player from winning, if not then play
 * a random spot. Hard chooses the best spots to go
 *
 * Format input with the first parameter as start then user (to play manually), or ai difficulty (easy, medium, hard).
 * Or type exit to finish program.
 *
 * start user medium | start hard user | start user user | exit
 *
 * @author Krig Raseri (Pen name)
 * */

public class Main {
    public static void main(String[] args) {
        Util.menu();
    }
}