package org.brainstorm.games.tictactoe;

import org.junit.Before;

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
