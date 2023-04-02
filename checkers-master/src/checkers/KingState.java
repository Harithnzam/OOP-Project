package checkers;

import java.io.Serializable;

/** Implements the state pattern for the metods findValidMoves and 
 * findValidJumps in class Checker.
 */
public class KingState implements CheckerState,Serializable {    
   
   public boolean findValidMoves(final CheckerPosition c, final Board board, 
                              MoveList validMoves) {
      if (! findValidJumps(c, board, validMoves)) {         
      
         if (GameSearch.validKingMove(c.getPosition(), c.getPosition().downLeftMove(), 
             board)) 
            validMoves.add(new MoveNormal(c, c.getPosition().downLeftMove()));
           
         if (GameSearch.validKingMove(c.getPosition(), c.getPosition().downRightMove(), 
             board))
            validMoves.add(new MoveNormal(c, c.getPosition().downRightMove()));
        
         if (GameSearch.validKingMove(c.getPosition(), c.getPosition().upLeftMove(), 
             board))
            validMoves.add(new MoveNormal(c, c.getPosition().upLeftMove()));
            
         if (GameSearch.validKingMove(c.getPosition(), c.getPosition().upRightMove(), 
             board))
            validMoves.add(new MoveNormal(c, c.getPosition().upRightMove()));
         return false;
      }
      else
         return true;
   }
   
   
   public boolean findValidJumps(final CheckerPosition c, final Board board, 
                              MoveList validJumps) {
      boolean found = false;                              
      if (GameSearch.validKingJump(c.getPosition(), c.getPosition().downLeftJump(), 
          board)) {
         validJumps.add(new MoveJump(c, c.getPosition().downLeftJump()));
         found = true;
      }
      
      if (GameSearch.validKingJump(c.getPosition(), c.getPosition().downRightJump(), 
          board)) {
         validJumps.add(new MoveJump(c, c.getPosition().downRightJump()));
         found = true;
      }
    
      if (GameSearch.validKingJump(c.getPosition(), c.getPosition().upLeftJump(), 
          board)) {
         validJumps.add(new MoveJump(c, c.getPosition().upLeftJump()));
         found = true;
      }
      
      if (GameSearch.validKingJump(c.getPosition(), c.getPosition().upRightJump(), 
          board)) {
         validJumps.add(new MoveJump(c, c.getPosition().upRightJump()));
         found = true;
      }
      return found;
   }
}

/* Comments:-

This code implements the KingState class, which represents the state of a checker piece when it is a king
in a game of checkers. The class implements the CheckerState interface and provides implementations for the
findValidMoves and findValidJumps methods.

The findValidMoves method checks if there are any valid jumps for the king using the findValidJumps method.
If there are no valid jumps, the method checks for valid normal moves in all four diagonal directions using the
validKingMove method from the GameSearch class. If a valid move is found in any direction, a new MoveNormal object
is added to the validMoves list.

The findValidJumps method checks for valid jumps in all four diagonal directions using the validKingJump method from
the GameSearch class. If a valid jump is found in any direction, a new MoveJump object is added to the validJumps list.
The method returns true if at least one valid jump is found, indicating that the piece must make a jump, and false otherwise.

Overall, the KingState class provides a way to determine the valid moves and jumps for a king piece in a game of checkers. */