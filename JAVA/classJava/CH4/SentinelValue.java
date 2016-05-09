/*
  Name: Hong Zhang
  File: SentinelValue.java
  Date: 02/05/2014
  Descr:
  This program sums up all input
  integers until the sentinel value 
  of 0 is input.
*/

import java.util.Scanner;

public class SentinelValue {
    /** main method **/
	public static void main(String[] args) {
	
	    // create link to console
		Scanner input = new Scanner(System.in);
		
		// read in initial data
	 //   System.out.print("Enter an integer value (program exits if value is 0): ");
		int data = input.nextInt();
		
		// keep sum of all entered numbers
		int sum = 0;
		
		/*
		while (data != 0) {
		    sum += data;
			// read the next data item
			System.out.print("Enter an integer value (program exits if value is 0): ");
		    data = input.nextInt();
		}
		*/
		
		// using a 'do-while' loop
		/*do {
		    // prevent addition of sentinel value and loop continuation
			if (data == 0)
			    break;
			sum += data;
			// read next data item
			System.out.print("Enter an integer value (program exits if value is 0): ");
		    data = input.nextInt();
		} while (data != 0);
		*/
		
		// using a 'for' loop
		for(; data != 0;) {
		        sum += data;
			// read the next data item
		//	System.out.print("Enter an integer value (program exits if value is 0): ");
		    data = input.nextInt();
		}
		
		// output the sum of all numbers
		System.out.println("The sum is " + sum);
		}
	}
		