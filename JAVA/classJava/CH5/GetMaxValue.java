/*
    Author: Hong Zhang
	File:   GetMaxValue.java
	Date:   02/10/2014
	Descr:  
	Sample in-class program to demonstrate
	use of methods for a problem to determine
	the maximum number of tow input values.
*/

public class GetMaxValue {

    /** main method*/
	public static void main(String[] args) {
	    // create scanner object to get input from console
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		// read first value
		System.out.print("Enter an integer value to compare: ");
		int first =input.nextInt();
		
		// read second value
		System.out.print("Enter next integer value to compare: ");
		int second = input.nextInt();
	    
        //get the maximum vlae
        int maxValue = max(first, second);
        
        // display the maxmum value
        dispMaxVal(maxValue);

        // close input stream
        input.close();  		
	
    } // end of main method
	
	/** return maximum value of tow input integers */
	public static int max(int num1, int num2) {
	    int result;
		if (num1 > num2)
		    result = num1;
		else 
		    result = num2;
			
		return result;
	}
	
	/** display passed value */
	public static void dispMaxVal(int mVal) {
	    System.out.printf("The maximum input value is %d\n", mVal);
	}
	
}  // end of class	
	