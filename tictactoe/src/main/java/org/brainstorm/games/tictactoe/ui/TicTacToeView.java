package org.brainstorm.games.tictactoe.ui;

import org.brainstorm.games.tictactoe.TicTacToeBoard;

/**
 * Date: 6/1/12
 * Time: 12:19 AM
 *
 * @author Nate Wolfe
 */
public interface TicTacToeView {

    void showBoard(TicTacToeBoard board);

    void showMessage(String message);
}
