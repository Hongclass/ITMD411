/*  
   Name:   Hong Zhang
   File:   SRPGame.java
   Date:   02/10/2014
   Class:  CIS2571-001
   Descr:
   This program uses random number simulation 
   to create a scissor-rock-paper game.
*/

import javax.swing.JOptionPane;

public class SRPGame {
  public static void main(String[] args) {

    // display constants and variables
    final String titleTxt = "Let's play rock, paper, scissors!";
    String outMsg = "";

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
	
    // generate random number 0, 1 or 2
    int rnum = (int)(Math.random() * 3);
	
	// Prompt the user to enter a guess
    String guessString = JOptionPane.showInputDialog(null,
      "Scissor (0), rock (1), paper (2): ", titleTxt, 
      JOptionPane.QUESTION_MESSAGE);
    int guess = Integer.parseInt(guessString);

	// check computer guess
    switch (rnum) {
      case 0:  outMsg += "\nThe computer is scissors. ";
               break;
      case 1:  outMsg += "\nThe computer is rock. ";
               break;
	  case 2:  outMsg += "\nThe computer is paper. ";
               break;
    }

    // check user guess
    switch (guess) {
      case 0:  outMsg += "\nYou are scissors. ";
               break;
      case 1:  outMsg += "\nYou are rock. ";
               break;
	  case 2:  outMsg += "\nYou are paper. ";
               break;
      default:
               outMsg += "\nWhat was that guess?";
    }

	 // see if correct guess
    if (guess == rnum)
       outMsg += "\nIt is a draw";
    else if (((guess + 1 <= 2)? guess+1: 0) == rnum)
       outMsg += "\nThe computer won";
	else
       outMsg += "\nYou won";
	   
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
} // end of class








