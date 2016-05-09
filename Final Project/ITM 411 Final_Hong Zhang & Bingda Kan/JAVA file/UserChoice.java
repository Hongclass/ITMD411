import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class UserChoice extends JFrame {

	private JPanel jp4;
	private JButton button1, button2, button3, button4;

	public UserChoice() {

		jp4 = new JPanel(new FlowLayout(FlowLayout.CENTER, 2, 2));
		button1 = new JButton("View all tickets");
		jp4.add(button1);
		button2 = new JButton("View Someone");
		jp4.add(button2);
		button3 = new JButton("Exit");
		jp4.add(button3);
		

		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ok) {
				ViewAll va = new ViewAll();
				va.setLocationRelativeTo(null);
			}
		});
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ok) {
				ViewTable vt = new ViewTable();
				vt.setLocationRelativeTo(null);
			}
		});
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container frame = button2.getParent();
				do
					frame = frame.getParent();
				while (!(frame instanceof JFrame));
				((JFrame) frame).dispose();
			}
		});
		add(jp4, BorderLayout.CENTER);
		setTitle("Type in a ticket number that you want to see");
		setSize(380, 80);
		setLocationRelativeTo(null); // Center the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new UserChoice();
	}// end main
}