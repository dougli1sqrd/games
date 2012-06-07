package org.brainstorm.games.tictactoe;


import org.brainstorm.games.tictactoe.ui.TicTacToeView;

/**
 * Created with IntelliJ IDEA.
 * User: Eric Douglass
 * Date: 5/26/12
 * Time: 12:39 AM
 */
public class TicTacToeGame {

    private final TicTacToeBoard board;

    private final TicTacToeView view;

    private final Player playerX;

    private final Player playerO;

    public TicTacToeGame(TicTacToeBoard board, TicTacToeView view, Player playerX, Player playerO) {
        this.board = board;
        this.view = view;
        this.playerX = playerX;
        this.playerO = playerO;
    }

    public void play() {
        view.showBoard(board);
        while (!board.isGameOver()) {
            playerX.makeMove();
            view.showBoard(board);
            if (!board.isGameOver()) {
                playerO.makeMove();
                view.showBoard(board);
            }
        }
        view.showBoard(board);

        if (board.isXWinning()) {
            view.showGameOverMessage(Type.X, "X won!");
        } else if (board.isOWinning()) {
            view.showGameOverMessage(Type.O, "O won!");
        } else {
            view.showGameOverMessage(Type.CAT, "Cat game");
        }
    }

    public void reset() {
        board.reset();
    }
}
