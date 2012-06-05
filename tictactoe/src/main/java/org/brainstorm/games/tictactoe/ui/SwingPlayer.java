package org.brainstorm.games.tictactoe.ui;

import org.brainstorm.games.tictactoe.AbstractPlayer;
import org.brainstorm.games.tictactoe.TicTacToeBoard;
import org.brainstorm.games.tictactoe.Type;

/**
 * Date: 6/3/12
 * Time: 3:03 AM
 *
 * @author Nate Wolfe
 */
public class SwingPlayer extends AbstractPlayer {

    private final SwingView view;

    public SwingPlayer(Type type, TicTacToeBoard board, SwingView view) {
        super(type, board);
        this.view = view;
    }

    @Override
    public void makeMove() {
        TicTacToeBoard.Position move = view.getUserMove();
        assert move != null;
        getBoard().placeType(getType(), move.column, move.row);
    }
}
