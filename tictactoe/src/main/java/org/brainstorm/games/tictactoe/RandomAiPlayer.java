package org.brainstorm.games.tictactoe;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Eric Douglass
 * Date: 5/26/12
 * Time: 2:20 AM
 */
public class RandomAIPlayer extends AIPlayer {

    public RandomAIPlayer(Type type, TicTacToeBoard board) {
        super(type, board);
    }

    @Override
    public void makeMove() {
        List<int[]> emptySpaces = getBoard().listBlankSpaces();
        int randomIndex = (int)(Math.random()*emptySpaces.size());

        int[] move = emptySpaces.get(randomIndex);
        getBoard().placeType(getType(), move[0], move[1]);
    }

}
