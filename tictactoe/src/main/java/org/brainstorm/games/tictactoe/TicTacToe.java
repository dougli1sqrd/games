package org.brainstorm.games.tictactoe;

import org.brainstorm.games.tictactoe.ui.SwingPlayer;
import org.brainstorm.games.tictactoe.ui.SwingView;
import org.brainstorm.games.tictactoe.ui.SystemOutView;
import org.brainstorm.games.tictactoe.ui.TicTacToeView;

/**
 * Date: 6/3/12
 * Time: 2:52 AM
 *
 * @author Nate Wolfe
 */
public class TicTacToe {

    public static void main(String[] args) {
        newSinglePlayerSwingGame().play();
//        newSinglePlayerTextGame().play();
    }

    public static TicTacToeGame newSinglePlayerSwingGame() {
        TicTacToeBoard board = new TicTacToeBoard();
        SwingView view = new SwingView();
        Player playerX = new MonteCarloAIPlayer(Type.X, board);
        Player playerO = new SwingPlayer(Type.O, board, view);
        return new TicTacToeGame(board, view, playerX, playerO);
    }

    public static TicTacToeGame newSinglePlayerTextGame() {
        TicTacToeBoard board = new TicTacToeBoard();
        TicTacToeView view = new SystemOutView();
        Player playerX = new HumanPlayer(Type.X, board);
        Player playerO = new MonteCarloAIPlayer(Type.O, board);
        return new TicTacToeGame(board, view, playerX, playerO);
    }
}
