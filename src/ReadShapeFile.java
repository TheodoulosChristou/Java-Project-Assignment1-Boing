
/**
 * This class reads a shape file.  For the format of this shape file, see the assignment description.
 * Also, please see the shape files ExampleShapes.txt, ExampleShapesStill.txt, and TwoRedCircles.txt
 *
 * @author you
 *
 */

import javafx.scene.paint.Color;
import java.io.*;
import java.util.Scanner;

public class ReadShapeFile {

	// TODO: You will likely need to write four methods here. One method to
	// construct each shape
	// given the Scanner passed as a parameter. I would suggest static
	// methods in this case.   

	/**
	 * Reads the data file used by the program and returns the constructed queue
	 *   
	 * @param in
	 *            the scanner of the file.
	 * @return the queue represented by the data file
	 */
	private static Queue readDataFile(Scanner in) {
			Queue shapeQueue = new Queue();
			
			//This loop reads the lines and
			//stands out the filename of the shape.
			while(in.hasNextLine()) {
				
				//Reads the first line of the shape
				String currentline = in.nextLine();
				
				//Reads all the lines 
				Scanner shapeLine = new Scanner(currentline);
				
				//Recognise the name shape
				String nameShape = shapeLine.next();
				
				// A switch that stands out the file of the shape
				// and returns the ShapeQueue.
				switch(nameShape) {
			    	
			 		case "circle": {
			 			shapeQueue.enqueue(nCircle(shapeLine));
			 			break;
			 		}
			 	
			 		case "oval": {
			 			shapeQueue.enqueue(nOval(shapeLine));
			 			break; 
			 		} 
			    
			 		case "square": {
			 			shapeQueue.enqueue(nSquare(shapeLine));
			 			break;
			 		}
			    
			 		case "rect": {
			 			shapeQueue.enqueue(nRectangle(shapeLine));
			 			break;
			 		}
			    	
			 		case "message":{
			 			shapeQueue.enqueue(nMessage(shapeLine));
			 			break;
			 		}
				}
	      }
		  return shapeQueue;
	}




	/**
	 * Method to read the file and return a queue of shapes from this file. The
	 * program should handle the file not found exception here and shut down the
	 * program gracefully.
	 * 
	 * @param filename
	 *            the name of the file
	 * @return the queue of shapes from the file
	 */
	public static Queue readFile(String filename) {
	    // HINT: You might want to open a file here.
		//null is not sensible. Please change
	    Scanner in = null;
	    try {
	    	in = new Scanner(new File(filename));
	    } 
	    catch (FileNotFoundException e1) {
			System.out.println("File not found");
		}
	    return ReadShapeFile.readDataFile(in);

	}
	
	/**
	 * This method reads the Circle shape from the constructor of the 
	 * Circle Class.
	 * @param shapeLine represents the Scanner of the filename of shape.
	 * @return newCircle
	 */
	public static Circle nCircle(Scanner shapeLine){
		
		/**  
	     * @param px The display component's x position.
	     * @param py The display component's y position.
	     * @param vx The display component's x velocity.
	     * @param vy The display component's y velocity.
	     * @param diameter The diameter of the Circle shape.
	     * @param r The line colour or fill colour.
	     * @param g The line colour or fill colour.
	     * @param b The line colour or fill colour.
	     * @param isFilled True if the circle is filled with colour, false if opaque.
	     * @param flagPulseAlternate True if the Circle is pulse or alternate with other shape, false if is not.
	     * @param insertionTime is the time that this shape is in the area.
	     */
		   int px = shapeLine.nextInt();
		   int py = shapeLine.nextInt();
		   int vx = shapeLine.nextInt();
		   int vy = shapeLine.nextInt();
		   boolean filled = shapeLine.nextBoolean();
		   int diameter = shapeLine.nextInt();
		   int r = shapeLine.nextInt();
		   int g = shapeLine.nextInt();
		   int b = shapeLine.nextInt();
		   int insertionTime = shapeLine.nextInt();
		   boolean flagPulseAlternate = shapeLine.nextBoolean();
		   Color newColour = Color.rgb(r,g,b);
		   Circle newCircle = new Circle(insertionTime,px,py,vx,vy,diameter,newColour,filled,flagPulseAlternate);
		   return newCircle;
	}
	
	/**
	 * This method reads the Oval shape from the constructor of the 
	 * Oval Class.
	 * @param shapeLine represents the Scanner of the filename of shape.
	 * @return newOval
	 */
	public static Oval nOval(Scanner shapeLine) {
		
		/**  
	     * @param px The display component's x position.
	     * @param py The display component's y position.
	     * @param vx The display component's x velocity.
	     * @param vy The display component's y velocity.
	     * @param width The width of the Oval Shape.
	     * @param height The height of the Oval shape.
	     * @param r The line colour or fill colour.
	     * @param g The line colour or fill colour.
	     * @param b The line colour or fill colour.
	     * @param isFilled True if the circle is filled with colour, false if opaque.
	     * @param flagPulseAlternate True if the Oval is pulse or alternate with other shape, false if is not.
	     * @param insertionTime is the time that this shape is in the area.
	     */
			int px = shapeLine.nextInt();
			int py = shapeLine.nextInt();
			int vx = shapeLine.nextInt();
			int vy = shapeLine.nextInt();
			boolean filled = shapeLine.nextBoolean();
			int width = shapeLine.nextInt();  
			int height = shapeLine.nextInt();
			int r = shapeLine.nextInt();
			int g = shapeLine.nextInt();
			int  b = shapeLine.nextInt();
			int insertionTime = shapeLine.nextInt();
			boolean flagPulseAlternate = shapeLine.nextBoolean();
			Color newColour = Color.rgb(r, g, b);
			Oval newOval = new Oval(insertionTime,px,py,vx,vy,width,height,newColour,filled,flagPulseAlternate);
			return newOval;
	}
	
