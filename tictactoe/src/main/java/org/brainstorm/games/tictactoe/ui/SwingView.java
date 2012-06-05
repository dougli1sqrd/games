package org.brainstorm.games.tictactoe.ui;

import org.brainstorm.games.tictactoe.TicTacToeBoard;
import org.brainstorm.games.tictactoe.Type;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Date: 6/1/12
 * Time: 12:51 AM
 *
 * @author Nate Wolfe
 */
public class SwingView implements TicTacToeView {

    private static final String ROW = "SwingView#ROW";

    private static final String COLUMN = "SwingView#COLUMN";

    private final JFrame window;

    private final JComponent boardComponent;

    private final JButton[][] boardButtons;

    private final ActionListener clickListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (userMove == null) {
                JButton button = (JButton) e.getSource();
                boolean spaceIsBlank = (button.getIcon() == Type.BLANK.getImage());
                if (spaceIsBlank) {
                    int row = (Integer) button.getClientProperty(ROW);
                    int column = (Integer) button.getClientProperty(COLUMN);
                    userMove = new TicTacToeBoard.Position(row, column);
                }
            }
        }
    };

    private volatile TicTacToeBoard.Position userMove;

    public SwingView() {
        boardComponent = new JPanel(new GridLayout(3, 3));
        boardButtons = new JButton[3][3];
        buildGridBoard();
        window = new JFrame("Tic Tac Toe");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationByPlatform(true);
        window.setContentPane(boardComponent);
        window.pack();
    }

    private void buildGridBoard() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                JButton button = new JButton(Type.BLANK.getImage());
                button.setContentAreaFilled(false);
                button.setFocusPainted(false);
                button.setMargin(new Insets(0,0,0,0));
                button.putClientProperty(ROW, Integer.valueOf(y));
                button.putClientProperty(COLUMN, Integer.valueOf(x));
                button.addActionListener(clickListener);
                boardComponent.add(button);
                boardButtons[x][y] = button;
            }
        }
    }

    TicTacToeBoard.Position getUserMove() {
        while (userMove == null) {
            // Wait for user to click on something. This variable will be
            // set from the Event Dispatch Thread by our clickListener
        }
        TicTacToeBoard.Position move = userMove;
        userMove = null;
        return move;
    }

    @Override
    public void showBoard(TicTacToeBoard board) {
        // Update button icons to match the board
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                Type type = board.getTypeAt(x, y);
                boardButtons[x][y].setIcon(type.getImage());
            }
        }
        window.setVisible(true);
    }

    @Override
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(window, message, message, JOptionPane.INFORMATION_MESSAGE);
    }
}
