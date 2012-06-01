package org.brainstorm.games.tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Eric Douglass
 * Date: 5/24/12
 * Time: 10:59 PM
 */
public class TicTacToeBoard {

    private static final int SIZE = 3;

    private final Type[][] grid = new Type[SIZE][SIZE];

    private Type currentPlayerType;

    public TicTacToeBoard() {
        for (int i = 0; i < SIZE; ++i)
            Arrays.fill(grid[i], Type.BLANK);
    }

    public Type getTypeAt(int x, int y) {
        return grid[x][y];
    }

    public void placeType(Type type, int x, int y) {
        grid[x][y] = type;
    }

    public void placeX(int x, int y) {
        grid[x][y] = Type.X;
    }

    public void placeO(int x, int y) {
        grid[x][y] = Type.O;
    }

    public List<int[]> listBlankSpaces() {
        List<int[]> blankSpaces = new ArrayList<int[]>();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isSpaceBlank(i, j)) {
                    blankSpaces.add(new int[] {i, j});
                }
            }
        }
        return blankSpaces;
    }

    public boolean isXWinning() {
        return isTypeWinning(Type.X);
    }

    public boolean isOWinning() {
        return isTypeWinning(Type.O);
    }

    public boolean isTypeWinning(Type type) {
        return isDiagonalDownRightWinning(type) || isDiagonalUpRightWinning(type) ||
                isHorizontalWinning(type) || isVerticalWinning(type);
    }

    /**
     * This method will tell if the game has reached an end condition: either X or O won the game, or it's a cat game
     * @return true if the game has reached an end condition, false if not.
     */
    public boolean isGameOver() {
        return isXWinning() || isOWinning() || (listBlankSpaces().size() == 0);
    }

    public Type getWinningType() {
        if (!isGameOver())    {
            return Type.UNKNOWN;
        } else {
            if (isXWinning())    {
                return Type.X;
            } else if(isOWinning()) {
                return Type.O;
            } else  {
                return Type.CAT;
            }
        }
    }

    public Type getCurrentPlayerType() {
        return currentPlayerType;
    }

    public void setCurrentPlayerType(Type currentPlayerType) {
        this.currentPlayerType = currentPlayerType;
    }

    private boolean isHorizontalWinning(Type type) {
        for (int y = 0; y < SIZE; y++) {
            if (isRowWinning(type, y)) {
                return true;
            }
        }
        return false;
    }

    private boolean isVerticalWinning(Type type) {
        for (int x = 0; x < SIZE; x++) {
            if (isColumnWinning(type, x)) {
                return true;
            }
        }
        return false;
    }

    private boolean isColumnWinning(Type type, int col) {
        for (int row = 0; row < SIZE; ++row) {
            if (grid[col][row] != type) {
                return false;
            }
        }
        return true;
    }

    private boolean isRowWinning(Type type, int row) {
        for (int col = 0; col < SIZE; ++col) {
            if (grid[col][row] != type) {
                return false;
            }
        }
        return true;
    }

    private boolean isDiagonalDownRightWinning(Type type) {
        for (int i = 0; i < SIZE; ++i) {
            if (grid[i][i] != type) {
                return false;
            }
        }
        return true;
    }

    private boolean isDiagonalUpRightWinning(Type type) {
        for (int i = 0; i < SIZE; ++i) {
            if (grid[i][SIZE - i - 1] != type) {
                return false;
            }
        }
        return true;
    }

    private boolean isSpaceBlank(int x, int y) {
        return grid[x][y] == Type.BLANK;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        for (int j = 0; j < SIZE; j++) {
            for (int i=0; i<SIZE; i++) {
                if (i < SIZE - 1) {
                    out.append(grid[i][j]);
                    out.append('|');
                } else {
                    out.append(grid[i][j]);
                    out.append('\n');
                }
            }
        }

        String state = out.toString();
        return state;
    }

    public TicTacToeBoard copyGameBoard() {
        TicTacToeBoard copiedboard = new TicTacToeBoard();

        for(int i=0; i<SIZE; i++)   {
            for(int j=0; j<SIZE; j++)   {

                Type thisboardtype = grid[i][j];
                copiedboard.placeType(thisboardtype, i, j); //TODO how am I allowed to do this, if placeType() is private
            }
        }

        return copiedboard;
    }
}
