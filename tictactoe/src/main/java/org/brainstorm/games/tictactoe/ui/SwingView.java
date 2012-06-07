package org.brainstorm.games.tictactoe.ui;

import org.brainstorm.games.tictactoe.BoardPosition;
import org.brainstorm.games.tictactoe.TicTacToeBoard;
import org.brainstorm.games.tictactoe.Type;

import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Date: 6/1/12
 * Time: 12:51 AM
 *
 * @author Nate Wolfe
 */
public class SwingView implements TicTacToeView {

    static {
        try {
            // Ensure we're using the look and feel that gives us the best looking grid buttons
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    private static final String ROW = "SwingView#ROW";

    private static final String COLUMN = "SwingView#COLUMN";

    private final JFrame window;

    private final JComponent boardComponent;

    private final JButton[][] boardButtons;

    private volatile BoardPosition userMove;

    private final ActionListener clickListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (userMove == null) {
                JButton button = (JButton) e.getSource();
                boolean spaceIsBlank = (button.getIcon() == Type.BLANK.getImage());
                if (spaceIsBlank) {
                    int row = (Integer) button.getClientProperty(ROW);
                    int column = (Integer) button.getClientProperty(COLUMN);
                    userMove = new BoardPosition(row, column);
                }
            }
        }
    };

    public SwingView() {
        boardComponent = new JPanel(new GridLayout(3, 3));
        boardComponent.setOpaque(true);
        boardButtons = new JButton[3][3];
        buildGridBoard();
        window = new JFrame("Tic Tac Toe");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationByPlatform(true);
        window.setContentPane(boardComponent);
        window.pack();
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
    public void showGameOverMessage(Type winner, String message) {
        JOptionPane.showMessageDialog(window, message, message, JOptionPane.INFORMATION_MESSAGE, winner.getImage());
    }

    public BoardPosition getUserMove() {
        while (userMove == null) {
            // Wait for user to click on something. This variable will be
            // set from the Event Dispatch Thread by our clickListener
        }
        BoardPosition move = userMove;
        userMove = null;
        return move;
    }

    private void buildGridBoard() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                JButton button = createGridButton(x, y);
                boardComponent.add(button);
                boardButtons[x][y] = button;
            }
        }
    }

    private JButton createGridButton(int x, int y) {
        JButton button = new JButton(Type.BLANK.getImage());
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setMargin(new Insets(0,0,0,0));
        button.putClientProperty(ROW, y);
        button.putClientProperty(COLUMN, x);
        button.addActionListener(clickListener);
        return button;
    }
}
