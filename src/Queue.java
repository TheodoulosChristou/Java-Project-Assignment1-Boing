
/**
 * 
 * A class that implements a queue.  It is your job to complete this class.  Your queue
 * will use a linked list constructed by LinkedListElements.  However, your queue must be general and allow
 * setting of any type of Object.  Also you cannot use ArrayLists or arrays (you will get zero).  
 * @author you
 *
 */


import java.util.NoSuchElementException;
	

public class Queue {
	//TODO:  You need some data to store the queue.  Put the attributes here.
	/**
	 * We create two objects From class QueueElement
	 * The first value is top which is the head of queue.
	 * The second value is the last which is the tail of queue.
	 */
	 private QueueElement  top;
	 private QueueElement  last;
	 
	/**
	 * Constructs an empty Queue.
	 */
	public Queue () {
	    //TODO: Write the Queue constructor
		/**
		 * We put top and last equals null 
		 * to test if the queue is empty.
		 */
		top = null;
		last = null; 
	}
	
	/**
	 * Returns true if the queue is empty
	 */
	public boolean isEmpty () {
	    //TODO:  Needs to return true when empty and false otherwise
		if (top == null) {
			/*if the queue is empty then returns true*/
			return true;
		}
		else
		{
			/* if the queue isn't empty then returns false*/
			return false;
		}
	}
	
	
	/**
	 * Returns the element at the head of the queue
	 */
	public Object peek () throws NoSuchElementException {
		if (isEmpty()) {
			/*it checks if the queue is empty */
			throw new NoSuchElementException("Empty queue");
		}
		else {
			/* IF it's not then it gets the next element
			 	and continue with the queue. */
			return top.getElement();//DELETE AND CHANGE TO SOMETHING SENSIBLE
		}
	}
	
	/**
	 * Removes the front element of the queue
	 */
	public void dequeue () throws NoSuchElementException {
	    //Dequeue code is needed here
		if (top == null) {
			/* it checks if the queue is empty */
			throw new NoSuchElementException("Empty Queue");
		}
		else if (top == last)
		{
			/* if the top equals to the last 
			 * then it gets the next element 
			 * and creates a new object which
			 * top gets.
			 */
			last = null ;
			QueueElement elementsOfQueue = top;
			top = elementsOfQueue.getNext();
		}
		else 
		{
			/* it gets the next element 
			 * and creates a new object which
			 * top gets.
			 */
			QueueElement queueElements = top;
			top = queueElements.getNext();
		}
		
	}
	
	/**
	 * Puts an element on the back of the queue.
	 */
	public void enqueue (Object element) {
	    //Enqueue code is needed here
		if (isEmpty()) 
		{
			/* checks if the queue is empty */
			last =  new QueueElement(element , null);
			top = last;
		}
		else 
		{
			/* the last gets the previous element
			 * and the previous element gets the next element
			 * which is the last of the queue.
			 * 
			 */
			QueueElement prev = last;
			last =  new QueueElement(element , null);
			prev.setNext(last);
		}	
	}
	
	/**
	 * Method to print the full contents of the queue in order from head to tail.
	 */
	public void print () {
	    //Code to print the code is needed here
		String a = "";
		if(isEmpty()){
			/* checks if the queue is empty */
			System.out.print("The queue is empty.");
		}
		QueueElement elementOfQueue = top;
		while(elementOfQueue != null) {
			/* we create object which represent all the elements
			 * and gets all the elements and
			 * then we print all the elements of the queue outside
			 * of the while loop.
			 */
			a = a + elementOfQueue.getElement() +"," +" \n";
			elementOfQueue = elementOfQueue.getNext();
		}
			System.out.println(a);	
	}
}
	
