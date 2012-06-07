package org.brainstorm.games.tictactoe;

import org.brainstorm.games.tictactoe.ui.SwingView;

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
        BoardPosition move = view.getUserMove();
        getBoard().placeType(getType(), move.column, move.row);
    }
}
