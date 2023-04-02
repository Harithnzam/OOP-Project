package checkers;

import javax.swing.ImageIcon; 
import java.net.URL;

public class BlackChecker extends CheckerPosition {

   public BlackChecker(Coordinate c) {
      checkerState = new NormalStateBlack();
      position = c;
      value = BLACK_VALUE_NORMAL;
      stringRep = "X";
   }
     
   
   public int getColor() {
      return BLACK;
   }
   
   
  
   
   
   public void makeKing() {
      checkerState = new KingState();
      value = BLACK_VALUE_KING;
      stringRep = "B";
   }
   
   
   public boolean isKing() {
      return (value == BLACK_VALUE_KING);
   }
   
     
   public boolean kingRow() {
      return ( (position.get() >= 29) && (position.get() <= 32) );
   }
   
   
   public CheckerPosition copy() {
      CheckerPosition newChecker = new BlackChecker(position);
      if (value == BLACK_VALUE_KING)
         newChecker.makeKing();
      return newChecker;
   }          

    @Override
    public ImageIcon getIcon() {
        return  null;
    }

}

/* Comments:-

   This is a Java class for representing a black checker in a Checkers game, which extends the CheckerPosition abstract class.
   The class includes a constructor that initializes the checker's state, position, value, and string representation.

   The class includes methods for getting the checker's color, making it a king, checking if it is a king, and checking if it is in the king row.
   The copy() method creates a new instance of the BlackChecker class with the same position, and makes it a king if the original checker is a king.

   The getIcon() method returns null and would need to be implemented to return the image of the black checker.
   Overall, this class appears to be a basic starting point for representing black checkers in a Checkers game,
   but additional functionality would likely need to be added to fully implement the game.

 */