//Ahmad Najwan
package checkers;

import javax.swing.ImageIcon;
import java.net.URL;

public class BlackChecker extends CheckerPosition {
   // Constructor for creating a black checker piece with a normal state
   public BlackChecker(Coordinate c) {
      checkerState = new NormalStateBlack();
      position = c;
      value = BLACK_VALUE_NORMAL;
      stringRep = "X";
   }

   // Getter for the color of the checker piece
   public int getColor() {
      return BLACK;
   }

   // Method for making a normal black checker piece a king
   public void makeKing() {
      checkerState = new KingState();
      value = BLACK_VALUE_KING;
      stringRep = "B";
   }

   // Getter for whether the checker piece is a king
   public boolean isKing() {
      return (value == BLACK_VALUE_KING);
   }

   // Getter for whether the checker piece is in the king row
   public boolean kingRow() {
      return (position.get() >= 29 && position.get() <= 32);
   }

   // Method for creating a copy of the black checker piece
   public CheckerPosition copy() {
      CheckerPosition newChecker = new BlackChecker(position);
      if (value == BLACK_VALUE_KING) {
         newChecker.makeKing();
      }
      return newChecker;
   }

   // Getter for the icon of the black checker piece
   @Override
   public ImageIcon getIcon() {
      return null;
   }

   // Main method that returns 0 and null for each of the methods
   public static void main(String[] args) {
      BlackChecker blackChecker = new BlackChecker(new Coordinate(0));
      System.out.println("getColor(): " + blackChecker.getColor() + ", expected: 1");
      System.out.println("isKing(): " + blackChecker.isKing() + ", expected: false");
      System.out.println("kingRow(): " + blackChecker.kingRow() + ", expected: false");

      System.out.println("getIcon(): " + blackChecker.getIcon() + ", expected: null");
      System.exit(0);
   }
}
