import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

// Hong Zhang
// GUI in class exercise

public class MyInCalssGUIExample extends JFrame {

	public MyInCalssGUIExample() {
		// create panel to group buttons
		// flow layout (default for JPanel) with left alignment 
		// and hgap/vgap of 2 pixels
		JPanel jpbtn = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 2));
		jpbtn.setBorder(new TitledBorder("Abstacted Button Subclass"));
		
		// create simple text button
		JButton jbt = new JButton("Java is Fun!");
		jbt.setToolTipText("This is the button tool tip text...");
		
		// create simple check box
		JCheckBox jchk = new JCheckBox("Student", true);
		jchk.setMnemonic('S');
		
		// add items to buttons panel
		jpbtn.add(jbt);
		jpbtn.add(jchk);
		
		// create radio buttons panel
		// grid layout with 0 rows and fix column 1
		JPanel jprb = new JPanel(new GridLayout(0, 1, 5, 5));
		jprb.setBorder(new TitledBorder("Languages"));
		JRadioButton jrb1 = new JRadioButton("C/C++");
		JRadioButton jrb2 = new JRadioButton("Java");
		JRadioButton jrb3 = new JRadioButton("Python");
		JRadioButton jrb4 = new JRadioButton("Visual Basic");
		
		// create radio button group so only one is selected
		ButtonGroup bgroup = new ButtonGroup();
		bgroup.add(jrb1);
		bgroup.add(jrb2);
		bgroup.add(jrb3);
		bgroup.add(jrb4);
		
		// identify default selected button
		jrb2.setSelected(true);
		// add buttons to panel
		jprb.add(jrb1);
		jprb.add(jrb2);
		jprb.add(jrb3);
		jprb.add(jrb4);
		
		// add panel to frame
		// border layout (default for JFrame)
		this.setLayout(new BorderLayout(5,10));
		this.add(new JLabel("NORTH STUFF"), BorderLayout.NORTH);
		this.add(jpbtn, BorderLayout.CENTER);
		this.add(jprb, BorderLayout.EAST);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// create frame and set properties
		MyInCalssGUIExample frame = new MyInCalssGUIExample();
		frame.setTitle("In Class GUI Example");
		frame.setLocationRelativeTo(null); // create the frame on desktop
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 400);
		frame.setVisible(true); 
	}

}
