package checkers;

import java.io.StreamTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;

public class FormattedInput {   
   
   private StreamTokenizer keyboard = new StreamTokenizer(
                                     new InputStreamReader(System.in)); 
   
   
   public int readCoordinate(String output) {
      boolean number = false;
      while (! number) {
         System.out.print(output);
         try {
            if ( (keyboard.nextToken() == keyboard.TT_NUMBER) &
                  (keyboard.nval >= 1) & (keyboard.nval <= 32) ) 
               number = true;
            else
               System.out.println("Wrong input.");
         }
         catch (IOException e) {
            System.out.println("Wrong input.");
         }
      }
      return (int) keyboard.nval;
   }         
   
   
   public int readColor() {
      boolean correct = false;
      int input = 0;
      while (! correct) {
          input = readCoordinate("Please choose color - black (1) " +
                                      "or White (2):");
         if ((input == CheckerPosition.BLACK) || (input == CheckerPosition.WHITE))
            correct = true;
         else
            System.out.println("Please type 1 for black and 2 for white.");
      }
      return input;
   }
}

/* Comments:-

This is a Java code for a FormattedInput class used in a Checkers game. The FormattedInput class reads user input
from the keyboard and validates it to ensure that it is in the correct format.

The class has a private StreamTokenizer object named keyboard, which is initialized with an InputStreamReader object
that reads input from the console.

The readCoordinate() method takes a String parameter representing the output prompt to display to the user. It reads
input from the keyboard and validates it to ensure that it is a number between 1 and 32. If the input is invalid, it
displays an error message and prompts the user to enter a valid number.

The method returns the integer value of the user's input.

The readColor() method calls the readCoordinate() method to read the user's input for the color of the Checker piece.
It validates the input to ensure that it is either 1 (black) or 2 (white). If the input is invalid, it displays an error
message and prompts the user to enter a valid number.

The method returns the integer value of the user's input, which represents the color of the Checker piece. */





