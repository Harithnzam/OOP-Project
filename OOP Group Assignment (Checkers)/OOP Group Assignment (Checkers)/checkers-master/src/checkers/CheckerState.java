package checkers;

// This is an interface that defines the behavior of a checker state.
public interface CheckerState {

   // Methods that find valid moves and jumps for a checker on a given board.
   public boolean findValidMoves(CheckerPosition checker, Board board, MoveList validMoves);
   public boolean findValidJumps(CheckerPosition checker, Board board, MoveList validJumps);

   // Main method that creates a new CheckerState object for testing purposes.
   public static void main (String args[]){
      CheckerState cs = new CheckerState() {
         @Override
         public boolean findValidMoves(CheckerPosition checker, Board board, MoveList validMoves) {
            return false;
         }

         @Override
         public boolean findValidJumps(CheckerPosition checker, Board board, MoveList validJumps) {
            return false;
         }
      };
   }
}
