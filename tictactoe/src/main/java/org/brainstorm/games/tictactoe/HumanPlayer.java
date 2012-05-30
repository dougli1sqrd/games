package org.brainstorm.games.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Eric Douglass
 * Date: 5/26/12
 * Time: 12:38 AM
 */
public class HumanPlayer extends Player {

    public HumanPlayer(char type, TicTacToeBoard board) {
        super(type, board);
    }

    @Override
    protected int[] getMove() {

        int[] move;

        do {
            String[] userResponse = getUserMove().split(",");
            move = new int[2];

            move[0] = Integer.valueOf(userResponse[0]) - 1;
            move[1] = Integer.valueOf(userResponse[1]) - 1;
        } while (!validateUserChoice(move));

        return move;
    }

    private boolean validateUserChoice(int[] moveChoice)    {

        List<int[]> emptySpaces = getGameBoard().listBlankSpaces();
        for(int[] space : emptySpaces)  {

            if((moveChoice[0] == space[0]) && (moveChoice[1] == space[1]))   {

                return true;
            }
        }

        return false;
    }

    /**
     * Get's input from the user.  Should enter in the form of [col],[row].  People start counting at 1, so everything
     * should be subtracted by 1.
     * @return
     */
    private String getUserMove()    {

        System.out.println("Enter move coordinates ([COL],[ROW]):");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String typedInput = "";

        try {
            typedInput = br.readLine();
        } catch (IOException e) {

            System.err.println("There was a problem reading from standard input: "+e.getMessage());

        } finally {

            //closeTheInputStream(br);
        }

        return typedInput;
    }

    private void closeTheInputStream(BufferedReader reader) {

        try {
            reader.close();
        } catch (IOException e) {

            System.err.println("There was a problem closing the BufferedReader object: "+e.getMessage());
            e.printStackTrace();
        }
    }

}
