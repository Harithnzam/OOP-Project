package checkers;

/** 
 * State pattern for the metods findValidMoves and findValidJumps in class Checker.
 * The two methods delegate the methods to a CheckerState object that can either
 * be NormalStateWhite, NormalStateBlack or KingState. This way an checker can
 * change state when it becomes a king.
 */
public interface CheckerState {    
   public boolean findValidMoves(CheckerPosition checker, Board board, 
                              MoveList validMoves);

   public boolean findValidJumps(CheckerPosition checker, Board board,
                              MoveList validJumps);
}

/* Comments:-

This is the interface for the State pattern implementation for the Checker class.
It declares two methods that will be implemented by different concrete classes that will represent different states that a Checker object can be in.

The findValidMoves and findValidJumps methods are used to find all the valid moves and jumps that a checker piece can make on a given Board object.
The implementation of these methods is delegated to the CheckerState object that is associated with the Checker object.

This allows the Checker object to change its behavior dynamically depending on its current state.
The concrete classes that implement the CheckerState interface will be NormalStateWhite, NormalStateBlack or KingState.
These classes will define how the Checker behaves based on its current state.

 */