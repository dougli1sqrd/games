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

    private final JFrame window;

    private final JComponent boardComponent;

    private final JButton[][] boardButtons;

    private final TicTacToeBoard board;

    public SwingView(TicTacToeBoard board) {
        this.board = board;
        boardComponent = new JPanel(new GridLayout(3, 3));
        boardButtons = new JButton[3][3];
        initButtons();

        window = new JFrame("Tic Tac Toe");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationByPlatform(true);
        window.setSize(300, 500);
        window.setContentPane(boardComponent);
    }

    private void initButtons() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                JButton button = createButton(x, y);
                boardComponent.add(button);
                boardButtons[x][y] = button;
            }
        }
    }

    private JButton createButton(final int x, final int y) {
        final JButton button = new JButton(Type.BLANK.toString());
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                board.placeType(board.getCurrentPlayerType(), x, y);
                button.setText(board.getCurrentPlayerType().toString());
            }
        });
        return button;
    }

    @Override
    public void showBoard(TicTacToeBoard board) {
        assert this.board == board;
        window.setVisible(true);
        updateBoardButtons();
    }

    private void updateBoardButtons() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                Type type = board.getTypeAt(x, y);
                boardButtons[x][y].setText(type.toString());
            }
        }
    }

    @Override
    public void showMessage(String message) {
        // DO NOT call getBoardComponent(), there's no need to create it just to center the dialog on it
        JOptionPane.showMessageDialog(boardComponent, message, null, JOptionPane.INFORMATION_MESSAGE);
    }
}
