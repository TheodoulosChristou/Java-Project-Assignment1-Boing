import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
*
* Rectangle is a rectangle shape that can be drawn to the screen, either
* filled with colour or opaque.
* Its position is determined by the upper left corner of the
* rectangle's bounding rectangle
*/
public class Rect extends ClosedShape{
	//The width and height of the oval (major and minor axis)
	private int width;
	private int height;
	private boolean standardFlag = true;
	
	/**
	 * Creates a Rectangle.
	 * @param x The display component's x position.
	 * @param y The display component's y position.
	 * @param vx The display component's x velocity.
	 * @param vy The display component's y velocity.
	 * @param width The width of the rectangle (in pixels).
	 * @param height The height of the rectangle (in pixels).
	 * @param colour The line colour or fill colour.
	 * @param isFilled True if the oval is filled with colour, false if opaque.
	 * @param flagPulseAlternate True if the rectangle is pulse or alternate with other shape, false if is not.
	 */
	 public Rect (int insertionTime, int x, int y, int vx, int vy, int width, int height, Color colour, boolean isFilled,boolean flagPulseAlternate) {
	    super (insertionTime, x, y, vx, vy, colour, isFilled,flagPulseAlternate);
	    this.width = width;
	    this.height = height;
	}
	
	 /**
	  * Method to convert a rectangle to a string.
	  */
	public String toString () {
	    String result = "This is a rect\n";
	    result += super.toString ();
	    result += "Its width is " + this.width + "\n" + "It's height is" + this.height + "\n";
	    return result;
	}
	 
	/**
	 * @param width Resets the width.
	 */
	public void setWidth(int width) { 
		this.width = width;
	 }
	 
	/**
 	 * @return The width of the rectangle shape.
 	 */
	 public int getWidth() {
		 return width;
	 }
	 
	 /**
	  * 
	  * @param height Resets the height.
	  */
	 public void setHeight(int height) {
		 this.height = height;
	 }
	 
	 /**
	  * @return The height of the rectangle shape.
	  */
	 public int getHeight() {
		 return height;
	 }
	 
	 /**
	  * Draw the rectangle on the screen .
	  * @param g The graphics object of the drawable component.
	  */
	 public void draw (GraphicsContext g) {
	    g.setFill( colour );
	    g.setStroke( colour );
	    if (isFilled) {
	    	g.fillRect( xPos, yPos,width,height);
	    } 
	    else {
	    	g.strokeRect( xPos, yPos,width, height);
		}
	}
	 
	 /**
	  * A Method that stands out if the Rectangle is pulse 
	  * or alternate with other shape.
	  */
	  public void pulseAlternateSize() {
		  //The maximum number that size of the Rectangle has.
		  int bigSize = 135;
		  //The minimum number that size of the Rectangle has.
		  int smallSize = 23;
	    	
		  /**
		   * Compares the flagPulseAlternate and the standardFlag
		   * of the shape and if are true
		   * then increase the height and width of shape,
		   * and also checks if the width or height are equal to bigSize 
		   * and then equals the standardFlag as false.
		   */
	    	if((flagPulseAlternate == true) && (standardFlag == true)) {
	    		//increase the width and height of the shape.
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
	    		//decrease the width and height of the shape.
	    		height = height - 1;
	    		width = width -1;
	    		if ((height == smallSize) || (width == smallSize)) {
	    			standardFlag = true;
	    		}
	    	}
	 }
}
