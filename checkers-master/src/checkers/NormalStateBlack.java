package checkers;

import java.io.Serializable;

/** Implements the state pattern for the metods findValidMoves and 
 * findValidJumps in class Checker.
 */
public class NormalStateBlack implements CheckerState ,Serializable{   
   
   // Attaches valid moves to the validMoves list. Returns true if a valid jump
   // exist.
   public boolean findValidMoves(final CheckerPosition c, final Board board, 
                              MoveList validMoves) {   
      if (! findValidJumps(c, board, validMoves)) {
         // If no valid jump exist then look for valid moves.
         if (GameSearch.validBlackMove(c.getPosition(), c.getPosition().downLeftMove(), 
             board))
            validMoves.add(new MoveNormal(c, c.getPosition().downLeftMove()));
            
         if (GameSearch.validBlackMove(c.getPosition(), c.getPosition().downRightMove(), 
             board))
            validMoves.add(new MoveNormal(c, c.getPosition().downRightMove()));
         return false;
      }
      else
         return true;
   }
   
   // Attaches valid jumps to the validJumps list. Returns true if a valid jump
   // exist.
   public boolean findValidJumps(final CheckerPosition c, final Board board, 
                              MoveList validJumps) {   
      boolean found = false;
      if (GameSearch.validBlackJump(c.getPosition(), c.getPosition().downLeftJump(), 
        board)) {
         validJumps.add(new MoveJump(c, c.getPosition().downLeftJump()));
         found = true;
      }
      
      if (GameSearch.validBlackJump(c.getPosition(), c.getPosition().downRightJump(), 
          board)) {
         validJumps.add(new MoveJump(c, c.getPosition().downRightJump()));
         found = true;
      }     
      return found;
   }
}
/* Comments:-

This code implements the state pattern for the methods findValidMoves and findValidJumps in the Checker class.
The NormalStateBlack class implements the CheckerState interface and represents the state of a black checker in its
normal state.

The findValidMoves method takes a CheckerPosition object, a Board object, and a MoveList object as arguments.
It first calls the findValidJumps method to check if there are any valid jumps. If there are no valid jumps,
t checks if there are any valid normal moves for the checker. If a valid move is found, it creates a new MoveNormal
object and adds it to the validMoves list. The method returns false if there are no valid jumps and true if there are.

The findValidJumps method also takes a CheckerPosition object, a Board object, and a MoveList object as arguments.
It checks if there are any valid jumps for the checker. If a valid jump is found, it creates a new MoveJump object and
adds it to the validJumps list. The method returns true if there are any valid jumps and false otherwise.

Overall, these methods use the GameSearch class to determine the validity of moves and jumps for a black checker
in its normal state, and add the valid moves and jumps to the appropriate MoveList object. */