/*
    Flie: VarArgsDemo.java
	Author: Hong Zhang
	Date: 02/17/2014
	Descr:
	In-class exercise to demonstrate use of 
	variable length argument lists and arrays.
*/

public class VarArgsDemo {
    // main method to start program
	public static void main(String[] args){
	    String mantra = "go java go!";
		
	    // various calls to variable length parameter list
		printMin(mantra, new double[] {1, 2, 3});  // using anonymous array
		printMin(mantra, 34, 3, 3, 2, 56.5); // using variable number of arguments
		printMin(mantra); // no arguments
	} // end of method main
	
    // method to use variable length list and find minimum value
	public static void printMin(String msg, double...numbers){
	    
		// display passed message
		System.out.println(msg);
		
		// see if any values are passed
		if (numbers.length == 0) {
		    System.out.println("No Numbers passed");
			return;
		}
		
	    // initialize minimum
		double minValue = numbers[0];
		// check remaining elements to determine the minimum
		for(int i = 1; i < numbers.length; i++)
		    if(numbers[i] < minValue)
                minValue = numbers[i];
			
			// display minimum
			System.out.println("The minimum value is " + minValue);
	} // end of method printMin
	
} // end of class definition
