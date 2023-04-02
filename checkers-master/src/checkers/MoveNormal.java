package checkers;

public class MoveNormal extends Move {
   
   public MoveNormal(CheckerPosition checker, Coordinate destination) {
      this.checker = checker;
      this.destination = destination;
   }
   
   
   public boolean isJump() {
      return false;
   }
   
   
   public Move copy() {
      return new MoveNormal(checker.copy(), destination);
   }

   
   // Return a copy of this move from the newBoard.   
   public Move copy(Board newBoard) {
      return new MoveNormal(newBoard.getChecker(checker.getPosition()), 
                            destination);
   }
   
   
   public String toString() {
      String s = "Move: ";
      if (checker.getColor() == CheckerPosition.BLACK) s = "Black:"; else s = "White:";
      s = s + "(" + checker.getPosition() + "-" + destination + ")";
      return s; 
   }
}

/* Comments:-

This code defines a class MoveNormal which is a subclass of the Move class. It represents a normal move in a game of
checkers, where a checker moves to an adjacent square.

The class has a constructor that takes a CheckerPosition object and a Coordinate object, representing the position of the
checker to be moved and the destination square, respectively. The isJump() method returns false, since this move does not
involve jumping over an opponent's checker.

The copy() method returns a new MoveNormal object with a copy of the CheckerPosition object and the same Coordinate
object as the original move. There is also an overloaded copy() method that takes a Board object as an argument and
returns a new MoveNormal object with a copy of the checker position on the new board and the same destination as the
original move.

Finally, the toString() method returns a string representation of the move, including the color of the checker
being moved, the starting and ending coordinates of the move. */