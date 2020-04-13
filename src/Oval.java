
/**
 * Oval.java
 * @version 2.0.0
 * Originally written by Bette Bultena but heavily modified for the purposes of 
 * CSC-115 (Daniel Archambault and Liam O'Reilly)
 */

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * Oval is an oval shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by the upper left corner of the
 * oval's bounding rectangle
 */
public class Oval extends ClosedShape {
	//The width and height of the oval (major and minor axis)
	private int width, height;
	private boolean standardFlag = true;
	/**
	 * Creates an oval.
	 * @param x The display component's x position.
	 * @param y The display component's y position.
	 * @param vx The display component's x velocity.
	 * @param vy The display component's y velocity.
	 * @param width The width of the oval (in pixels).
	 * @param height The height of the oval (in pixels).
	 * @param colour The line colour or fill colour.
	 * @param isFilled True if the oval is filled with colour, false if opaque.
	 * @param flagPulseAlternate True if the oval is pulse or alternate with other shape, false if is not.
	 */
	public Oval (int insertionTime, int x, int y, int vx, int vy, int width, int height, Color colour, boolean isFilled, boolean flagPulseAlternate) {
		super (insertionTime, x, y, vx, vy, colour, isFilled,flagPulseAlternate);
		this.width = width;
		this.height = height;
	}

	/**
     * Method to convert an oval to a string.
     */
    public String toString () {
    	String result = "This is an oval\n";
    	result += super.toString ();
    	result += "Its width is " + this.width + " and its height is " + this.height + "\n";
    	return result;
    }

	/**
	 * @param width Resets the width.
	 */
 	public void setWidth (int width) {
		this.width = width;
	}

 	/**
 	 * @param height Resets the height.
 	 */
 	public void setHeight (int height) {
		this.height = height;
	}

 	/**
 	 * @return The width of the oval.
 	 */
 	public int getWidth() {
		return width;
	}

 	/**
 	 * @return The height of the oval.
 	 */
 	public int getHeight() {
		return height;
	}

 	/**
 	 * Draw the oval.
 	 * @param g The graphics object of the drawable component.
 	 */
	public void draw (GraphicsContext g) {
		g.setFill (colour);
		g.setStroke( colour );
		if (isFilled) {
			g.fillOval( xPos, yPos, width, height);
		} 
		else {
			g.strokeOval( xPos, yPos, width, height);
		}
	}
	
	/**
	 * A Method that stands out if the Oval is pulse 
	 * or alternate with other shape.
	 */
	 public void pulseAlternateSize() {
			//The maximum number that size of the Oval has.
	    	int bigSize = 135;
		    //The minimum number that size of the Oval has.
	    	int smallSize = 23;
	    	
	    	/**
	    	 * Compares the flagPulseAlternate and the standardFlag
	    	 * of the shape and if are true
	    	 * then increase the heght and width of shape,
	    	 * and also checks if the width or height are equal to bigSize 
	    	 * and then equals the standardFlag as false.
	    	 */
	    	if((flagPulseAlternate == true) && (standardFlag == true)) {
	    		//increase the height and width by one.
	    		height = height + 1;
	    		width = width + 1 ;
	    		if ((height == bigSize) || (width == bigSize)) {
	    		 standardFlag = false;
	    		} 
	    	}
	    	
	    	/**
	    	 * Compares the flagPulseAlternate and the standardFlag
	    	 * of the shape and if the statement is true 
	    	 * then decrease the height and width of shape,
	    	 * and also checks if the width or height are equal to smallSize 
	    	 * and then equals the standardFlag as true.
	    	 */
	    	else if ((flagPulseAlternate == true) && (standardFlag == false) ) {
	    		//decrease the width and height by one
	    		height = height - 1;
	    		width = width - 1;
	    		if ((height == smallSize) || (width == smallSize)) {
	    			standardFlag = true;
	    		}
	    	}
}
}
