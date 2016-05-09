/*
    Author: Hong Zhang
	Date: 02/24/2014
	File: TestRectangle.java
	Descr:
	In-class exercise to create a class
	to test a rectangle class.
*/

public class TestRectangle {
    public static void main (String[] args){
	    // create instance of Rectangle class (aka object)
		Rectangle rec1 = new Rectangle();
		rec1.setHeight(2.0);
		rec1.setWidth (3.0);
		
		Rectangle rec2 = new Rectangle(4.0, 4.0);
		
		// display Rectangle characteristics
		printRectangle(rec1);
		printRectangle(rec2);
		
	} // end of main method
	
	// method to display passed Rectangle
	public static void printRectangle(Rectangle r) {
	    System.out.println("The area of a rectangle with higth " + 
		    r.getHeight() + " width and " + r.getWidth() +
			" is " + r.calcArea() + " with perimeter " +
			r.calcPerimeter());
	} // end of method printRectangle 

}  // end of TestRectangle class