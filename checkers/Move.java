package checkers;

import java.io.Serializable;

public abstract class Move implements Serializable{   
   protected Coordinate destination;
   protected CheckerPosition checker;
   protected Move next = null;
      
   public abstract boolean isJump();
   public abstract String toString();
   public abstract Move copy(Board newBoard);
   public abstract Move copy();
   
   
   public CheckerPosition getChecker() {
      return checker;
   }
   
   
   public Coordinate getDestination() {
      return destination;
   }


   // For the MoveList class.
   public void setNext(Move next) {
      this.next = next;   
   }
   
   
   // For the MoveList class.
   public Move getNext() {
      return next;
   }

}

/* Comments:-

This code defines an abstract class Move in the checkers package that implements the Serializable
interface. The class contains several instance variables and methods that are common to all moves in a game of checkers.

The instance variables include destination, which represents the square that the checker will move to,
checker, which represents the checker being moved, and next, which represents the next move in a sequence of moves.

The methods in the class are as follows:

isJump(): an abstract method that returns a boolean indicating whether the move is a jump or not.
toString(): an abstract method that returns a string representation of the move.
copy(Board newBoard): an abstract method that creates a copy of the move, but with a new Board object.
copy(): an abstract method that creates a copy of the move.
getChecker(): a method that returns the checker being moved.
getDestination(): a method that returns the destination square of the move.
setNext(Move next): a method that sets the next move in a sequence.
getNext(): a method that returns the next move in a sequence.
Since this is an abstract class, it cannot be instantiated on its own. Instead, subclasses must be created
that implement the abstract methods. */