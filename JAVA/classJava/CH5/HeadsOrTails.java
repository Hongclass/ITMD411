/*  
   Name:   Your Name
   File:   HeadsOrTails.java
   Date:   MM/DD/YYYY
   Class:  CIS2571-001
   Descr:
   This program uses random number
   simulation to create a Heads Or
   Tails game.
*/

import javax.swing.JOptionPane;

public class HeadsOrTails {
  // class level variable to hold title of dialog box
  final static String titleTxt = "Heads Or Tails?";

  public static void main(String[] args) {

    // display constants and variables

    String outMsg;
	
    // see if the user wants to play the game
    int answer = JOptionPane.showConfirmDialog(null,
       "Do you want to play a game?", titleTxt,
       JOptionPane.YES_NO_OPTION, 
       JOptionPane.QUESTION_MESSAGE);

    // exit if the user doesn't want to play
    //if (answer == JOptionPane.NO_OPTION)
    //   System.exit(0);
	
	// use pretest loop to play game
	while (answer == JOptionPane.YES_OPTION) {
 
         // play one round of Heads/Tails
		 outMsg = playGame();
		 
		// display output message
		JOptionPane.showMessageDialog(null, outMsg,
		  titleTxt , JOptionPane.INFORMATION_MESSAGE);
		  
		// see if user wants to continue
		answer = JOptionPane.showConfirmDialog(null,
			"Do you want to play another game?", titleTxt,
			JOptionPane.YES_NO_OPTION, 
			JOptionPane.QUESTION_MESSAGE);
	} // end of 'while' loop
  } // end of 'main' method
  
  /** method to play one set of Heads/Tails */
  public static String playGame(){
  
        // create local variable to hold messge
		String outMsg;
              
      	// generate random number 0 or 1
		int rnum = (int)(Math.random() * 2);

		// Prompt the user to enter a guess
		String guessString = JOptionPane.showInputDialog(null,
		  "Enter 0 for heads and 1 for tails", titleTxt, 
		  JOptionPane.QUESTION_MESSAGE);
		int guess = Integer.parseInt(guessString);

		// see if correct guess
		if (guess == rnum)
		   outMsg = "Your guess was correct :-)";
		else
		   outMsg = "Your guess was wrong :-(";

		// check user guess
		switch (guess) {
		  case 0:  outMsg += "\nYou guessed heads.";
				   break;
		  case 1:  outMsg += "\nYou guessed tails.";
				   break;
		  default:
				   outMsg += "\nWhat was that guess?";
		}
		return outMsg; 
  }
  
} // end of class








