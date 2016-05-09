/*
  Author: 
  Date:   02/24/2014
  File:   TestRectangle.java
  Descr:
  In-class exercise to create a class
  to test the rectangle class.
*/

public class TestRectangle {
	public static void main(String[] args) {
	
	    System.out.println("Number of Rectangle objects = " + Rectangle.getNumOfObjects());
		// create instance of Rectangle class (aka object)
		Rectangle rec1 = new Rectangle();
		rec1.setHeight(2.0);
		rec1.setWidth(3.0);
		// display number of objects
		System.out.println("Number of Rectangle objects = " + rec1.getNumOfObjects());
		Rectangle rec2 = new Rectangle(4.0, 4.0);
		// display number of objects
		System.out.println("Number of Rectangle objects = " + rec2.getNumOfObjects());
		// creat array of Rectangle objects
		Rectangle[] recArray = new Rectangle[3];
		// add pbkects to array
		recArray[0] = rec1;
		recArray[1] = rec2;
		recArray[2] = new Rectangle(6.0, 5.0);
		
		// display all Rectangles in array
		for(int i = 0; i < recArray.length; i++)
		    printRectangle(recArray[i]);
		
		// display Rectangle characteristics
		//printRectangle(rec1);
		//printRectangle(rec2);
	
	} // end of main method
	
	// method to display passed Rectangle
	public static void printRectangle(Rectangle r) {
		System.out.println("The area of a rectangle with height " +
			r.getHeight() + " and width " + r.getWidth() +
			" is " + r.calcArea() + " with perimeter " + 
			r.calcPerimeter());
		System.out.printf("\tCreated: %tD\n", r.getDateCreated());
	} // end of method printRectangle

} // end of TestRectangle class