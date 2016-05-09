import java.awt.*;

// Hong Zhang
// In-Class Java GUI Example
// 04/16/2014

import javax.swing.*;
import javax.swing.border.*;


public class MyInClassGUIExample extends JFrame {
	
	public MyInClassGUIExample() {
		// create panel to group buttons
		// flow layout (default for JPanel) with left alignment
		// and hgap/vgap of 2 pixels
		JPanel jpbtn = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 2));
		jpbtn.setBorder(new TitledBorder("Abstract Button Subclass"));
		
		// create simple text button
		JButton jbt = new JButton("Java is Fun!");
		jbt.setToolTipText("This is the button tool tip text...");
		jbt.setForeground(Color.WHITE);               // text is white
		jbt.setBackground(new Color(0, 0, 0));        // background is black
		Font largeFont = new Font("Courier", Font.BOLD, 20);
		jbt.setFont(largeFont);
		
				
		// create simple check box
		JCheckBox jchk = new JCheckBox("Student", true);
		jchk.setMnemonic('S');
		jchk.setForeground(Color.RED);
		jchk.setBackground(Color.CYAN);
		jchk.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 16));
		
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
		
		// create button with image
		ImageIcon dkIcon = new ImageIcon(getClass().getResource("image/duke.jpg"));
		ImageIcon jdIcon = new ImageIcon(getClass().getResource("image/javaDuke.jpg"));
		ImageIcon adIcon = new ImageIcon(getClass().getResource("image/androidDuke.jpg"));
		JButton jbIcon = new JButton("Java", dkIcon);
		jbIcon.setPressedIcon(jdIcon);
		jbIcon.setRolloverIcon(adIcon);
		
		// set alignments
		jbIcon.setPreferredSize(new Dimension(200, 200));
		jbIcon.setHorizontalAlignment(SwingConstants.RIGHT);
		jbIcon.setVerticalAlignment(SwingConstants.BOTTOM);
		jbIcon.setHorizontalTextPosition(SwingConstants.CENTER);
		jbIcon.setVerticalTextPosition(SwingConstants.TOP);
		
		// add items to buttons panel
		jpbtn.add(jbt);
		jpbtn.add(jchk);
		jpbtn.add(jprb);
		jpbtn.add(jbIcon);
		
		// create panel to hold labels and text fields
		// grid layout with 1 row 4 columns
		JPanel jplbl = new JPanel(new GridLayout(1, 4, 5, 5));
		// create icon label
		JLabel jlblUS = new JLabel("US", new ImageIcon(getClass().
				getResource("image/usIcon.gif")), SwingConstants.CENTER);
		jlblUS.setHorizontalTextPosition(SwingConstants.CENTER);
		jlblUS.setVerticalTextPosition(SwingConstants.BOTTOM);
		// create populated text field
		JTextField jtfMessage = new JTextField("Illinois");
		jtfMessage.setForeground(Color.RED);
		jtfMessage.setFont(largeFont);
		jtfMessage.setBorder(new LineBorder(Color.BLACK, 2));
		// label and empty textbox
		JLabel jlblName = new JLabel ("Your Name: ", SwingConstants.RIGHT);
		JTextField jtfName = new JTextField("");
		
		// add items to panel
		jplbl.add(jlblUS);
		jplbl.add(jtfMessage);
		jplbl.add(jlblName);
		jplbl.add(jtfName);
				
		// add panel to frame
		// border layout (default for JFrame)
		// use hgap/vgap of 5/10 pixels
		this.setLayout(new BorderLayout(5, 10));
		this.add(new JLabel("NORTH STUFF"), BorderLayout.NORTH);
		this.add(jpbtn, BorderLayout.CENTER);
		// this.add(jprb, BorderLayout.EAST);
		this.add(jplbl, BorderLayout.SOUTH);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// create frame and set properties
		MyInClassGUIExample frame = new MyInClassGUIExample();
		frame.setTitle("In Class GUI Example");
		frame.setLocationRelativeTo(null); // center the frame on desktop
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.setSize(500, 400);
		frame.pack();          // sets preferred size
		frame.setVisible(true);
	}

}