	/**
	 * This method reads the Square shape from the constructor of the 
	 * Square Class.
	 * @param shapeLine represents the Scanner of the filename of shape.
	 * @return newSquare
	 */
	public static Square nSquare(Scanner shapeLine) {
		
		/**  
	     * @param px The display component's x position.
	     * @param py The display component's y position.
	     * @param vx The display component's x velocity.
	     * @param vy The display component's y velocity.
	     * @param side The side of the Square shape.
	     * @param r The line colour or fill colour.
	     * @param g The line colour or fill colour.
	     * @param b The line colour or fill colour.
	     * @param isFilled True if the circle is filled with colour, false if opaque.
	     * @param flagPulseAlternate True if the Square is pulse or alternate with other shape, false if is not.
	     * @param insertionTime is the time that this shape is in the area.
	     */
		 	int px = shapeLine.nextInt();
		 	int py = shapeLine.nextInt();
		 	int vx = shapeLine.nextInt();
		 	int vy = shapeLine.nextInt();
		 	boolean filled = shapeLine.nextBoolean();
		 	int side = shapeLine.nextInt();
		 	int r = shapeLine.nextInt();
		 	int g = shapeLine.nextInt();
		 	int b = shapeLine.nextInt();
		 	int insertionTime = shapeLine.nextInt();
			boolean flagPulseAlternate = shapeLine.nextBoolean();
		 	Color newColour = Color.rgb(r, g, b);
		 	Square newSquare = new Square(insertionTime,px,py,vx,vy,side,newColour,filled, flagPulseAlternate);
		 	return newSquare;
	}
	
	
	/**
	 * This method reads the Rectangle shape from the constructor of the 
	 * Rectangle Class.
	 * @param shapeLine represents the Scanner of the filename of shape.
	 * @return newRect
	 */
	public static Rect nRectangle(Scanner shapeLine) {
		
		/**  
	     * @param px The display component's x position.
	     * @param py The display component's y position.
	     * @param vx The display component's x velocity.
	     * @param vy The display component's y velocity.
	     * @param width The width of the Rectangle shape.
	     * @param height The height of the Rectangle shape.
	     * @param r The line colour or fill colour.
	     * @param g The line colour or fill colour.
	     * @param b The line colour or fill colour.
	     * @param isFilled True if the circle is filled with colour, false if opaque.
	     * @param flagPulseAlternate True if the Rectangle is pulse or alternate with other shape, false if is not.
	     * @param insertionTime is the time that this shape is in the area.
	     */
			int px = shapeLine.nextInt();
			int py = shapeLine.nextInt();
			int vx = shapeLine.nextInt();
			int vy = shapeLine.nextInt();
			boolean filled = shapeLine.nextBoolean();
			int width = shapeLine.nextInt();
			int height = shapeLine.nextInt();
			int r = shapeLine.nextInt();
			int g = shapeLine.nextInt();
			int b = shapeLine.nextInt();
			int insertionTime = shapeLine.nextInt();
			boolean flagPulseAlternate = shapeLine.nextBoolean();
			Color newColour = Color.rgb(r, g, b);
			Rect newRect = new Rect(insertionTime,px,py,vx,vy,width,height,newColour,filled, flagPulseAlternate);
			return newRect;
	}
	
	
	/**
	 * This method reads the Message shape from the constructor of the 
	 * Message Class.
	 * @param shapeLine represents the Scanner of the filename of shape.
	 * @return newM
	 */
	public static Message nMessage(Scanner shapeLine) {
		
		/**  
	     * @param px The display component's x position.
	     * @param py The display component's y position.
	     * @param vx The display component's x velocity.
	     * @param vy The display component's y velocity.
	     * @param width The width of the Message shape.
	     * @param height The height of the Message shape.
	     * @param r The line colour or fill colour.
	     * @param g The line colour or fill colour.
	     * @param b The line colour or fill colour.
	     * @param isFilled True if the Message shape is filled with colour, false if opaque.
	     * @param flagPulseAlternate True if the Message shape is pulse or alternate with other shape, false if is not.
	     * @param insertionTime is the time that this shape is in the area.
	     */
		   	int px = shapeLine.nextInt();
		   	int py = shapeLine.nextInt();
		   	int vx = shapeLine.nextInt();
			int vy = shapeLine.nextInt();
			boolean filled = shapeLine.nextBoolean();
			int width = shapeLine.nextInt();
			int height = shapeLine.nextInt();
			String message = shapeLine.next();
			int r = shapeLine.nextInt();
			int g = shapeLine.nextInt();
			int b = shapeLine.nextInt();
			int insertionTime = shapeLine.nextInt();		  
			boolean flagPulseAlternate = shapeLine.nextBoolean();
			Color newColour = Color.rgb(r, g, b);
			Message newM = new Message(insertionTime,px,py,vx,vy,width,height,message, newColour,filled,flagPulseAlternate);
			return newM;
	}	
}

	