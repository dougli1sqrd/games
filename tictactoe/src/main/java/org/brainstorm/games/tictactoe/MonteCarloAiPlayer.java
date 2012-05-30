package org.brainstorm.games.tictactoe;

/**
 * Created with IntelliJ IDEA.
 * User: Eric Douglass
 * Date: 5/26/12
 * Time: 11:49 AM
 */
public class MonteCarloAiPlayer extends AiPlayer    {

    private static final int DEPTH = 1;

    public MonteCarloAiPlayer(char type, TicTacToeBoard board) {
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
            boardcopy.placeTypeOf(getPlayerType(), space[0], space[1]);

            double winpercent = calcWinPercent(boardcopy, getOppositeType(getPlayerType()), 1000);

            if(winpercent > bestwins)   {

                bestwins = winpercent;
                bestspace = space;
            }
        }

        return bestspace;
    }

    private double calcWinPercent(TicTacToeBoard board, char typetostart, int numberOfGames)   {

        int wins = 0;

        for(int i=0; i<numberOfGames; i++)  {

            if(playRandomGame(board, typetostart))  {

                wins++;
            }
        }
        return (wins*1.0)/numberOfGames;
    }

    private boolean playRandomGame(TicTacToeBoard board, char typetostart)   {

        char typesecond = getOppositeType(typetostart);
        RandomAiPlayer aifirst = new RandomAiPlayer(typetostart, board);
        RandomAiPlayer aisecond = new RandomAiPlayer(typesecond, board);

        while(!board.isGameOver())  {

            aifirst.makeMove();

            if(!board.isGameOver()) {

                aisecond.makeMove();
            }
        }

        return board.getWinningType() == getPlayerType();
    }

    private char getOppositeType(char type) {

        assert (type==TicTacToeBoard.X) || (type==TicTacToeBoard.O);

        return type==TicTacToeBoard.X ? TicTacToeBoard.O : TicTacToeBoard.X;
    }
}
