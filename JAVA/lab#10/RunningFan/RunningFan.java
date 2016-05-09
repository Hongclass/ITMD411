/*
    File:   RunningFan.java
	Author: Hong Zhang
    Date:   05/05/2014
    Description:
    This program uses some buttons to control a fan's color and action.  
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class RunningFan extends JFrame {
	// Class level variables
	private StillFan fan;
	private JRadioButton rbBlack, rbRed, rbBlue;
	private JButton jbtStart, jbtStop;
	private Timer timer;
	
	public RunningFan() {
		fan = new StillFan();
		
	    // create fan options panel using
        // grid layout with 0 rows and 1 column
        JPanel jpFanOpt = new JPanel(new GridLayout(0, 1, 5, 5));
        jpFanOpt.setBorder(new TitledBorder("Optoins"));
    
        // create radio buttons for color
        rbBlack = new JRadioButton("Black");
        rbRed = new JRadioButton("Red");
        rbBlue = new JRadioButton("Blue");
    
        // create radio button group so only one is selected
        ButtonGroup bgColor = new ButtonGroup();
        bgColor.add(rbBlack);
        bgColor.add(rbRed);
	    bgColor.add(rbBlue);
        rbBlack.setSelected(true);
    
        // add radio buttons to fan options panel
        jpFanOpt.add(rbBlack);
        jpFanOpt.add(rbRed);
        jpFanOpt.add(rbBlue);

	    // create and register listener for color radio buttons
        RBtnListenerClass rbtnListener = new RBtnListenerClass();
        rbBlack.addItemListener(rbtnListener);
        rbRed.addItemListener(rbtnListener);
        rbBlue.addItemListener(rbtnListener);
    
        // create start and stop buttons
        jbtStart = new JButton("Start");
        jbtStop = new JButton("Stop");
        
        // Create a timer with delay of 10 ms (or 0.01 seconds)
        timer = new Timer(10, new TimerListener());
        
        // enable focus for fan panel
        fan.setFocusable(true);
        fan.addKeyListener(new UpDownListener());
    
        // create and register listener for start/stop buttons
        BtnListenerClass btnListener = new BtnListenerClass();
        jbtStart.addActionListener(btnListener);
        jbtStop.addActionListener(btnListener);
    
        // add start/stop buttons to panel
        jpFanOpt.add(jbtStart);
        jpFanOpt.add(jbtStop);

        // Add the fan to the frame
        add(fan); // default BorderLayout.CENTER
        add(jpFanOpt, BorderLayout.EAST);
    }
		
	// Main method
    public static void main(String[] args) {
        // Create a frame
        RunningFan frame = new RunningFan();
		frame.setTitle("Display Fan");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Display the frame
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setSize(300, 350);
        frame.setVisible(true);
    }
  
    // create inner class to handle radio button events
    private class RBtnListenerClass implements ItemListener {
	    // override method to handle ItemEvent
	    public void itemStateChanged(ItemEvent e) {
			if (e.getSource() == rbBlack) {
			    fan.setColor(Color.BLACK);
		    }
		    else if (e.getSource() == rbRed) {
			    fan.setColor(Color.RED);
		    }
		    else if (e.getSource() == rbBlue) {
			    fan.setColor(Color.BLUE);
		    }
			repaint();
	    }
    }
	
  	// create inner class for push buttons event handling
    private class BtnListenerClass implements ActionListener{
	    // override method to handle ActionEvent
	    public void actionPerformed(ActionEvent e)  {
		    if (e.getSource() == jbtStart) {
                // start the timer
                fan.repaint();
  			    timer.start();
  			    timer.setDelay(1000);
  			    // reset focus from buttons panel to fan panel for arrow keys
  			    fan.requestFocusInWindow();
		    }
		    else if (e.getSource() == jbtStop) {
				  // stop the timer
				  timer.stop();
		    }
	    }
    }
	
    // inner class for timer listener
    private class TimerListener implements ActionListener {
        // handle the action event
  	    public void actionPerformed(ActionEvent e) {
  		    // replaint the fan
  		    fan.repaint();
        }
    }
    
    // inner class for up and down arrow key listener
    private class UpDownListener extends KeyAdapter{
  	    // handle the key pressed method 
  	    public void keyPressed(KeyEvent e) {
  		    int delay = timer.getDelay();
  		    if (e.getKeyCode() == KeyEvent.VK_UP) {
  			    // increase speed of animation by decreasing delay
  			    timer.setDelay(delay > 1 ? delay - 500 : 500);
  		  }
  		    else if  (e.getKeyCode() == KeyEvent.VK_DOWN) {
  			    // decrease speed of animation by increasing delay
  			    timer.setDelay(delay < 10 ? delay + 500 : 500);
  		  }
  	  }  
    }
    
 } // end of class RunningFan
    