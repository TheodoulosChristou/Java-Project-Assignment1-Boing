import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
*
* Message is a message/text shape that can be drawn to the screen, either
* filled with colour or opaque.
* Its position is determined by the upper left corner of the
* message's bounding rectangle.
*/
public class Message extends ClosedShape {
	//The width height and message of the message (major and minor axis)
	private String message;
	private int width;
	private int height;
	private boolean standardFlag = true;
	//The font that the messages shapes should have 
	//and the size of it.
	private int sizeOfFont = 20;
	Font font1 = new Font("Verdana", sizeOfFont);
	
	/**
	 * Creates messages.
	 * @param x The display component's x position.
	 * @param y The display component's y position.
	 * @param vx The display component's x velocity.
	 * @param vy The display component's y velocity.
	 * @param width The width of the messages (in pixels).
	 * @param height The height of the messages (in pixels).
	 * @param colour The line colour or fill colour.
	 * @param isFilled True if the oval is filled with colour, false if opaque.
	 * @param flagPulseAlternate True if the message shape is pulse or alternate with other shape, false if is not.
	 */
	 public Message (int insertionTime, int x, int y, int vx, int vy, int width, int height, String message, Color colour, boolean isFilled, boolean flagPulseAlternate) {
	    super (insertionTime, x, y, vx, vy, colour, isFilled,flagPulseAlternate);
	    this.width = width;
	    this.height = height;
	    this.message = message;
	}
	
	 /**
	  * Method to convert a rectangle to a string.
	  */
	public String toString () {
	    String result = "This is a message\n";
	    result += super.toString ();
	    result += "The message is " + this.message + "\n";
	    return result;
	 }
	 
	/**
	 * 
	 * @param width Resets the width.
	 */
	 public void setWidth(int width) {
		 this.width = width;
	 }
	 
	 /**
	  * 
	  * @param message Resets the message.
	  */
	 public void setMessage (String message) {
	    this.message = message;
	 }
	 
	 /**
	  * 
	  * @param height Resets the height.
	  */
	 public void setHeight(int height) {
		 this.height = height;
	 }
	 
	 /**
	  * 
	  * @return message of the message shape.
	  */
	 public String getMessage() {
		 return message;
	 }
	 
	 /**
	  * @return width of the message shape.
	  */
	 public int getWidth() {
		 return width;
	 }
	 
	 /**
	  * @return height of the message shape.
	  */
	 public int getHeight() {
		return height;
	 }
	 
	 /**
	  * Draw the message shape on the screen.
	  * @param g The graphics object of the drawable component.
	  */
	 public void draw (GraphicsContext g) {
	    g.setFill( colour );
	    g.setStroke( colour );
	    g.setFont(font1);
	    if (isFilled) {
	    	g.fillText( message,xPos,yPos+70);
	    } 
	    else {
	    	g.strokeText( message ,xPos,yPos+70);
	    }
	}
	
	/**
	 * A Method that stands out if the message Shape is pulse 
	 * or alternate with other shape.
	 */
	public void pulseAlternateSize() {
		//The maximum number that size of the Message Shape has.
	    int bigSize = 135;
	    //The minimum number that size of the Message Shape has.
	    int smallSize = 23;
	    
	    /**
    	 * Compares the flagPulseAlternate and the standardFlag
    	 * of the shape and if are true
    	 * then increase the sizeOfFont
    	 * and also checks if the sizeOfFont is equal to bigSize 
    	 * and then equals the standardFlag as false.
    	 */
	    if((flagPulseAlternate == true) && (standardFlag == true)) {
	    	//increase the sizeOfFont by one
		   sizeOfFont = sizeOfFont + 1;
		   if (sizeOfFont == bigSize) {
	    	 standardFlag = false;
		   } 
	    }
	    
	    /**
    	 * Compares the flagPulseAlternate and the standardFlag
    	 * of the shape and if the statement is true 
    	 * then decrease the sizeOfFont
    	 * and also checks if the sizeOfFont is equal to smallSize 
    	 * and then equals the standardFlag as true.
    	 * 
    	 */
	    else if ((flagPulseAlternate == true) && (standardFlag == false)) {
	    	// decrease the sizeOfFont by one.
	    	sizeOfFont = sizeOfFont - 1;
	    	if (sizeOfFont == smallSize) {
	    	standardFlag = true;
		  }
	    }
	   	font1 = new Font("Verdana", sizeOfFont);
	}
}