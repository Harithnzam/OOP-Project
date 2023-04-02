package checkers;

import java.io.Serializable;

/** Implements the state pattern for the metods findValidMoves and 
 * findValidJumps in class Checker.
 */
public class NormalStateWhite implements CheckerState,Serializable {   
   
   // Attaches valid moves to the validMoves list. Returns true if a valid jump
   // exist.
   public boolean findValidMoves(final CheckerPosition c, final Board board, 
                              MoveList validMoves) {   
      if (! findValidJumps(c, board, validMoves)) {
         // If no valid jump exist then look for valid moves.
         if (GameSearch.validWhiteMove(c.getPosition(), c.getPosition().upLeftMove(), 
             board))
            validMoves.add(new MoveNormal(c, c.getPosition().upLeftMove()));
            
         if (GameSearch.validWhiteMove(c.getPosition(), c.getPosition().upRightMove(), 
             board))
            validMoves.add(new MoveNormal(c, c.getPosition().upRightMove()));
         return false;
     }
     else
      return true; 
      
   }   
   
   
   public boolean findValidJumps(CheckerPosition c, Board board, MoveList validJumps) {
      boolean found = false;
      if (GameSearch.validWhiteJump(c.getPosition(), c.getPosition().upLeftJump(), 
          board)) {
         validJumps.add(new MoveJump(c, c.getPosition().upLeftJump()));
         found = true;
      }
      
      if (GameSearch.validWhiteJump(c.getPosition(), c.getPosition().upRightJump(), 
          board)) {
         validJumps.add(new MoveJump(c, c.getPosition().upRightJump()));
         found = true;
      }
      return found;
   }
}

/* Comments:-

This code implements the CheckerState interface for the white pieces in the checkers game. It contains the
findValidMoves and findValidJumps methods, which are used to find all the valid moves and jumps for a given white
checker on the board.

The findValidMoves method first checks if there are any valid jumps available for the checker. If there are no valid
jumps, it looks for valid moves in the up-left and up-right directions. If a valid move is found, it creates a new
MoveNormal object and adds it to the validMoves list.

The findValidJumps method checks for valid jumps in the up-left and up-right directions. If a valid jump is found,
it creates a new MoveJump object and adds it to the validJumps list.

Both methods return a boolean value indicating whether any valid jumps were found or not. This is used by the
findValidMoves method to determine whether to look for valid moves or not.

The code is similar to the NormalStateBlack class, with the only difference being the direction of the moves and jumps. */

