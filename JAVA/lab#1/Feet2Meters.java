/*
      
      Name:  Hong Zhang
      File:  Feet2Meters.java
      Date:  01/29/2014
      Class: CIS 2571
      Assignment: Lab#1-4
      Descr:
      This application program converting feet into meters.
*/

public class Feet2Meters { 
   public static void main(String[] args) { 
      // Enter foot 
      java.util.Scanner input = new java.util.Scanner(System.in); 
      System.out.print("Enter a value for feet: "); 
      double feet = input.nextDouble(); 
      double meter = feet * 0.305; 
      System.out.println(feet + " feet is " + meter + " meters"); 
   } 
}

/*
Sample output:

I:\JAVA\classJava>notepad Feet2Meters.java

I:\JAVA\classJava>javac Feet2Meters.java

I:\JAVA\classJava>java Feet2Meters
Enter a value for feet: 11
11.0 feet is 3.355 meters

I:\JAVA\classJava>
*/