/*
 * MonteCarloAIPlayer.java
 *
 * Created using IntelliJ IDEA.
 * SVN status:
 *  $HeadURL: $
 *  $Id: $
 *  $Revision: $
 *  $Date: $
 *  $Author: $
 */

package org.brainstorm.games.tictactoe;

/**
 * Created with IntelliJ IDEA.
 * User: Eric Douglass
 * Date: 5/26/12
 * Time: 11:49 AM
 */
public class MonteCarloAIPlayer extends AIPlayer {

    public MonteCarloAIPlayer(Type type, TicTacToeBoard board) {
        super(type, board);
    }

    @Override
    public void makeMove() {
        double bestWins = 0;
        int[] bestSpace = new int[2];

        for(int[] space : getBoard().listBlankSpaces()) {

            TicTacToeBoard boardCopy = getBoard().copyGameBoard();
            boardCopy.placeType(getType(), space[0], space[1]);

            double winPercent = calcWinPercent(boardCopy, getOppositeType(getType()), 5000);

            if(winPercent >= bestWins)   {

                bestWins = winPercent;
                bestSpace = space;
            }
        }

        getBoard().placeType(getType(), bestSpace[0], bestSpace[1]);
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
        TicTacToeBoard boardcopy = board.copyGameBoard();
        Type typeSecond = getOppositeType(typeToStart);
        RandomAIPlayer firstAI = new RandomAIPlayer(typeToStart, boardcopy);
        RandomAIPlayer secondAI = new RandomAIPlayer(typeSecond, boardcopy);

        while (!boardcopy.isGameOver()) {
            firstAI.makeMove();
            if (!boardcopy.isGameOver()) {
                secondAI.makeMove();
            }
        }

        return boardcopy.getWinningType() == getType();
    }

    private Type getOppositeType(Type type) {
        assert type == Type.X || type == Type.O;    // TODO Perhaps a little late for this? Consider moving to constructor
        return type == Type.X ? Type.O : Type.X;
    }
}
