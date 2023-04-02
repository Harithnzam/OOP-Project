package checkers;
 
import java.io.Serializable;
import javax.swing.ImageIcon; 

public abstract class CheckerPosition extends Position implements Serializable{
   
   public static final int BLACK = 1;
   public static final int WHITE = 2;
   public static final int WHITE_VALUE_NORMAL = 2;
   public static final int BLACK_VALUE_NORMAL = -2;
   public static final int WHITE_VALUE_KING = 3;
   public static final int BLACK_VALUE_KING = -3;
   
   protected CheckerState checkerState;
   protected Coordinate position;
   protected int value;
   protected String stringRep;
   
   public abstract boolean isKing();
   public abstract int getColor();
   public abstract void makeKing();
   public abstract CheckerPosition copy();
   public abstract boolean kingRow();
   public abstract ImageIcon getIcon();
   
   
   public Coordinate getPosition() {
      return position;
   } 
   
   
   public void setPosition(Coordinate c) {
      position = c;
   }
   
   
   public int getValue() {
      return value;
   }
   
   
   public boolean findValidMoves(MoveList moveList, final Board board) {
      return checkerState.findValidMoves(this, board, moveList);  
   }
   
   
   public boolean findValidJumps(MoveList moveList, final Board board) {
      return checkerState.findValidJumps(this, board, moveList);  
   }
   
   
   public String toString() {
      return stringRep;  
   }
    
}

/* Comments:-

This code defines an abstract class called CheckerPosition, which extends another class Position and implements the Serializable interface.
It contains a number of constants, fields, and abstract methods related to the state and behavior of a checkers game piece.

The class has four constant integers, representing the color of the checkers piece (either black or white), and the value of the piece when it is in a normal state (not a king) for both black and white.
Additionally, there are two constants representing the value of the piece when it is a king for both black and white.

The class has four fields:

1. checkerState of type CheckerState representing the state of the checkers piece (normal or king)
2. position of type Coordinate representing the position of the checkers piece on the game board
3. value of type int representing the value of the checkers piece
4. stringRep of type String representing a string representation of the checkers piece.

The class also has six abstract methods:

1. isKing(): a boolean method that returns whether the checkers piece is a king.
2. getColor(): a method that returns the color of the checkers piece (either BLACK or WHITE).
3. makeKing(): a void method that makes the checkers piece a king.
4. copy(): an abstract method that returns a copy of the checkers piece.
5. kingRow(): a boolean method that returns whether the checkers piece is in the king row (the last row for the opposite color).
6. getIcon(): a method that returns the icon of the checkers piece.

The class also has three methods:

1.1. getPosition(): a method that returns the position of the checkers piece on the game board.
1.2. setPosition(): a method that sets the position of the checkers piece on the game board.

2.1. findValidMoves(): a method that finds valid moves for the checkers piece and adds them to the specified MoveList. It returns a boolean indicating whether any moves were found.
2.2. findValidJumps(): a method that finds valid jumps for the checkers piece and adds them to the specified MoveList. It returns a boolean indicating whether any jumps were found.

3. toString(): a method that returns the string representation of the checkers piece.

 */