package checkers;

/**
 * Iterator for the MoveList class.
 */
public class MoveIterator {
   private MoveList moveList;
   private int current;
   
   public MoveIterator(MoveList moveList) {
      this.moveList = moveList;
      current = 0;
   }


   public boolean hasNext() {
      return (current < moveList.size());
   }
   
   
   public Move next() {
      return moveList.get(current++);
   }

   public static void main(String[] args) {
      MoveList moveList = new MoveList();
      // Add moves to the moveList

      MoveIterator mi = new MoveIterator(moveList);
      // Use the MoveIterator object to iterate over the moves in the MoveList
   }
}

/* Comments:-

This code defines an iterator class for the MoveList class in the checkers package.
The iterator allows iterating over the moves in the list using the hasNext() and next() methods.

The MoveIterator class has two instance variables: moveList, which is the list of moves being iterated over,
and current, which is the index of the current move in the list.

The constructor takes a MoveList object as its argument and initializes moveList to this argument and current to 0.

The hasNext() method returns true if there are more moves in the list to iterate over, which is the case if the
current index is less than the size of the moveList.

The next() method returns the next move in the list and increments the current index by 1.

The main() method is provided as an example of how to use the MoveIterator class. It creates an empty MoveList object,
adds moves to it, creates a MoveIterator object with the MoveList, and then uses the iterator to iterate over the moves
in the list. */