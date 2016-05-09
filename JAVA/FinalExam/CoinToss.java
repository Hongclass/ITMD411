/*
 * File: CoinToss.java
 * Author: Hong Zhang
 * Date: 05/12/2014
 * Description: final exam
 * */

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;


public class CoinToss extends JFrame {
	// class level variables
	private JRadioButton rbHead, rbTail;
	private int user, computer;
	private JButton jbPlay, jbHead, jbTail, jbSmiley, jbnotSmiley;
	private JPanel jpComputerOpt;
			
	public CoinToss() {
		
		// create user panel to group buttons
		JPanel jpUserOpt = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 2));
        jpUserOpt.setBorder(new TitledBorder("User Guess"));
        
        // create radio buttons panel
        // grid layout with 0 rows and fix column 1
     	JPanel jprb = new JPanel(new GridLayout(0, 1, 5, 5));
   		jprb.setBorder(new TitledBorder("Option"));
   		
   		// create radio buttons for coin
     	rbHead = new JRadioButton("Head");
     	rbTail = new JRadioButton("Tail");

     	// create radio button group so only one is selected
     	ButtonGroup bgroup = new ButtonGroup();
     	bgroup.add(rbHead);
     	bgroup.add(rbTail);

   		// identify default selected button
   		rbHead.setSelected(true);
     		
   		// add buttons to panel
     	jprb.add(rbHead);
     	jprb.add(rbTail);
        
        // create and register listener for user radio buttons
        RBtnListenerClass rbtnListener = new RBtnListenerClass();
        rbHead.addItemListener(rbtnListener);
        rbTail.addItemListener(rbtnListener);

        // create button with image
        ImageIcon hdIcon = new ImageIcon(getClass().getResource("image/pennyHeads.jpg"));
 		ImageIcon tlIcon = new ImageIcon(getClass().getResource("image/pennyTails.jpg"));
 		JButton jbIcon = new JButton("Coin", hdIcon);
 		jbIcon.setPressedIcon(tlIcon);
 		
    	// set alignments
 		jbIcon.setPreferredSize(new Dimension(200, 200));
 		jbIcon.setHorizontalAlignment(SwingConstants.RIGHT);
 		jbIcon.setVerticalAlignment(SwingConstants.BOTTOM);
 		jbIcon.setHorizontalTextPosition(SwingConstants.CENTER);
 		jbIcon.setVerticalTextPosition(SwingConstants.TOP);
 
 		// add items to buttons panel
 		jpUserOpt.add(jprb);
 		jpUserOpt.add(jbIcon);
 		
 		// --------------------------------------------------------------------------------------------------
 	    // create computer panel to group buttons
 		jpComputerOpt = new JPanel(new GridLayout(0, 2, 5, 5));
 	    jpComputerOpt.setBorder(new TitledBorder("Computer Simulation"));

	    // create toss button with image
        ImageIcon tossCoinIcon = new ImageIcon(getClass().getResource("image/tossCoin.jpg"));
 		JButton jbtossCoinIcon = new JButton(tossCoinIcon);
 	    
    	// set alignments
 		jbtossCoinIcon.setPreferredSize(new Dimension(200, 200));
 		jbtossCoinIcon.setHorizontalAlignment(SwingConstants.LEFT);
 		jbtossCoinIcon.setVerticalAlignment(SwingConstants.BOTTOM);
 		jbtossCoinIcon.setHorizontalTextPosition(SwingConstants.CENTER);
 		jbtossCoinIcon.setVerticalTextPosition(SwingConstants.TOP);
 		
 		// create play button
 		jbPlay = new JButton("Play");
 
 		// add items to buttons panel
 		jpComputerOpt.add(jbtossCoinIcon);
 		jpComputerOpt.add(jbPlay);
 		
 		jbHead = new JButton(hdIcon);
 		jbTail = new JButton(tlIcon);
 		
 		ImageIcon smIcon = new ImageIcon(getClass().getResource("image/smiley.jpg"));
 		ImageIcon notSmIcon = new ImageIcon(getClass().getResource("image/notSmiley.jpg"));
 		
 		jbSmiley = new JButton(smIcon);
 		jbnotSmiley = new JButton(notSmIcon);
 		
     	// create and register listener for play button
 	    BtnListenerClass btnListener = new BtnListenerClass();
 	    jbPlay.addActionListener(btnListener);
 	    
 	    // add the user and computer panel to the frame
 	    add(jpUserOpt, BorderLayout.NORTH);
 	    add(jpComputerOpt, BorderLayout.SOUTH);
	}
	
	  public static void main(String[] args) {
		  CoinToss frame = new CoinToss();
		    frame.setTitle("CoinToss");
		    frame.setLocationRelativeTo(null); // Centre the frame
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setSize(300, 350);
		    frame.setVisible(true);
		    // add method to reset the displayed time
		  }
	
	 // create inner class to handle radio button events
	  private class RBtnListenerClass implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getSource() == rbHead) {
				user = 0;
			}
			else if (e.getSource() == rbTail) {
				user = 1;
			}
			
		} 
	  }
	
	// create inner class for push button event handling
	  private class BtnListenerClass implements ActionListener {
		  // override  method to handle ActionEvent
		  public void actionPerformed(ActionEvent e) {
			  if (e.getSource() == jbPlay) {
				  // generate random number o or 1
				  int computer = (int)(Math.random() * 2);
				  if (computer == 0) {
					  jpComputerOpt.add(jbHead); 
					}
					else if (computer == 1) {
						jpComputerOpt.add(jbTail);;
					}
				  if (computer == user) {
					  jpComputerOpt.add(jbSmiley); 
					}
					else {
						jpComputerOpt.add(jbnotSmiley);;
					}
			  }
			 
		  }
	  } 
}