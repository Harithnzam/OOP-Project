package checkers;

import java.io.Serializable;

public class Board implements Serializable{
   private CheckerPosition[] board = new CheckerPosition[32];
   private MoveList history = new MoveList();  // History of moves.
   protected Board next = null;     
 
     
   public Board copy() {
      Board newBoard = new Board();
      Coordinate temp = null;
      newBoard.setHistory(history.copy());
      for (int i = 1; i < 33; i++) {
         temp = new Coordinate(i);
         if (getChecker(temp) != null)
            newBoard.setChecker(getChecker(temp).copy(), temp);
      }
      return newBoard;
      //for (int y = 0; y < 8; y++) {
         //for (int x = (y + 1) % 2; x < 8; x = x + 2)
   }

             
   public CheckerPosition getChecker(Coordinate c) {
      return board[c.get() - 1];
   }
   
   
   public void setChecker(CheckerPosition checker, Coordinate c) {
      board[c.get() - 1] = checker;
      checker.setPosition(c);
   }
   
   
   public void removeChecker(CheckerPosition checker) {
      board[checker.getPosition().get() - 1] = null;
   }
   
   
   public boolean vacantCoordinate(Coordinate c) {
      return (getChecker(c) == null);
   }

   
   public int evaluate() {
      int score = 0;
      Coordinate c = null;
      for (int i = 1; i < 33; i++) {
         c = new Coordinate(i);
         if (getChecker(c) != null)
            score = score + getChecker(c).getValue();
      }
      return score;
   }
  

   public void setHistory(MoveList history) {
      this.history = history;
   }
   
   
   public MoveList getHistory() {
      return history;
   }


   public void addMoveToHistory(Move move) {
      history.add(move);
   }
   
   
   public void initialize() {
      initializeTop();
      initializeMiddle();
      initializeBottom();
   }     
  
  
   private void initializeTop() {
      for (int i = 1; i < 13; i++)
         board[i - 1] = new BlackChecker(new Coordinate(i));   
   }     
   
   
   private void initializeMiddle() {
      for (int i = 13; i < 21; i++)
         board[i - 1] = null; 
   }   
  
  
   private void initializeBottom() {
      for (int i = 21; i < 33; i++)
         board[i - 1] = new WhiteChecker(new Coordinate(i));   
   }
    
   
   // For the BoardList class.
   public void setNext(Board next) { 
      this.next = next;   
   }
   
   
   // For the BoardList class.
   public Board getNext() {
      return next;
   }
  
   
   public String toString() {
      String stringBoard[][] = new String[8][8];
      Coordinate temp = null;
      for (int i = 1;i < 33; i++) {
         temp = new Coordinate(i);
         if (getChecker(temp) != null)
            stringBoard[temp.column()][temp.row()] = getChecker(temp).toString();
      }
      String s = " +---+---+---+---+---+---+---+---+\n ";
      for (int y = 0; y < 8; y++) {
         for (int x = 0; x < 8; x++) {
            if (stringBoard[x][y] != null)
               s = s + "| " + stringBoard[x][y] + " ";
            else
               s = s + "|   ";
         }
         s = s + "| (" + ((y*4)+1) + "-" + ((y*4)+4) + ")";
         s = s + "\n +---+---+---+---+---+---+---+---+\n ";       
      }
      return s;
   }
}

/* Comments:-

   This code defines a class named Board, which represents a checkers board.
   The Board class has an array of CheckerPosition objects named board that represents the positions of the checkers on the board,
   a MoveList object named history that represents the history of moves made on the board, and a Board object named next that represents the next board in a linked list of boards.

   The class provides several methods for manipulating the checkers board, including copy() for creating a copy of the board,
   getChecker() for retrieving a CheckerPosition object at a specific coordinate on the board,setChecker() for setting a CheckerPosition object at a specific coordinate on the board,
   removeChecker() for removing a CheckerPosition object from the board, vacantCoordinate() for checking if a coordinate on the board is vacant,
   evaluate() for computing the score of the board,  setHistory() and getHistory() for setting and retrieving the move history,
   addMoveToHistory() for adding a move to the move history, and toString() for creating a string representation of the board.

   The class also defines several private methods for initializing the checkers on the board, including initializeTop(),
   initializeMiddle(), and initializeBottom(), which populate the top, middle, and bottom rows of the board with black and white checkers.

   Overall, this code provides a basic implementation of a checkers board in Java.

 */