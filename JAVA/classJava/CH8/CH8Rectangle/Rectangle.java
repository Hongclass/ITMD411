/*
    Author: Hong Zhang
	Date: 02/24/2014
	File: Rectangle.java
	Descr:
	In-class exercise to create a class
	representing a rectangle.
*/

public class Rectangle {
    // data files
	private double height, width;
				   
	// constructor (no-arg or default)
	public Rectangle() {
	    height = 1.0;
		width = 1.0;
	}
	
	// parameterized constructor
	public Rectangle(double h, double w) {
	    height = h;
		width = w;
	}
	
	// mutator methods
	public void setHeight(double h){
	    height = h;
	}
	
	public void setWidth(double w){
	    width = w;
	}
	
	// accessor methods
	public double getHeight() {
	    return height;
	}
	
	public double getWidth() {
	    return width;
	}
	
	public double calcArea() {
	    return height * width;
	} 
	
	public double calcPerimeter() {
	    return 2 * (height + width);
	}
	
	public boolean isSqure() {
	    if (height - width < Math.abs(0.01))
		    return true;
		return false;
	}
	
} // end of Rectangle class