/*
  Name: Hong Zhang
  File: WelcomeInMessageDialogbox.java
  Date:01/22/2014
  Descr:
  This application program displays 'Welcome to Java!'
  in a message dialog box.
*/

import javax.swing.JOptionPane;

public class WelcomeInMessageDialogbox
{
   public static void main(String[] args)
   {
      JOptionPane.showMessageDialog(null, "Welcome to Java!", "My first program",
        JOptionPane.INFORMATION_MESSAGE);
   }
}
