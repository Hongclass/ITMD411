import java.awt.*;
import javax.swing.*;

public class ChangeClock extends JFrame {
	// class level variables
	private StillClock clock;
	private MessagePanel messagePanel;
	
  public ChangeClock() {
    // Create an analog clock for the current time
    clock = new StillClock();

    // Display hour, minute, and seconds in the message panel
    messagePanel = new MessagePanel(clock.getHour() +
      ":" + clock.getMinute() + ":" + clock.getSecond());
    messagePanel.setCentered(true);
    messagePanel.setForeground(Color.blue);
    messagePanel.setFont(new Font("Courier", Font.BOLD, 16));

    // Add the clock and message panel to the frame
    add(clock);
    add(messagePanel, BorderLayout.SOUTH);
  }

  public static void main(String[] args) {
    ChangeClock frame = new ChangeClock();
    frame.setTitle("DisplayClock");
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 350);
    frame.setVisible(true);
    // add method to reset the displayed time
    frame.resetTime();
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
}



