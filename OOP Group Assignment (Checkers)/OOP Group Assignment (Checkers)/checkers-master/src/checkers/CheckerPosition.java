package checkers;

import java.io.Serializable;
import javax.swing.ImageIcon;

// This is an abstract class that extends the Position class and implements the Serializable interface.
public abstract class CheckerPosition extends Position implements Serializable{

   // Constants that define the color and values of checkers.
   public static final int BLACK = 1;
   public static final int WHITE = 2;
   public static final int WHITE_VALUE_NORMAL = 2;
   public static final int BLACK_VALUE_NORMAL = -2;
   public static final int WHITE_VALUE_KING = 3;
   public static final int BLACK_VALUE_KING = -3;

   // Instance variables that represent the state, position, value, and string representation of a checker.
   protected CheckerState checkerState;
   protected Coordinate position;
   protected int value;
   protected String stringRep;

   // Abstract methods that define the behavior of checkers.
   public abstract boolean isKing();
   public abstract int getColor();
   public abstract void makeKing();
   public abstract CheckerPosition copy();
   public abstract boolean kingRow();
   public abstract ImageIcon getIcon();

   // Getter and setter methods for the position and value of a checker.
   public Coordinate getPosition() {
      return position;
   }

   public void setPosition(Coordinate c) {
      position = c;
   }

   public int getValue() {
      return value;
   }

   // Methods that find valid moves and jumps for a checker on a given board.
   public boolean findValidMoves(MoveList moveList, final Board board) {
      return checkerState.findValidMoves(this, board, moveList);
   }

   public boolean findValidJumps(MoveList moveList, final Board board) {
      return checkerState.findValidJumps(this, board, moveList);
   }

   // Method that returns a string representation of a checker.
   public String toString() {
      return stringRep;
   }

   // Main method that creates a new CheckerPosition object for testing purposes.
   public static void main (String args[]){
      CheckerPosition cp = new CheckerPosition() {
         @Override
         public boolean isKing() {
            return false;
         }

         @Override
         public int getColor() {
            return 0;
         }

         @Override
         public void makeKing() {

         }

         @Override
         public CheckerPosition copy() {
            return null;
         }

         @Override
         public boolean kingRow() {
            return false;
         }

         @Override
         public ImageIcon getIcon() {
            return null;
         }
      };
   }
}
