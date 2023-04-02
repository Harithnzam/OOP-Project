package checkers;

import javax.swing.ImageIcon;
import java.net.URL;

/**
 * Represent a white piece, which means that the piece moves upwards.
 */
public class WhiteChecker extends CheckerPosition {

    public WhiteChecker(Coordinate c) {
        checkerState = new NormalStateWhite();
        position = c;
        value = WHITE_VALUE_NORMAL;
        stringRep = "O";
    }

    public int getColor() {
        return WHITE;
    }

    public ImageIcon getIcon() {
        return null;
    }

    public void makeKing() {
        checkerState = new KingState();
        value = WHITE_VALUE_KING;
        stringRep = "W";
    }

    public boolean kingRow() {
        return ((position.get() >= 1) && (position.get() <= 4));
    }

    public boolean isKing() {
        return (value == WHITE_VALUE_KING);
    }

    public CheckerPosition copy() {
        CheckerPosition newChecker = new WhiteChecker(position);
        if (value == WHITE_VALUE_KING) {
            newChecker.makeKing();
        }
        return newChecker;
    }
}

/* Comments:-

This code defines the WhiteChecker class, which extends CheckerPosition. A WhiteChecker is a type of
CheckerPosition representing a white piece in the game of checkers, which moves upwards on the board.

The WhiteChecker class has a constructor that takes a Coordinate parameter, which is the position of the
piece on the board. It sets the initial state of the checkerState to a NormalStateWhite object, and the value of
the piece to WHITE_VALUE_NORMAL, which is a constant value defined elsewhere. It also sets the stringRep field to "O",
which is used for displaying the piece on the board.

The class also overrides some methods of the CheckerPosition class. The getColor method returns a constant value
indicating that the piece is white. The makeKing method changes the state of the checkerState to a KingState object
and updates the value and stringRep fields to reflect that the piece is now a king. The kingRow method returns true
if the piece is in the king row, which is the row closest to the opposite side of the board where the piece can be
promoted to a king. The isKing method returns true if the piece is a king. The getIcon method returns null,
indicating that this class doesn't define an icon for the piece. Finally, the copy method creates a new WhiteChecker
object with the same position as the current object, and returns it. If the current object is a king, the new object
is also made a king. */
