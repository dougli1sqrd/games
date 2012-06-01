package org.brainstorm.games.tictactoe;

/**
 * All of the types in the game
 */
public enum Type {
    X,

    O,

    BLANK {
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
    }
}
