package edouglass.game.tictactoe.test;

import edouglass.game.tictactoe.HumanPlayer;
import edouglass.game.tictactoe.TicTacToeBoard;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Eric Douglass
 * Date: 5/26/12
 * Time: 12:52 AM
 */
public class HumanPlayerTest {

    private HumanPlayer human;

    private TicTacToeBoard board;

    @Before
    public void setup() {

        board = new TicTacToeBoard();
        human = new HumanPlayer(TicTacToeBoard.X, board);
    }

}
