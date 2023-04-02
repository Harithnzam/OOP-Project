package CheckersUI;

import java.awt.Point;
import javax.swing.ImageIcon;

public class Pawn {

    Point point;
    int posindex;

    ImageIcon image;
    int type;

    public Pawn(Point p, ImageIcon image) {
        this.point = p;
        this.image = image;
        posindex = 0;
    }

    public Point getP() {
        return point;
    }

    public void setP(Point p) {
        this.point = p;
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void movePawn(int from, int to) {

    }

    public static void main(String[] args) {
        // Create a new Point object to represent the position of the pawn
        Point position = new Point(0, 0);

        // Create a new ImageIcon object to represent the image of the pawn
        ImageIcon image = new ImageIcon("C:\\Users\\PC\\IdeaProjects\\checkers-master\\checkers-master\\src\\assets\\black_pawn.png");

        // Create a new Pawn object
        Pawn pawn = new Pawn(position, image);

        // Use the getter methods to access the fields of the Pawn object
        Point pawnPosition = pawn.getP();
        ImageIcon pawnImage = pawn.getImage();
        int pawnType = pawn.getType();

        // Output the values of the pawn's fields
        System.out.println("Pawn position: " + pawnPosition);
        System.out.println("Pawn image: " + pawnImage);
        System.out.println("Pawn type: " + pawnType);
    }
}

/* Comments : -

   This is a Java class for representing a pawn in a Checkers game, with properties for its position, image, and type.
   The class includes a constructor for initializing a new pawn with a given position and image,
   as well as getter and setter methods for accessing and modifying its properties.

   The movePawn() method is currently empty and would need to be implemented to actually move the pawn on the board.
   Overall, this class appears to be a basic starting point for representing pawns in a Checkers game,
   but additional functionality would likely need to be added to fully implement the game.

 */
