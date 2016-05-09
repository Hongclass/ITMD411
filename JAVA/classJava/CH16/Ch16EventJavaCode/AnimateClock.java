import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/*Hong Zhang*/

public class AnimateClock extends JFrame {
	// class level variables
	private StillClock clock;
	private MessagePanel messagePanel;
	private JButton jbtStart, jbtStop;
	private JRadioButton rbBlue, rbGreen, rbRed;
	private Timer timer;
	
  public AnimateClock() {
    // Create an analog clock for the current time
    clock = new StillClock();

    // Display hour, minute, and seconds in the message panel
    messagePanel = new MessagePanel(clock.getHour() +
      ":" + clock.getMinute() + ":" + clock.getSecond());
    messagePanel.setCentered(true);
    messagePanel.setForeground(Color.blue);
    messagePanel.setFont(new Font("Courier", Font.BOLD, 16));
    
    // create clock options panel using
    // grid layout with 0 rows and 1 column
    JPanel jpClockOpt = new JPanel(new GridLayout(0, 1, 5, 5));
    jpClockOpt.setBorder(new TitledBorder("Options"));
    
    // create radio buttons for color
    rbBlue = new JRadioButton("Blue");
    rbGreen = new JRadioButton("Green");
    rbRed = new JRadioButton("Red");
    
    // create radio button group so only one is selected
    ButtonGroup bgColor = new ButtonGroup();
    bgColor.add(rbBlue);
    bgColor.add(rbGreen);
    bgColor.add(rbRed);
    rbBlue.setSelected(true);
    
    // add radio buttons to clock options panel
    jpClockOpt.add(rbBlue);
    jpClockOpt.add(rbGreen);
    jpClockOpt.add(rbRed);
    
    // create and register listener for color radio buttons
    RBtnListenerClass rbtnListener = new RBtnListenerClass();
    rbBlue.addItemListener(rbtnListener);
    rbGreen.addItemListener(rbtnListener);
    rbRed.addItemListener(rbtnListener); 
    
    //create start and stop buttons
    jbtStart = new JButton("Start");
    jbtStop = new JButton("Stop");
    
    // Create a timer with delay of 10000 ms (or 10 seconds)
    timer = new Timer(10000, new TimerListener());
    
    // enable focus for clock panel
    clock.setFocusable(true);
    clock.addKeyListener(new UpDownListener());
    
    // create and register listener for start/stop buttons
    BtnListenerClass btnListener = new BtnListenerClass();
    jbtStart.addActionListener(btnListener);
    jbtStop.addActionListener(btnListener);
    
    // add start/stop buttons to panel
    jpClockOpt.add(jbtStart);
    jpClockOpt.add(jbtStop);

    // Add the clock and message panel to the frame
    // NOTE: Default layout for JFrame is BorderLayout
    add(clock); // default BorderLayout.CENTER
    add(messagePanel, BorderLayout.SOUTH);
    add(jpClockOpt, BorderLayout.EAST);
  }

  public static void main(String[] args) {
    AnimateClock frame = new AnimateClock();
    frame.setTitle("DisplayClock");
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 350);
    frame.setVisible(true);
    // add method to reset the displayed time
    //frame.resetTime();
  }
  
  // method to reset the displayed time
  public void resetTime() {
	  try {
		  // get the hour, minute, and second from the user
		  int newHour = Integer.parseInt(JOptionPane.showInputDialog(
				  "Enter the new hour as integer (0 to 23):"));
		  int newMinute = Integer.parseInt(JOptionPane.showInputDialog(
				  "Enter the new minute as integer (0 to 59):"));
		  int newSecond = Integer.parseInt(JOptionPane.showInputDialog(
				  "Enter the new seconds as integer (0 to 59):"));
	
		  // reset clock display with user input
		  clock.setHour(newHour);
		  clock.setMinute(newMinute);
		  clock.setSecond(newSecond);
		  
		  // reset the message panel display with updated time
		  messagePanel.setMessage("Reset Time:" + clock.getHour() +
				  ":" + clock.getMinute() + ":" + clock.getSecond());  
	  }
	  catch (NumberFormatException nfe) { }
  }
  
  // create inner class for push button event handling
  private class BtnListenerClass implements ActionListener {
	  // override  method to handle ActionEvent
	  public void actionPerformed(ActionEvent e) {
		  if (e.getSource() == jbtStart) {
			  // reset the time to current
			  clock.setCurrentTime();
			  clock.repaint();
			  // reset the message panel display with updated time
			  messagePanel.setMessage(clock.getHour() +
					  ":" + clock.getMinute() + ":" + clock.getSecond()); 
			  // start the timer
			  timer.start();
			  // reset focus from buttons panel to clock panel for arrow keys
			  clock.requestFocusInWindow();
		  }
		  else if (e.getSource() == jbtStop) {
			  // stop the timer
			  timer.stop();
			  // reset time to 0
			  clock.setHour(0);
			  clock.setMinute(0);
			  clock.setSecond(0);
			  clock.repaint();
			  // reset the message panel display with updated time
			  messagePanel.setMessage(clock.getHour() +
					  ":" + clock.getMinute() + ":" + clock.getSecond());  
		  }
	  }
  }
  
  // create inner class to handle radio button events
  private class RBtnListenerClass implements ItemListener {

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == rbBlue) {
			messagePanel.setForeground(Color.BLUE);
		}
		else if (e.getSource() == rbGreen) {
			messagePanel.setForeground(Color.GREEN);
		}
		else if (e.getSource() == rbRed) {
			messagePanel.setForeground(Color.RED);
		}
	} 
  }
  
  // inner class for timer listener
  private class TimerListener implements ActionListener {
    // handle the action event
	public void actionPerformed(ActionEvent e) {
		// set the new time and replaint the clock
		clock.setCurrentTime();
		clock.repaint();
		// update the message panel display
		messagePanel.setMessage(clock.getHour() + ":" +
				clock.getMinute() + ":" + clock.getSecond());
	}
  }
  
  // inner class for up and down arrow key listener
  private class UpDownListener extends KeyAdapter{
	  // handle the key pressed method 
	  public void keyPressed(KeyEvent e) {
		  int delay = timer.getDelay();
		  if (e.getKeyCode() == KeyEvent.VK_UP) {
			  // increase speed of animation by decreasing delay
			  timer.setDelay(delay > 1000 ? delay - 1000 : 1000);
		  }
		  else if  (e.getKeyCode() == KeyEvent.VK_DOWN) {
			  // decrease speed of animation by increasing delay
			  timer.setDelay(delay < 10000 ? delay + 1000 : 1000);
		  }
	  }  
  }
  
}



