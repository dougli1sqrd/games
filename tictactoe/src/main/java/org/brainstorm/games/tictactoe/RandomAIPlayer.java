/*
 * RandomAIPlayer.java
 *
 * created on: 6/6/12 11:04 PM
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

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Eric Douglass
 * Date: 5/26/12
 * Time: 2:20 AM
 */
public class RandomAIPlayer extends AIPlayer {

    public RandomAIPlayer(Type type, TicTacToeBoard board) {
        super(type, board);
    }

    @Override
    public void makeMove() {
        List<int[]> emptySpaces = getBoard().listBlankSpaces();
        int randomIndex = (int)(Math.random()*emptySpaces.size());

        int[] move = emptySpaces.get(randomIndex);
        getBoard().placeType(getType(), move[0], move[1]);
    }

}
