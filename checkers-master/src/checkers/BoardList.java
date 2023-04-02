package checkers;

/** 
 * A linked list of boards.
 */
public class BoardList {
   private Board boardList;
   private Board last;
   private int listSize;
   
   
   public BoardList() {
      listSize = 0;   
      boardList = null;
   }


   public void add(Board b) {
      if (boardList == null) { // first element.
         boardList = b;
         last = b;
      }
      else {
         last.setNext(b);     // attach to end of list.
         last = b;
      }               
      listSize++;
   } 
   
   
   public int size() {
      return listSize;
   }   
   
   
   public Board first() {
      return boardList;
   }
   
   
   public Board get(int index) throws IndexOutOfBoundsException {
      int current = 0;
      Board board = boardList;
      while (current != index) {
         board = board.getNext();
         if (board == null) throw new IndexOutOfBoundsException(); 
         current++;
      }
      return board;
   }
   
   
   public BoardIterator getIterator() {
      return new BoardIterator(this);
   }
   
   
   public Board findBestBoard(int color) {
      BoardIterator iterator = getIterator();
      Board bestBoard = iterator.next();
      while (iterator.hasNext()) {
         if (color == CheckerPosition.WHITE) 
            bestBoard = GameSearch.maxBoard(bestBoard, iterator.next());
         else 
            bestBoard = GameSearch.minBoard(bestBoard, iterator.next());
      }
      return bestBoard;   
   }

   
   public String toString() {
      BoardIterator iterator = getIterator();
      String s = "BoardList: ";
      while (iterator.hasNext()) {
         s = s + iterator.next().toString();
         if (iterator.hasNext()) s = s + " , ";
      }
      return s;
   }
}

/* Comments:-

This is the implementation of a linked list of boards.
The class has instance variables to keep track of the first and last elements of the list, as well as the size of the list.

The constructor initializes the list size to zero and the boardList to null.

The add method adds a board to the end of the list. If the boardList is empty, the board becomes the first element of the list.
Otherwise, the board is attached to the end of the list using the setNext method of the last board.

The size method returns the size of the list.

The first method returns the first board in the list.

The get method returns the board at the specified index.
It iterates through the list until it reaches the specified index, throwing an IndexOutOfBoundsException if the index is out of bounds.

The getIterator method returns a new BoardIterator object for the BoardList.

The findBestBoard method iterates through the list and returns the board with the best evaluation score, based on the color of the current player.
It uses the maxBoard and minBoard methods from the GameSearch class to compare the evaluation scores of the boards.

The toString method returns a string representation of the BoardList, which consists of a comma-separated list of the string representations of the individual boards in the list.

 */