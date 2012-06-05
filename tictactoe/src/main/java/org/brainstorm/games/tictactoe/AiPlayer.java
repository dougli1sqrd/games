package org.brainstorm.games.tictactoe;

/**
 * Created with IntelliJ IDEA.
 * User: Eric Douglass
 * Date: 5/26/12
 * Time: 2:04 AM
 */
public abstract class AIPlayer extends AbstractPlayer {

    public AIPlayer(Type type, TicTacToeBoard board) {
        super(type, board);
    }
}
