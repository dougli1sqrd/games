package org.brainstorm.games.tictactoe.ui;

import org.brainstorm.games.tictactoe.TicTacToeBoard;

/**
 * Date: 6/1/12
 * Time: 12:20 AM
 *
 * @author Nate Wolfe
 */
public class SystemOutView implements TicTacToeView {
    @Override
    public void showBoard(TicTacToeBoard board) {
        System.out.println(board);
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }
}
