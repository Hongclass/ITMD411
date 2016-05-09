/*
  Name: Hong Zhang
  File: GUIComputeArea.java
  Date: 01/29/2014
  Descr:
  This program calculates and displays
  the area of a circle using GUI classes.
*/

import javax.swing.JOptionPane; // allow access to GUI class

public class GUIComputeArea {
   public static void main(String[] args) {

      // declare constant to represent value of pi
        final double PI = 3.14159;  
 
      // create string to hold returned input
      String radString = JOptionPane.showInputDialog(null, "Enter a number for radius");
      
      // convert string to floating point radius
      float radius = Float.parseFloat(radString);
  
      // calculate area of circle
       double area = radius * radius * PI; 

      // message variable to hold output
      String output = "the area of a circle with radius " + radius + " is " + area;

     // diaplay output dialog box
     JOptionPane.showMessageDialog(null, output);
   }
}    