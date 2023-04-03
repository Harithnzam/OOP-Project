//Che Ku

package checkers;

public class BoardList {

   // Declare private member variables.
   private Board boardList; // The first board in the list.
   private Board last; // The last board in the list.
   private int listSize; // The number of boards in the list.

   // Constructor method for BoardList class.
   public BoardList() {
      listSize = 0;
      boardList = null;
   }

   // Add a board to the end of the list.
   public void add(Board b) {
      if (boardList == null) { // If the list is empty, set the first and last boards to b.
         boardList = b;
         last = b;
      }
      else {
         last.setNext(b); // Otherwise, attach b to the end of the list.
         last = b;
      }
      listSize++; // Increment the size of the list.
   }

   // Get the number of boards in the list.
   public int size() {
      return listSize;
   }

   // Get the first board in the list.
   public Board first() {
      return boardList;
   }

   // Get the board at the given index in the list.
   public Board get(int index) throws IndexOutOfBoundsException {
      int current = 0;
      Board board = boardList;
      while (current != index) { // Traverse the list until the desired index is reached.
         board = board.getNext();
         if (board == null) throw new IndexOutOfBoundsException(); // Throw an exception if the index is out of bounds.
         current++;
      }
      return board;
   }

   // Get an iterator over the boards in the list.
   public BoardIterator getIterator() {
      return new BoardIterator(this);
   }

   // Find the best board in the list for the given color.
   public Board findBestBoard(int color) {
      BoardIterator iterator = getIterator();
      Board bestBoard = iterator.next(); // Assume the first board is the best.
      while (iterator.hasNext()) { // Traverse the list and compare each board to the current best board.
         if (color == CheckerPosition.WHITE)
            bestBoard = GameSearch.maxBoard(bestBoard, iterator.next());
         else
            bestBoard = GameSearch.minBoard(bestBoard, iterator.next());
      }
      return bestBoard;
   }

   // Convert the list to a string.
   public String toString() {
      BoardIterator iterator = getIterator();
      String s = "BoardList: ";
      while (iterator.hasNext()) { // Traverse the list and add each board's string representation to the string.
         s = s + iterator.next().toString();
         if (iterator.hasNext()) s = s + " , "; // Add a comma and space between boards, unless it's the last one.
      }
      return s;
   }


   //to check error in this class
   public static void main(String[] args) {

      // Create some Board objects.
      Board board1 = new Board();
      Board board2 = new Board();
      Board board3 = new Board();

      // Create a BoardList and add the boards to it.
      BoardList boardList = new BoardList();
      boardList.add(board1);
      boardList.add(board2);
      boardList.add(board3);

      // Print the size of the list and the first board.
      System.out.println("List size: " + boardList.size());
      System.out.println("First board: " + boardList.first().toString());

      // Print the string representation of the list.
      System.out.println(boardList.toString());

      // Get an iterator over the list and print each board.
      BoardIterator iterator = boardList.getIterator();
      while (iterator.hasNext()) {
         Board board = iterator.next();
         System.out.println(board.toString());
      }

      // Find the best board for white and print it.
      Board bestBoard = boardList.findBestBoard(CheckerPosition.WHITE);
      System.out.println("Best board for white: " + bestBoard.toString());
   }
}


