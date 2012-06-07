package org.brainstorm.games.tictactoe;

import javax.swing.*;

/**
 * All of the types in the game
 */
public enum Type {

    X {
        private final ImageIcon theXImage = new ImageIcon(Type.class.getResource("/images/xx.png"));

        @Override
        public Icon getImage() {
            return theXImage;
        }
    },

    O {
        private final ImageIcon theYImage = new ImageIcon(Type.class.getResource("/images/oo.png"));

        @Override
        public Icon getImage() {
            return theYImage;
        }
    },

    BLANK {
        private final ImageIcon blankCopyOfX = new ImageIcon() {
            @Override
            public int getIconWidth() {
                return X.getImage().getIconWidth();
            }

            @Override
            public int getIconHeight() {
                return X.getImage().getIconHeight();
            }
        };

        @Override
        public Icon getImage() {
            return blankCopyOfX;
        }

        @Override
        public String toString() {
            return " ";
        }
    },

    CAT {
        // TODO Is override necessary?
        @Override
        public String toString() {
            return "C";
        }
    },

    UNKNOWN {
        // TODO Is override necessary?
        @Override
        public String toString() {
            return "?";
        }
    };

    public Icon getImage() {
        return null;
    }
}
