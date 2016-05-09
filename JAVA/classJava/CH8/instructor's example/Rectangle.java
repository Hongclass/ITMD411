/*
  Author: Hong Zhang
  Date:   02/24/2014
  File:   Rectangle.java
  Descr:
  In-class exercise to create a class
  representing a rectangle.
*/

public class Rectangle {
	// data fields
	private double height, width;
	private java.util.Date dateCreated;
	
	// static variable to keep track of number of objects created
	static int numOfObjects = 0;
		
	// constructor  (no-arg or default)
	public Rectangle() {
		height = 1.0;
		width = 1.0;
		numOfObjects++;
		dateCreated = new java.util.Date();
	}
	
	// parameterized constructor
	public Rectangle(double h, double w) {
		height = h;
		width = w;
		numOfObjects++;
		dateCreated = new java.util.Date();
	}
	
	// method to return the number of objects created
	public static int getNumOfObjects() {
	    return numOfObjects;
	}
	
	// mutator methods
	public void setHeight(double h) {
		height = h;
	}
	
	public void setWidth(double w) {
		width = w;
	}
	
	// accessor methods
	public double getHeight() {
		return height;
	}
	
	public double getWidth() {
		return width;
	}
	
	public java.util.Date getDateCreated() {
	    return dateCreated;
	}
	
	public double calcArea() {
		return height * width;
	}
	
	public double calcPerimeter() {
		return 2 * (height + width);
	}
	
	public boolean isSquare() {
		if (height - width < Math.abs(0.01))
			return true;
		return false;
	}	
} // end of class