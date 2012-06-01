package org.brainstorm.games.tictactoe;

/**
 * Created with IntelliJ IDEA.
 * User: Eric Douglass
 * Date: 5/26/12
 * Time: 11:49 AM
 */
public class MonteCarloAiPlayer extends AiPlayer    {

    private static final int DEPTH = 1;

    public MonteCarloAiPlayer(Type type, TicTacToeBoard board) {
        super(type, board);
    }

    @Override
    protected int[] getMove() {

        return getBestPlay();
    }

    private int[] getBestPlay() {

        double bestwins = 0;
        int[] bestspace = new int[2];

        for(int[] space : getGameBoard().listBlankSpaces()) {

            TicTacToeBoard boardcopy = getGameBoard().copyGameBoard();
            boardcopy.placeType(getType(), space[0], space[1]);

            double winpercent = calcWinPercent(boardcopy, getOppositeType(getType()), 1000);

            if(winpercent > bestwins)   {

                bestwins = winpercent;
                bestspace = space;
            }
        }

        return bestspace;
    }

    private double calcWinPercent(TicTacToeBoard board, Type typeToStart, int numberOfGames) {
        int wins = 0;
        for (int i = 0; i < numberOfGames; i++)  {
            if (playRandomGame(board, typeToStart)) {
                wins++;
            }
        }
        return (wins*1.0)/numberOfGames;
    }

    private boolean playRandomGame(TicTacToeBoard board, Type typeToStart) {
        Type typeSecond = getOppositeType(typeToStart);
        RandomAiPlayer firstAI = new RandomAiPlayer(typeToStart, board);
        RandomAiPlayer secondAI = new RandomAiPlayer(typeSecond, board);

        while (!board.isGameOver()) {
            firstAI.makeMove();
            if (!board.isGameOver()) {
                secondAI.makeMove();
            }
        }

        return board.getWinningType() == getType();
    }

    private Type getOppositeType(Type type) {
        assert type == Type.X || type == Type.O;    // TODO Perhaps a little late for this? Consider moving to constructor
        return type == Type.X ? Type.O : Type.X;
    }
}
