package org.brainstorm.games.tictactoe.ui;

import org.brainstorm.games.tictactoe.TicTacToeBoard;
import org.brainstorm.games.tictactoe.Type;

/**
 * Date: 6/1/12
 * Time: 12:19 AM
 *
 * @author Nate Wolfe
 */
public interface TicTacToeView {

    void showBoard(TicTacToeBoard board);

    void showGameOverMessage(Type winner, String message);
}
