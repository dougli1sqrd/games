package edouglass.game.tictactoe;

/**
 * Created with IntelliJ IDEA.
 * User: Eric Douglass
 * Date: 5/26/12
 * Time: 12:31 AM
 */
public abstract class Player {

    private char playertype;

    private TicTacToeBoard gameboard;

    public Player(char type, TicTacToeBoard board)  {

        playertype = type;
        gameboard = board;
    }

    protected TicTacToeBoard getGameBoard() {

        return gameboard;
    }

    protected char getPlayerType()  {

        return playertype;
    }

    public final void makeMove()  {
        //TODO where do we enforce legal move placement?  If we enforce here, then if an illegal move is made
        //it will fail silently, doing nothing.  It could also be placed in a loop, that does not exit until
        //a legal move is made.  (A legal move is one in which there are no other placements (a blank space))

        int[] tile = getMove();
        if(playertype == TicTacToeBoard.X)  {

            gameboard.placeX(tile[0], tile[1]);
        } else if(playertype == TicTacToeBoard.O)   {

            gameboard.placeO(tile[0], tile[1]);
        }

    }

    /**
     * This method returns the coordinate pair (col, row) that this player wants to go in.  This will be called using
     * the makeMove() method.
     */
    protected abstract int[] getMove();
}
