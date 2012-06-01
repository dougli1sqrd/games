package org.brainstorm.games.tictactoe;


/**
 * Created with IntelliJ IDEA.
 * User: Eric Douglass
 * Date: 5/26/12
 * Time: 12:39 AM
 */
public class TicTacToeGame {

    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();
        game.play();
    }

    private final TicTacToeBoard board;

    private final Player playerX;

    private final Player playerO;

    public TicTacToeGame() {
        board = new TicTacToeBoard();
        playerX = new MonteCarloAiPlayer(Type.X, board);  //TODO use Factory pattern here.  But how...?
        playerO = new MonteCarloAiPlayer(Type.O, board);
    }

    public void play() {
        while (!board.isGameOver()) {
            System.out.println(board);
            playerX.makeMove();
            if (!board.isGameOver()) {
                System.out.println(board);
                playerO.makeMove();
            }
        }

        System.out.println(board);
        if (board.isXWinning()) {
            System.out.println("X won!");
        } else if (board.isOWinning()) {
            System.out.println("O won!");
        } else {
            System.out.println("Cat game!");
        }
    }
}
