/*
 * BoardPosition.java
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
 * Represents a position on the tic tac toe board in terms of rows (or y) 1, 2, and 3 and columns (or x) 1, 2, and 3.
 *
 * @author Nate Wolfe 
 */
public class BoardPosition {

    public final int row;

    public final int column;

    public BoardPosition(int row, int column) {
        this.row = row;
        this.column = column;
    }
}
