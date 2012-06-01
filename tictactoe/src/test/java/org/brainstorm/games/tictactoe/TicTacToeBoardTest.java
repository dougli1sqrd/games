package org.brainstorm.games.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: Eric Douglass
 * Date: 5/24/12
 * Time: 10:21 PM
 */
public class TicTacToeBoardTest {

    private TicTacToeBoard board;

    @Before
    public void setup() {

        board = new TicTacToeBoard();
    }

    @Test
    public void placeXTest()    {

        board.placeX(0, 0);
    }

    @Test
    public void getSpaceValueTest() {

        Type value = board.getTypeAt(1, 1);
    }

    @Test
    public void placeOTest()    {

        board.placeO(0, 0);
    }

    @Test
    public void verifyPlaceX()  {

        board.placeX(0, 0);

        Type value = board.getTypeAt(0, 0);

        assertEquals(Type.X, value);
    }

    @Test
    public void verifyPlaceO()  {

        board.placeO(0, 0);

        Type value = board.getTypeAt(0, 0);

        assertEquals(Type.O, value);
    }

    @Test
    public void verifyBlankSpaceTest()  {

        //start with a new board
        Type value = board.getTypeAt(1, 1);

        assertEquals(Type.BLANK, value);
    }

    @Test
    public void listBlankSpacesTest()   {

        List<int[]> blanks = board.listBlankSpaces();
    }

    @Test
    public void listAllBlankSpacesTest()   {

        List<int[]> blanks = board.listBlankSpaces();

        assertEquals(9, blanks.size());
        for(int[] space : blanks)  {

            Type spacevalue = board.getTypeAt(space[0], space[1]);
            assertEquals(Type.BLANK, spacevalue);
        }
    }

    @Test
    public void listBlankSpacesWhenNonEmpty()   {

        board.placeX(0, 0);

        List<int[]> blanks = board.listBlankSpaces();

        assertEquals(8, blanks.size());
        for(int[] space : blanks)  {

            Type spacevalue = board.getTypeAt(space[0], space[1]);
            assertEquals(Type.BLANK, spacevalue);
        }
    }

    @Test
    public void xWinningTest()  {

        assertFalse(board.isXWinning());
    }

    @Test
    public void xWinningDiagnal1Test()  {

        board.placeX(0, 0);
        board.placeX(1, 1);
        board.placeX(2, 2);

        assertTrue(board.isXWinning());
    }

    @Test
    public void xWinnningDiagnal2Test() {

        board.placeX(2, 0);
        board.placeX(1, 1);
        board.placeX(0, 2);

        assertTrue(board.isXWinning());
    }

    @Test
    public void xWinningHorizontalTest()    {

        board.placeX(0, 0);
        board.placeX(1, 0);
        board.placeX(2, 0);

        assertTrue(board.isXWinning());
    }

    @Test
    public void xWinningVerticalTest()  {

        board.placeX(2, 2);
        board.placeX(2, 1);
        board.placeX(2, 0);

        assertTrue(board.isXWinning());
    }

    @Test
    public void oWinningTest()  {

        assertFalse(board.isOWinning());
    }

    @Test
    public void oWinningDiagnal1Test()  {

        board.placeO(0, 0);
        board.placeO(1, 1);
        board.placeO(2, 2);

        assertTrue(board.isOWinning());
    }

    @Test
    public void oWinnningDiagnal2Test() {

        board.placeO(2, 0);
        board.placeO(1, 1);
        board.placeO(0, 2);

        assertTrue(board.isOWinning());
    }

    @Test
    public void oWinningHorizontalTest()    {

        board.placeO(0, 0);
        board.placeO(1, 0);
        board.placeO(2, 0);

        assertTrue(board.isOWinning());
    }

    @Test
    public void oWinningVerticalTest()  {

        board.placeO(2, 2);
        board.placeO(2, 1);
        board.placeO(2, 0);

        assertTrue(board.isOWinning());
    }

    @Test
    public void gameOverAtStartTest()   {

        assertFalse(board.isGameOver());
    }

    @Test
    public void gameOverAtWinningTest() {

        board.placeX(2, 2);
        board.placeX(2, 1);
        board.placeX(2, 0);

        assertTrue(board.isGameOver());
    }

    @Test
    public void gameOverFilledBoardTest()   {

        board.placeX(1, 0);
        board.placeX(2, 0);
        board.placeX(0, 1);
        board.placeX(1, 2);
        board.placeX(2, 2);
        for(int[] space : board.listBlankSpaces())  {

            board.placeO(space[0], space[1]);
        }

        assertTrue(board.isGameOver());
    }

    @Test
    public void toStringTest()  {

        board.placeX(1, 0);
        board.placeX(2, 0);
        board.placeX(0, 1);
        board.placeX(1, 2);
        board.placeX(2, 2);
        for(int[] space : board.listBlankSpaces())  {

            board.placeO(space[0], space[1]);
        }

        String boardstate = "O|X|X\n"+
                            "X|O|O\n"+
                            "O|X|X\n";

        assertEquals(boardstate, board.toString());
    }

    @Test
    public void getWinningTypeTest()    {

        board.placeX(0, 0);
        board.placeX(0, 1);
        board.placeX(0, 2);

        assertEquals(Type.X, board.getWinningType());
    }
}
