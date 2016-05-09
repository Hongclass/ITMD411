import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;


public class DeleteChoice extends JFrame{
	private JPanel jp;
	private JButton button1, button2, button3, button4;
	
	public DeleteChoice(){
		
		jp = new JPanel(new FlowLayout(FlowLayout.CENTER, 2, 2));
		button1 = new JButton("View the Trouble Tickets");
		jp.add(button1);
		button2 = new JButton("Delete Ticket(s)");
		jp.add(button2);
		button4 = new JButton("Back to menu");
		jp.add(button4);
		button3 = new JButton("Exit");
		jp.add(button3);
		
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ok) {
				ViewAll va = new ViewAll();
				va.setLocationRelativeTo(null);
			}
		});
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ok) {
				DeleteData dd = new DeleteData();
				dd.setLocationRelativeTo(null);
			}
		});
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ok) {
				dispose();
				Menu m = new Menu();
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
		
		setTitle("Delete Ticket");
		setSize(500, 100);
		setLocationRelativeTo(null); // Center the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		add(jp, BorderLayout.CENTER);
		
	/*}catch (Exception e) {
			System.out.println(e.getMessage());
		}*/
	}
	public static void main(String[] args){
		new DeleteChoice();
	}// end main
}
