package checkers;

import java.io.Serializable;

public class Coordinate implements Serializable{

    private int c;

    public Coordinate(int c) {
        this.c = c;
    }

    Coordinate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int get() {
        return c;
    }

    public boolean equals(Coordinate d) {
        return (c == d.get());
    }

    // Returns the row (0-7) of the coordinate (1-32).
    public int row() {
        int row;
        row = (int) Math.floor(c / 4.0);
        if (c % 4 == 0) {
            return row - 1;
        } else {
            return row;
        }
    }

    // Returns the column (0-7) of the coordinate (1-32).
    public int column() {
        if (row() % 2 == 0) {
            return (((c - (row() * 4)) * 2) - 1);
        } else {
            return (((c - (row() * 4)) * 2) - 2);
        }
    }

    public String toString() {
        return "" + c;
    }

    // Returns the coordinate of the square that is one square above and one
    // square to the left of c.
    public Coordinate upLeftMove() {
        //System.out.println("Checking if it is Up left Move");

        if (row() % 2 == 0) {
            return new Coordinate(c - 5);
        } else {
            return new Coordinate(c - 4);
        }
    }

    public Coordinate upRightMove() {
        //System.out.println("Checking if it is Up Right Move");
        //System.out.println("The Row of this Checker is " + row());

        if (row() % 2 == 0) {
            return new Coordinate(c - 4);
        } else {
            return new Coordinate(c - 3);
        }
    }

    public Coordinate downLeftMove() {
        if (row() % 2 == 0) {
            return new Coordinate(c + 3);
        } else {
            return new Coordinate(c + 4);
        }
    }

    public Coordinate downRightMove() {
        if (row() % 2 == 0) {
            return new Coordinate(c + 4);
        } else {
            return new Coordinate(c + 5);
        }
    }

    public Coordinate upLeftJump() {
        return new Coordinate(c - 9);
    }

    public Coordinate upRightJump() {
        return new Coordinate(c - 7);
    }

    public Coordinate downLeftJump() {
        return new Coordinate(c + 7);
    }

    public Coordinate downRightJump() {
        return new Coordinate(c + 9);
    }
}

/* Comments:-

This is a Java code for a Coordinate class used in a Checkers game. The Coordinate class has several
methods to calculate the row and column of a coordinate on the Checkers board, as well as methods to determine
the possible moves and jumps that a Checkers piece can make based on its current position.

The class implements the Serializable interface, which allows objects of the class to be converted into a byte stream
and sent over the network or stored in a file.

The constructor takes an integer value representing the coordinate, and the get() method returns that value.

The equals() method takes another Coordinate object and returns true if the values of the two coordinates are equal.

The row() method calculates and returns the row of the current coordinate on the Checkers board based on its value.

The column() method calculates and returns the column of the current coordinate on the Checkers board based on
its value and the row.

The toString() method returns a string representation of the coordinate value.

The upLeftMove(), upRightMove(), downLeftMove(), and downRightMove() methods return the possible moves
that a Checkers piece can make based on its current position.

The upLeftJump(), upRightJump(), downLeftJump(), and downRightJump() methods return the possible jumps that a Checkers
piece can make based on its current position.

The class also has a default constructor that throws an UnsupportedOperationException. */

