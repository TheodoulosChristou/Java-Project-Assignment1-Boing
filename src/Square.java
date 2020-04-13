import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
*
* Square is a square shape that can be drawn to the screen, either
* filled with colour or opaque.
* Its position is determined by the upper left corner of the
* square's bounding rectangle
*/
public class Square extends ClosedShape{
	//The side of the square (major and minor axis)
	private int side;
	private boolean standardFlag = true;
	
	/**
	 * Creates a Square.
	 * @param x The display component's x position.
	 * @param y The display component's y position.
	 * @param vx The display component's x velocity.
	 * @param vy The display component's y velocity.
	 * @param width The width of the square (in pixels).
	 * @param height The height of the square (in pixels).
	 * @param colour The line colour or fill colour.
	 * @param isFilled True if the oval is filled with colour, false if opaque.
	 * @param flagPulseAlternate True if the square is pulse or alternate with other shape, false if is not.
	 */
	 public Square (int insertionTime, int x, int y, int vx, int vy, int side, Color colour, boolean isFilled, boolean flagPulseAlternate) {
	    	super (insertionTime, x, y, vx, vy, colour, isFilled,flagPulseAlternate);
	    	this.side = side;
	 }
	 
	 /**
	 * Method to convert an oval to a string.
	 */
	 public String toString () {
	    String result = "This is a square\n";
	    result += super.toString ();
	    result += "Its side is " + this.side + "\n";
	    return result;
	 }
	 
	 /**
	  * 
	  * @param side Resets the side.
	  */
	 public void setSide (int side) {
	      this.side = side;
	 }
	 
	 /**
	  * 
	  * @return the side of the square.
	  */
	 public int getSide() {
		  return side;
	 }
	 /**
	  * 
	  * @param side Resets the height
	  */
	 public void setHeight(int side) {
		 this.side = side;
	 }
	 
	 /**
	  * @return side of the square shape.
	  */
	 public int getHeight() {
		 return side;
	 }
	 
	 /**
	  * 
	  * @param side of the width.
	  */
	 public void setWidth(int side) {
		 this.side = side;
	 }
	 
	 /**
	  * @return side of the square shape.
	  */
	 public int getWidth() {
		 return side;
	 }
	 
	 
	 /**
	 * Draw the square on the screen.
	 * @param g The graphics object of the drawable component.
	 */
	 public void draw (GraphicsContext g) {
	    g.setFill( colour );
	    g.setStroke( colour );
	    if (isFilled) {
	    	g.fillRect( xPos, yPos, side, side);
	    } 
	    else {
	    	g.strokeRect( xPos, yPos, side, side);
		}
	 }
	 
	 /**
	  * A Method that stands out if the Square is pulse 
	  * or alternate with other shape.
	  */
	 public void pulseAlternateSize() {
		 	//The maximum number that size of the Square has.
	    	int bigSize = 135;
	    	//The minimum number that size of the Square has.
	    	int smallSize = 23;
	    	
	    	/**
			 * Compares the flagPulseAlternate and the standardFlag
			 * of the shape and if are true
			 * then increase the side of shape,
			 * and also checks if the side is to bigSize 
			 * and then equals the standardFlag as false.
			 */
	    	if((flagPulseAlternate == true) && (standardFlag == true)) {
	    		//increase the side by one
	    		side = side + 1;
	    		if ((side == bigSize)) {
	    		 standardFlag = false;
	    		} 
	    	}
	    	
	    	/**
	    	 * Compares the flagPulseAlternate and the standardFlag
	    	 * of the shape and if the statement is true 
	    	 * then decrease the side of shape,
	    	 * and also checks if the side is equal to smallSize 
	    	 * and then equals the standardFlag as true.
	    	 */
	    	else if ((flagPulseAlternate == true) && (standardFlag == false)) {
	    		//decrease the side by one
	    		side = side - 1;
	    		if (side == smallSize) {
	    			standardFlag = true;
	    		}
	    	}
	 }
}
