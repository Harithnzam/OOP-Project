//Che Ku

package checkers;

public class BoardIterator {

   // Declare private member variables.
   private BoardList boardList; // A reference to the BoardList object to iterate over.
   private int current; // An integer representing the current index in the iteration.

   // Constructor method for BoardIterator class.
   public BoardIterator(BoardList boardList) {
      this.boardList = boardList; // Set the boardList member variable to the passed-in object.
      current = 0; // Set the current index to 0 (the beginning of the list).
   }

   // Check if there is a next element in the iteration.
   public boolean hasNext() {
      return (current < boardList.size()); // Return true if the current index is less than the size of the list.
   }

   // Get the next element in the iteration.
   public Board next() {
      return boardList.get(current++); // Return the current board and increment the index by 1.
   }


   //to check error in this class
   //using simple code to run this class
   public static void main(String[] args) {
      BoardList boardList = new BoardList();
      boardList.add(new Board());
      boardList.add(new Board());
      boardList.add(new Board());

      BoardIterator iterator = new BoardIterator(boardList);
      while (iterator.hasNext()) {
         Board board = iterator.next();
         System.out.println(board.toString());
      }
   }

}
