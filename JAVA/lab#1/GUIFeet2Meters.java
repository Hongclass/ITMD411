/*
      
      Name:  Hong Zhang
      File:  GUIFeet2Meters.java
      Date:  01/29/2014
      Class: CIS 2571
      Assignment: Lab#1-5
      Descr:
      This application program converting feet into meters.
      It gets input from a dialog box and displays output in 
      a dialog box. 
*/

import javax.swing.JOptionPane;

public class GUIFeet2Meters {
   public static void main(String[] args) {
      // Enter foot
      String feetString = JOptionPane.showInputDialog
        ("Enter a value for feet: ");  

      // Convert string to double
      double feet = Double.parseDouble(feetString);
 
      // Convert feet into meters
      double meter = feet * 0.305;

      // Display results
      String output = feet + " feet is " + meter + " meters";
      JOptionPane.showMessageDialog(null, output);
   }
}