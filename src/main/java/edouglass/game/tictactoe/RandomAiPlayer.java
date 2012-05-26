package edouglass.game.tictactoe;

import edouglass.game.tictactoe.test.AiPlayer;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Eric Douglass
 * Date: 5/26/12
 * Time: 2:20 AM
 */
public class RandomAiPlayer extends AiPlayer {

    public RandomAiPlayer(char type, TicTacToeBoard board) {
        super(type, board);
    }

    @Override
    protected int[] getMove() {

        List<int[]> emptyspaces = getGameBoard().listBlankSpaces();
        int randomIndex = (int)(Math.random()*emptyspaces.size());

        return emptyspaces.get(randomIndex);
    }

}
