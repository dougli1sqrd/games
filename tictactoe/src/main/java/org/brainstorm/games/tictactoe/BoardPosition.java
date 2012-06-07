/*
 * BoardPosition.java
 *
 * created on: 6/6/12 11:55 PM
 * Copyright(c) 2002-2012 Thetus Corporation.  All Rights Reserved.
 *                        www.thetus.com
 *
 * Use of copyright notice does not imply publication or disclosure.
 * THIS SOFTWARE CONTAINS CONFIDENTIAL AND PROPRIETARY INFORMATION CONSTITUTING VALUABLE TRADE SECRETS
 *  OF THETUS CORPORATION, AND MAY NOT BE:
 *  (a) DISCLOSED TO THIRD PARTIES;
 *  (b) COPIED IN ANY FORM;
 *  (c) USED FOR ANY PURPOSE EXCEPT AS SPECIFICALLY PERMITTED IN WRITING BY THETUS CORPORATION.
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
 * @author Nate Wolfe - nwolfe@thetus.com
 */
public class BoardPosition {

    public final int row;

    public final int column;

    public BoardPosition(int row, int column) {
        this.row = row;
        this.column = column;
    }
}
