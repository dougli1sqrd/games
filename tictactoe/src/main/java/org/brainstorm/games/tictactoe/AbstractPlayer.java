package org.brainstorm.games.tictactoe;

/**
 * Created with IntelliJ IDEA.
 * User: Eric Douglass
 * Date: 5/26/12
 * Time: 12:31 AM
 */
public abstract class AbstractPlayer implements Player {

    private final Type type;

    private final TicTacToeBoard board;

    public AbstractPlayer(Type type, TicTacToeBoard board) {
        assert Type.X == type || Type.O == type;
        this.type = type;
        this.board = board;
    }

    @Override
    public Type getType()  {
        return type;
    }

    protected TicTacToeBoard getBoard() {
        return board;
    }

//    @Override
//    public void makeMove()  {
        //TODO where do we enforce legal move placement?  If we enforce here, then if an illegal move is made
        //it will fail silently, doing nothing.  It could also be placed in a loop, that does not exit until
        //a legal move is made.  (A legal move is one in which there are no other placements (a blank space))
//        int[] tile = getMove();
//    }

    /**
     * This method returns the coordinate pair (col, row) that this player wants to go in.  This will be called using
     * the makeMove() method.
     *
     * @return Coordinate pair (col, row) of desired move (placement).
     */
//    protected abstract int[] getMove();
}
