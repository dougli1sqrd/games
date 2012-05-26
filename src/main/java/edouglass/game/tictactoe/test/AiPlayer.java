package edouglass.game.tictactoe.test;

import edouglass.game.tictactoe.Player;
import edouglass.game.tictactoe.TicTacToeBoard;

/**
 * Created with IntelliJ IDEA.
 * User: Eric Douglass
 * Date: 5/26/12
 * Time: 2:04 AM
 */
public abstract class AiPlayer extends Player {

    public AiPlayer(char type, TicTacToeBoard board) {
        super(type, board);
    }

    @Override
    protected abstract int[] getMove();
}
