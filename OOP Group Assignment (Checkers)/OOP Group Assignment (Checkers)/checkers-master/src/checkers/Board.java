package checkers;

import javax.swing.*;
import java.io.CharConversionException;
import java.io.Serializable;

public class Board implements Serializable {
   // An array of CheckerPosition objects representing the current state of the board.
   private CheckerPosition[] board = new CheckerPosition[32];

   // A MoveList object that keeps track of the history of moves made on the board.
   private MoveList history = new MoveList();

   // A reference to the next Board object in the BoardList.
   protected Board next = null;

   // Creates a deep copy of the Board object.
   public Board copy() {
      Board newBoard = new Board();
      Coordinate temp = null;

      // Sets the new Board's MoveList to a deep copy of the current Board's MoveList.
      newBoard.setHistory(history.copy());

      // Iterates through each square of the board.
      for (int i = 1; i < 33; i++) {
         temp = new Coordinate(i);

         // If the square contains a CheckerPosition object, sets the corresponding square in the new board
         // to a  copy of the CheckerPosition object.
         if (getChecker(temp) != null)
            newBoard.setChecker(getChecker(temp).copy(), temp);
      }
      return newBoard;
   }

   // Returns the CheckerPosition object located at the specified Coordinate on the board.
   public CheckerPosition getChecker(Coordinate c) {
      return board[c.get() - 1];
   }

   // Sets the CheckerPosition object located at the specified Coordinate on the board to the specified
   // CheckerPosition object.
   public void setChecker(CheckerPosition checker, Coordinate c) {
      board[c.get() - 1] = checker;
      checker.setPosition(c);
   }

   // Removes the specified CheckerPosition object from the board.
   public void removeChecker(CheckerPosition checker) {
      board[checker.getPosition().get() - 1] = null;
   }

   // Returns true if the specified Coordinate on the board does not contain a CheckerPosition object.
   public boolean vacantCoordinate(Coordinate c) {
      return (getChecker(c) == null);
   }

   // Evaluates the current state of the board and returns a score representing the board's "value."
   public int evaluate() {
      int score = 0;
      Coordinate c = null;

      // Iterates through each square of the board.
      for (int i = 1; i < 33; i++) {
         c = new Coordinate(i);

         // If the square contains a CheckerPosition object, adds the object's value to the score.
         if (getChecker(c) != null)
            score = score + getChecker(c).getValue();
      }
      return score;
   }

   // Sets the current Board's MoveList to the specified MoveList.
   public void setHistory(MoveList history) {
      this.history = history;
   }

   // Returns the current Board's MoveList.
   public MoveList getHistory() {
      return history;
   }

   // Adds the specified Move object to the current Board's MoveList.
   public void addMoveToHistory(Move move) {
      history.add(move);
   }

   // Initializes the board with the standard starting positions of the checkers.
   public void initialize() {
      initializeTop();
      initializeMiddle();
      initializeBottom();
   }

   // Initializes the top three rows of the board with black checkers.
   private void initializeTop() {
      for (int i = 1; i < 13; i++)
         board[i - 1] = new BlackChecker(new Coordinate(i));

   }

   // This method initializes the middle rows of the board with null values, representing empty spaces.
   private void initializeMiddle() {
      for (int i = 13; i < 21; i++)
         board[i - 1] = null;
   }

   // This method initializes the bottom rows of the board with white checkers.
   private void initializeBottom() {
      for (int i = 21; i < 33; i++)
         board[i - 1] = new WhiteChecker(new Coordinate(i));
   }

   // Setter method for the next Board in the BoardList.
   // For the BoardList class.
   public void setNext(Board next) {
      this.next = next;
   }

   // Getter method for the next Board in the BoardList.
   // For the BoardList class.
   public Board getNext() {
      return next;
   }

   // Overrides the default toString method to return a visual representation of the board.
   public String toString() {
      String stringBoard[][] = new String[8][8];
      Coordinate temp = null;
      for (int i = 1; i < 33; i++) {
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
         s = s + "| (" + ((y * 4) + 1) + "-" + ((y * 4) + 4) + ")";
         s = s + "\n +---+---+---+---+---+---+---+---+\n ";
      }
      return s;

   }

   public static void main(String[] args) {

      Board board = new Board();
      Board nextBoard =new Board();
      MoveList newMove = new MoveList();


      board.copy();
      board.setHistory(newMove);

      board.getHistory();
      board.setNext(nextBoard);
      board.getNext();
      board.initialize();



      board.toString();



   }
}

