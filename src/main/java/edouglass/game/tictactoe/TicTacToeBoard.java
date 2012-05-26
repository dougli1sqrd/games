package edouglass.game.tictactoe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Eric Douglass
 * Date: 5/24/12
 * Time: 10:59 PM
 */
public class TicTacToeBoard {

    public static final char X = 'X';

    public static final char O = 'O';

    public static final char BLANK = ' ';

    private static final int SIZE = 3;

    private char[][] grid = new char[SIZE][SIZE];

    public TicTacToeBoard() {

        for(int i=0; i<SIZE; i++)   {

            for(int j=0; j<SIZE; j++)   {

                grid[i][j] = ' ';
            }
        }
    }

    public void placeX(int x, int y)    {

        placeTypeOf(X, x, y);
    }

    public char getValueAt(int x, int y) {

        return grid[x][y];
    }

    public void placeO(int x, int y) {

        placeTypeOf(O, x, y);
    }

    public void placeTypeOf(char type, int x, int y)   {

        grid[x][y] = type;
    }

    public List<int[]> listBlankSpaces()   {

        List<int[]> blankSpaces = new ArrayList<int[]>();

        for(int i=0; i<SIZE; i++)   {

            for(int j=0; j<SIZE; j++)   {

                if(isSpaceBlank(i, j)) {

                    blankSpaces.add(new int[] {i, j});
                }
            }
        }
        return blankSpaces;
    }

    public boolean isXWinning() {

        return isDiagnalUpRightWinning(X) || isDiagnalDownRightWinning(X) || isHorizontalWinning(X) || isVerticalWinning(X);
    }

    public boolean isOWinning() {

        return isDiagnalDownRightWinning(O) || isDiagnalUpRightWinning(O) || isHorizontalWinning(O) || isVerticalWinning(O);
    }

    /**
     * This method will tell if the game has reached an end condition: either X or O won the game, or it's a cat game
     * @return true if the game has reached an end condition, false if not.
     */
    public boolean isGameOver() {
        return isXWinning() || isOWinning() || (listBlankSpaces().size() == 0);
    }

    public char getWinningType() {

        if(!isGameOver())    {

            return '?';
        } else  {

            if(isXWinning())    {

                return TicTacToeBoard.X;
            } else if(isOWinning()) {

                return TicTacToeBoard.O;
            } else  {

                return 'C'; //For cat game.
            }
        }
    }

    private boolean isHorizontalWinning(char player)    {

        for(int y=0; y<SIZE; y++)   {

            if(isRowWinning(player, y)) {

                return true;
            }
        }

        return false;
    }

    private boolean isVerticalWinning(char player)  {

        for(int x=0; x<SIZE; x++)   {

            if(isColWinning(player, x)) {

                return true;
            }
        }

        return false;
    }

    private boolean isColWinning(char player, int col)  {

        for(int row=0; row<SIZE; row++) {

            if(grid[col][row] != player)    {

                return false;
            }
        }
        return true;
    }

    private boolean isRowWinning(char player, int row)  {

        for(int col=0; col<SIZE; col++)   {

            if(grid[col][row] != player)  {

                return false;
            }
        }

        return true;
    }

    private boolean isDiagnalDownRightWinning(char player)    {

        for(int i=0; i<SIZE; i++)   {

            if(grid[i][i] != player) {

                return false;
            }
        }
        return true;
    }

    private boolean isDiagnalUpRightWinning(char player)    {

        for(int i=0; i<SIZE; i++) {

            if(grid[i][SIZE - i - 1] != player) {

                return false;
            }
        }
        return true;
    }

    private boolean isSpaceBlank(int x, int y)  {

        return grid[x][y] == BLANK;
    }

    @Override
    public String toString()    {

        StringBuilder out = new StringBuilder();

        for(int j=0; j<SIZE; j++)   {
            for(int i=0; i<SIZE; i++)   {

                if(i < SIZE-1)  {

                    out.append(grid[i][j]);
                    out.append('|');
                } else  {

                    out.append(grid[i][j]);
                    out.append('\n');
                }
            }
        }

        String state = out.toString();
        return state;
    }

    public TicTacToeBoard copyGameBoard()   {

        TicTacToeBoard copiedboard = new TicTacToeBoard();

        for(int i=0; i<SIZE; i++)   {
            for(int j=0; j<SIZE; j++)   {

                char thisboardtype = grid[i][j];
                copiedboard.placeTypeOf(thisboardtype, i, j); //TODO how am I allowed to do this, if placeTypeOf() is private
            }
        }

        return copiedboard;
    }


}
