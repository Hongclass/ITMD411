/*  
   Name:   Hong Zhang
   File:   MyTriangle.java
   Date:   02/17/3014
   Class:  CIS2571-001
   Descr:
   This program let user to input three sides for a triangle 
   and computes the area if the input is valid. Otherwise, 
   it displays that the input is invalid. 
*/

import java.util.Scanner;

public class MyTriangle {

    public static void main (String[] args) {
	Scanner input = new Scanner(System.in);
    System.out.print("Input side1: ");
    double side1 = input.nextDouble();
    System.out.print("Input side2: ");
    double side2 = input.nextDouble();
    System.out.print("Input side3: ");
    double side3 = input.nextDouble();
	System.out.println("          Input         Output ");
	System.out.println("side1  side2  side3  isValid  area ");
	
	if (isValid(side1, side2, side3))
	    System.out.printf("%3.2f %6.2f %6.2f       Y   %7.6f ", side1, side2, side3, area(side1, side2, side3));
    else
        System.out.printf("%3.2f %6.2f %6.2f       N", side1, side2, side3);
	}
	
    public static boolean isValid(double side1, double side2, double side3) {
        boolean tri = true;
        // Find longest side
        double longSide = side1;
        if (side2 > longSide) 
		    longSide = side2;
        if (side3 > longSide) 
		    longSide = side3;
        // Check if the two shorter sides do add up to the length of the longest side.
        if (side1 + side2 + side3 - longSide <= longSide)
        tri = false;
        return tri;
    }
	
    public static double area(double side1, double side2, double side3) {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }
}

/*Sample Output:
Input side1: 5.6
Input side2: 3.2
Input side3: 1.1
          Input          Output 
side1  side2  side3  isValid  area 
5.60   3.20   1.10       N

Input side1: 5.6
Input side2: 3.2
Input side3: 4.2
          Input          Output 
side1  side2  side3  isValid  area 
5.60   3.20   4.20       Y    6.663445

Input side1: 10.5
Input side2: 20.3
Input side3: 15.75
          Input           Output 
side1  side2  side3  isValid  area 
10.50  20.30  15.75      Y    81.587201
*/

