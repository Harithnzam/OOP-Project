package checkers;

import java.io.Serializable;

/** 
 * A linked list of moves.
 */
public class MoveList implements Serializable{
   private Move moveList;
   private Move last;
   private int listSize;
   
   
   public MoveList() {
      listSize = 0;   
      moveList = null;
   }


   public void add(Move c) {
      if (moveList == null) { // first element.
         moveList = c;
         last = c;
      }
      else {
         last.setNext(c);
         last = c;
      }               
      listSize++;
   } 
   
   
   public void remove(Move move) {
      if (move == moveList) {  // first element.
         moveList = moveList.getNext();
         listSize--;
      }
      else {
         MoveIterator iterator = getIterator();   
         Move previous = iterator.next();    // previous = first element.
         Move current = null;
         while (iterator.hasNext()) {
            current = iterator.next();
            if (move == current) {
               previous.setNext(current.getNext());
               listSize--;
            }
         }
      }
   }
      
   
   public int size() {
      return listSize;
   }   
   
   
   public Move first() {
      return moveList;
   }
   
   
   public void reset() {
      listSize = 0;
      moveList = null;
   }
   
   
   public Move get(int index) throws IndexOutOfBoundsException {
      int current = 0;
      Move move = moveList;
      while (current != index) {
         move = move.getNext();
         if (move == null) throw new IndexOutOfBoundsException(); 
         current++;
      }
      return move;
   }
   
   
   public MoveIterator getIterator() {
      return new MoveIterator(this);
   }
   
   
   public MoveList copy() {
      MoveIterator iterator = getIterator();
      MoveList newList = new MoveList();
      while (iterator.hasNext())
         newList.add(iterator.next().copy());
      return newList;
   }
   
   
   public String toString() {
      MoveIterator iterator = getIterator();
      String s = "Movelist: ";
      while (iterator.hasNext()) {
         s = s + iterator.next().toString();
         if (iterator.hasNext()) s = s + " , ";
      }
      return s;
   }
}

/* Comments:-

This code defines a class MoveList, which is a linked list of Move objects. It implements several methods for
adding, removing, and accessing elements of the list, as well as a method for creating a copy of the list.

The MoveList class has the following instance variables:

moveList: A reference to the first Move object in the list.
last: A reference to the last Move object in the list.
listSize: The number of elements in the list.
The class has the following constructor:

MoveList(): Creates an empty MoveList.
The MoveList class has the following methods:

add(Move c): Adds the given Move object to the end of the list.
remove(Move move): Removes the given Move object from the list, if it exists.
size(): Returns the number of elements in the list.
first(): Returns the first Move object in the list.
reset(): Clears the list.
get(int index): Returns the Move object at the given index in the list.
getIterator(): Returns a MoveIterator object for iterating over the list.
copy(): Returns a new MoveList object that is a copy of the current list.
toString(): Returns a string representation of the MoveList.
The MoveList class also defines a private inner class MoveIterator, which is used to iterate over the elements of the list. */