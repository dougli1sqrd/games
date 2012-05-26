package edouglass.game.tictactoe;

import edouglass.game.tictactoe.test.MonteCarloAiPlayer;

/**
 * Created with IntelliJ IDEA.
 * User: Eric Douglass
 * Date: 5/26/12
 * Time: 12:39 AM
 */
public class TicTacToeGame {

    private TicTacToeBoard board;

    private Player playerX;

    private Player playerO;

    public TicTacToeGame()  {

        board = new TicTacToeBoard();
        this.playerX = new MonteCarloAiPlayer(TicTacToeBoard.X, board);  //TODO use Factory pattern here.  But how...?
        this.playerO = new MonteCarloAiPlayer(TicTacToeBoard.O, board);
    }

    public void play()  {

        while(!board.isGameOver())   {

            System.out.println(board);
            playerX.makeMove();

            if(!board.isGameOver()) {

                System.out.println(board);
                playerO.makeMove();
            }
        }

        System.out.println(board);
        if(board.isXWinning())  {

            System.out.println("X won!");
        } else if(board.isOWinning())  {

            System.out.println("O won!");
        } else  {

            System.out.println("Cat game!");
        }
    }

    public static void main(String[] args) {

        TicTacToeGame game = new TicTacToeGame();
        game.play();
    }
}
