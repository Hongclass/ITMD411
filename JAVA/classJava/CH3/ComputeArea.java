/*
  Name: Hong Zhang
  File: ComputeArea.java
  Date: 01/29/2014
  Descr:
  This program calculates and displays
  the area of a circle.
*/

import java.util.Scanner; // allow access to console input class

public class ComputeArea {
   public static void main(String[] args) {

        // declare constant to represent value of pi
        final double PI = 3.14159;  

        // create variable to refer to standard input (keyboard)  
        Scanner input = new Scanner(System.in);
     
        // prompt user for radius 
        System.out.print("Enter a number for radius: ");
        
       // declare variable to hold radius of circle
       // float radius = 2.5f; 
       float radius = input.nextFloat();

       // check to see jf radius is positive
       boolean isPos = (radius >= 0) ? true : false;
       
       if (radius >= 0) {
       //if (isPos) {

       // calculate area of circle
       double area = radius * radius * PI;

       System.out.println("Calculating the area of a circle");
       System.out.printf("\twith radius = %5.2f\n", radius); 
       System.out.printf("\thas area = %7.3f\n", area);
     }
     else 
       System.out.println("ERROR! Radius is negative!");       

  }
}

/*SAMPLE OUTPUT
E:\JAVA\classJava>java ComputeArea
Enter a number for radius: 2.5
Calculating the area of a circle
        with radius = 2.5
        has area = 19.6349375
*/