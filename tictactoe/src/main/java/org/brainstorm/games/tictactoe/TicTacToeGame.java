package org.brainstorm.games.tictactoe;


import org.brainstorm.games.tictactoe.ui.SwingView;
import org.brainstorm.games.tictactoe.ui.TicTacToeView;

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

    private final TicTacToeView view;

    private final Player playerX;

    private final Player playerO;

    public TicTacToeGame() {
        board = new TicTacToeBoard();
        playerX = new MonteCarloAiPlayer(Type.X, board);  //TODO use Factory pattern here.  But how...?
        playerO = new HumanPlayer(Type.O, board);
        view = new SwingView(board);
    }

    public void play() {
        while (!board.isGameOver()) {
            takeTurn(playerX);
            if (!board.isGameOver()) {
                takeTurn(playerO);
            }
        }

        view.showBoard(board);
        if (board.isXWinning()) {
            view.showMessage("X won!");
        } else if (board.isOWinning()) {
            view.showMessage("O won!");
        } else {
            view.showMessage("Cat game!");
        }
    }

    private void takeTurn(Player player) {
        board.setCurrentPlayerType(player.getType());
        view.showBoard(board);
        player.makeMove();
    }
}
