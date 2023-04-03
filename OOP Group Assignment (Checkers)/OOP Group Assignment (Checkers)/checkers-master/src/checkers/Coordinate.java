package checkers;

import java.io.Serializable;

public class Coordinate implements Serializable{

    private int c;

    //constructor
    Coordinate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean equals(Coordinate d) {
        return (c == d.get());
    } // number within accepted coordinate

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

    public int get() {
        return c;
    }

    public Coordinate(int c) {
        this.c = c;
    }

    public Coordinate upLeftMove() {

        if (row() % 2 == 0) {
            return new Coordinate(c - 5);
        } else {
            return new Coordinate(c - 4);
        }
    }

    // method for movement from 1 coordinate
    public Coordinate upRightMove() {


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

    public static void main(String args[]){ // main function for error checking

        Coordinate cd = new Coordinate(8);
        System.out.println("Get function: " + cd.get() + " Equals function: " + cd.equals(cd));
        System.out.println("Row: " + cd.row() + " Column: " + cd.column());
        System.out.println(cd.toString());
        Coordinate test1 = cd.upLeftJump();
        Coordinate test2 = cd.upRightJump();
        Coordinate test3 = cd.downLeftJump();
        Coordinate test4 = cd.downRightJump();
        Coordinate test5 = cd.upLeftMove();
        Coordinate test6 = cd.upRightMove();
        Coordinate test7 = cd.downLeftMove();
        Coordinate test8 = cd.downRightMove();

    }
}

