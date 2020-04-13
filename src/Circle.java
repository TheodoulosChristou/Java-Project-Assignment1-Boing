
/**
 * Circle.java
 * @version 2.0.0
 * Originally written by Bette Bultena but heavily modified for the purposes of 
 * CSC-115 (Daniel Archambault and Liam O’Reilly)
 */

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/**
 * Circle is a shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by the upper left corner of
 * the circle's bounding rectangle.
 */

public class Circle extends ClosedShape {
    //The diameter of the circle.
	private int diameter;
	//The flag that represents the standard shape.
	private boolean standardFlag = true;
	

    /**
     * Creates a circle.
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param diameter The diameter of the circle.
     * @param colour The line colour or fill colour.
     * @param isFilled True if the circle is filled with colour, false if opaque.
     * @param flagPulseAlternate True if the circle is pulse or alternate with other shape, false if is not.
     */
    public Circle (int insertionTime, int x, int y, int vx, int vy, int diameter, Color colour, boolean isFilled,boolean flagPulseAlternate) {
    	super (insertionTime, x, y, vx, vy, colour, isFilled,flagPulseAlternate);
    	this.diameter = diameter;
    }
    
    
    /**
     * Method to convert a circle to a string.
     */
    public String toString () {
    	String result = "This is a circle\n";
    	result += super.toString ();
    	result += "Its diameter is " + this.diameter + "\n";
    	return result;
    }
    
    
    /**
     * @param Resets the diameter.
     */
    public void setDiameter (int diameter) {
    	this.diameter = diameter;
    }
    
    
    /**
     * @return The diameter of the circle.
     */
    public int getDiameter() {
    	return diameter;
    }

    
    /**
     * @return The width of the circle
     */
 	public int getWidth() {
		return diameter;
	}
 	
 	
 	/**
 	 * @return The height of the circle
 	 */
 	public int getHeight() {
		return diameter;
	}
    
 	
    /**
     * Draw the circle on the screen.
     * @param g The graphics object of the scene component.
     */
    public void draw (GraphicsContext g) {
    	g.setFill( colour );
    	g.setStroke( colour );
    	if (isFilled) {
    		g.fillOval( xPos, yPos, diameter, diameter );
    	} 
    	else {
    		g.strokeOval( xPos, yPos, diameter, diameter );
	    }
    }
    
    
    /**
     * A Method that stands out if the circle is pulse 
     * or alternate with other shape.
     */
    public void pulseAlternateSize() {
    	//The maximum number that size of the Circle has.
    	int bigSize = 135;
    	//The minimum number that size of the Circle has.
    	int smallSize = 23;
    	
    	/**
    	 * Compares the flagPulseAlternate and the standardFlag
    	 * of the shape and if are true then increase the diameter
    	 * and also checks if the diameter is equal to bigSize 
    	 * and then equals the standardFlag as false.
    	 */
    	if ((flagPulseAlternate == true) && (standardFlag == true)) {
    		//increase the diameter by one
    		diameter = diameter + 1;
    		if (diameter == bigSize) {
    		 standardFlag = false;
    		} 
    	}
    	
    	
    	/**
    	 * Compares the flagPulseAlternate and the standardFlag
    	 * of the shape and if the statement is true 
    	 * then decrease the diameter 
    	 * and also checks if the diameter is equal to smallSize 
    	 * and then equals the standardFlag as true.
    	 * 
    	 */
    	else if ((flagPulseAlternate == true) && (standardFlag == false)) {
    		//decrease the diameter by one.
    		diameter = diameter - 1;
    		if (diameter == smallSize) {
    			standardFlag = true;
    		}
    	}
    }
}

