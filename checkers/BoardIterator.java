package checkers;

/**
 * Iterator for the BoardList class.
 */
public class BoardIterator {
   private BoardList boardList;
   private int current;
   
   public BoardIterator(BoardList boardList) {
      this.boardList = boardList;
      current = 0;
   }


   public boolean hasNext() {
      return (current < boardList.size());
   }
   
   
   public Board next() {
      return boardList.get(current++);
   }  
}

/* Comments: -

   This is a simple Java class that provides an iterator for the BoardList class.
   The BoardIterator class has two instance variables: boardList, which is the BoardList object to be iterated over, and current, which keeps track of the current index in the iteration.
   The constructor takes a BoardList object as a parameter and initializes boardList to this object and current to 0.

   The hasNext() method returns true if there are more elements in the boardList to iterate over (i.e., if the current index is less than the size of the boardList), and false otherwise.
   The next() method returns the next element in the boardList and advances the current index by 1.
   If there are no more elements in the boardList, it throws a NoSuchElementException.

 */