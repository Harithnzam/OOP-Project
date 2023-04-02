package checkers;

import javax.swing.*;

public class MoveJump extends Move {
 
   public MoveJump(CheckerPosition checker, Coordinate destination) {
      this.checker = checker;
      this.destination = destination;
   }
  
  
   public boolean isJump() {
      return true;
   }
   
   
   public Move copy() {
      return new MoveJump(checker.copy(), destination);
   }
   
   
   // Return a copy of this move from the newBoard.   
   public Move copy(Board newBoard) {
      return new MoveJump(newBoard.getChecker(checker.getPosition()), 
                          destination);
   }
      
  
   // Returns the coordinate of the captured checker of this move.
   public Coordinate capturedCoordinate() {
      if (checker.getPosition().row() - destination.row() == 2) { // Up.
         if (checker.getPosition().column() - destination.column() == 2) //Up,left.
            return checker.getPosition().upLeftMove();      
         else
            return checker.getPosition().upRightMove();
      }
      else { // Down.
         if (checker.getPosition().column() - destination.column() == 2)//Down,left.
            return checker.getPosition().downLeftMove();      
         else
            return checker.getPosition().downRightMove();     
      }
   }
  
   
   public String toString() {
      String s = "";
      if (checker.getColor() == CheckerPosition.BLACK) s = "Black-J:"; else s = "White-J:";
      s = s + "(" + checker.getPosition() + "-" + destination + ")";
      return s; 
   }

   public static void main(String[] args) {
      CheckerPosition blackChecker = new CheckerPosition() {
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
      CheckerPosition whiteChecker = new CheckerPosition() {
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
      // Use the MoveJump object as needed
   }
}

/* Comments:-

This code defines a class MoveJump which extends the Move abstract class. It represents a move where a
checker jumps over another checker.

The class has two instance variables: checker which is a CheckerPosition object representing the checker making the jump,
and destination which is a Coordinate object representing the square where the checker lands after the jump.

The class provides implementations for the abstract methods isJump(), copy(), and toString(). The isJump() method
returns true to indicate that this is a jump move. The copy() method returns a copy of this MoveJump object,
either with the same CheckerPosition object and destination coordinate, or with a new CheckerPosition object from a
different Board. The toString() method returns a String representation of the move, in the format
"Black-J:(startCoordinate-endCoordinate)" or "White-J:(startCoordinate-endCoordinate)".

The class also provides a method capturedCoordinate() which returns the Coordinate of the checker that was captured
during the jump.

Finally, the main() method creates two CheckerPosition objects (one for a black checker and one for a white checker)
for testing purposes. */