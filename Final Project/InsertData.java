/* Program to insert records into Bkan_Hzhan_tickets.
  
   Programmer: Hong Zhang, Benda Kan 
   File Name: InsertData.java
 * 
 */
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;

public class InsertData extends JFrame{
	private Connection connect = null;
	private Statement statement = null;
	private int assignee, tech_required;
	private String first_name = null,
			       last_name = null,
	               fld_type = null, 
			       status = "Open", 
			       priority = null, 
			       description = null;
	private java.util.Date start_date, end_date;
	private java.sql.Date sqlStartDate, sqlEndDate;
	
	private JLabel lb_firstName, lb_lastName, lb_status, lb_desc, 
	               lb_start_date, lb_end_date, lb_assig, lb_tech;
	private JTextField tf_firstName, tf_lastName, tf_desc, tf_assig, 
	                   tf_tech, tf_start_date, tf_end_date;
	private JCheckBox jk_status;
	private JButton button1, button2, button_pop1, button_pop2;
	private JRadioButton jrb1, jrb2, jrb3, jrb4, jrb5, jrb6;
	private JPanel jp1, jp2, jprb1, jprb2, jp3, jp4, p1, p2;
	private ButtonGroup bgroup1, bgroup2;
	private JFrame f1, f2;
	AbstractButton aButton, bButton;

	public InsertData() {	    
		// the panel of ticket information
		jp1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 2));
		jp1.setBorder(new TitledBorder("Ticket Information"));		
		lb_firstName = new JLabel("First Name  ");
		jp1.add(lb_firstName);
	    tf_firstName = new JTextField(20);
	    jp1.add(tf_firstName);	    
	    lb_lastName = new JLabel("Last Name  ");
	    jp1.add(lb_lastName);
	    tf_lastName = new JTextField(10);
	    jp1.add(tf_lastName);
	    lb_status = new JLabel("Ticket Status  ");
	    jp1.add(lb_status);
	    jk_status = new JCheckBox("Open", true);
	    jk_status.setMnemonic('S');
	    jp1.add(jk_status);
	    
	    // the panel of description of problem
		jp2 = new JPanel(new GridLayout(0, 2, 4, 4));
		jp2.setBorder(new TitledBorder("Description of Problem"));
		
		// create radio buttons panel for Field Type
		jprb1 = new JPanel(new GridLayout(0, 1, 5, 5));
		jprb1.setBorder(new TitledBorder("Field Type"));
		jrb1 = new JRadioButton("Email login Issue");
		jrb2 = new JRadioButton("Connectivity Issue");
		jrb3 = new JRadioButton("Software Issue");
		jrb4 = new JRadioButton("Hardware Issue ");     
		bgroup1 = new ButtonGroup();
		bgroup1.add(jrb1);
		bgroup1.add(jrb2);
		bgroup1.add(jrb3);
		bgroup1.add(jrb4);
		jprb1.add(jrb1);
		jprb1.add(jrb2);
		jprb1.add(jrb3);
		jprb1.add(jrb4);
		
	    ActionListener sliceActionListener = new ActionListener() {
	        public void actionPerformed(ActionEvent actionEvent) {
	          aButton = (AbstractButton) actionEvent.getSource();
	        }
	      };
		
		jrb1.addActionListener(sliceActionListener);
		jrb2.addActionListener(sliceActionListener);
		jrb3.addActionListener(sliceActionListener);
		jrb4.addActionListener(sliceActionListener);
		
		// create radio buttons panel for priority
		jprb2 = new JPanel(new GridLayout(0, 1, 3, 3));
		jprb2.setBorder(new TitledBorder("Priority"));
		jrb5 = new JRadioButton("High");
		jrb6 = new JRadioButton("Low");
		bgroup2 = new ButtonGroup();
		bgroup2.add(jrb5);
		bgroup2.add(jrb6);
		jprb2.add(jrb5);
		jprb2.add(jrb6);
		
	    ActionListener sliceActionListener1 = new ActionListener() {
	        public void actionPerformed(ActionEvent actionEvent) {
	          bButton = (AbstractButton) actionEvent.getSource();
	        }
	      };
	
		jrb5.addActionListener(sliceActionListener1);
		jrb6.addActionListener(sliceActionListener1);

		// create text field for description
		lb_desc = new JLabel("Description");
	    tf_desc = new JTextField(20);
			
		// add items to the panel of description of problem
		jp2.add(jprb1);
		jp2.add(jprb2);
		jp2.add(lb_desc);
		jp2.add(tf_desc);
		
	    // the panel of Technician Response
		jp3 = new JPanel(new GridLayout(0, 1, 4, 4));
		jp3.setBorder(new TitledBorder("Technician Response "));
		
		// create text field for assignee
		lb_assig = new JLabel("Assigned To (ID#) ");
	    tf_assig = new JTextField(10);

		// create text field for technician number required
		lb_tech = new JLabel("Technician Number Required ");
	    tf_tech = new JTextField(10);
	    
	    // create start date
		lb_start_date = new JLabel("Start Date ");
		p1 = new JPanel();
		tf_start_date = new JTextField(10);
        button_pop1 = new JButton("popup");
        p1.add(tf_start_date);
        p1.add(button_pop1);
		
	    // create end date
		lb_end_date = new JLabel("End Date ");
		p2 = new JPanel();
		tf_end_date = new JTextField(10);
        button_pop2 = new JButton("popup");
        p2.add(tf_end_date);
        p2.add(button_pop2);
		
		// add items to the panel of Technician Response
		jp3.add(lb_assig);
		jp3.add(tf_assig);
		jp3.add(lb_tech);
		jp3.add(tf_tech);
		jp3.add(lb_start_date);
		jp3.add(p1);
		jp3.add(lb_end_date);
		jp3.add(p2);
    
		// the panel of buttons
		jp4 = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 2));
	    
	    button1 = new JButton("Create Ticket");
	    jp4.add(button1);
	    button2 = new JButton("Quit");
	    jp4.add(button2);

	    event e = new event();
	    button1.addActionListener(e);
	    
	    button2.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	            Container frame = button2.getParent();
	            do 
	                frame = frame.getParent(); 
	            while (!(frame instanceof JFrame));                                      
	            ((JFrame) frame).dispose();
	        }
	    });

		// add panel to frame
		this.setLayout(new BorderLayout(5, 10));
		this.add(jp1, BorderLayout.NORTH);
		this.add(jp2, BorderLayout.CENTER);
		this.add(jp3, BorderLayout.EAST);
		this.add(jp4, BorderLayout.SOUTH);
		
        f1 = new JFrame();
		button_pop1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
            	String startDate = new DatePicker(f1).setPickedDate();
                tf_start_date.setText(startDate);
              
                DateFormat sourceFormat = new SimpleDateFormat("MM-dd-yyyy");
                try {
					start_date = sourceFormat.parse(startDate);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                sqlStartDate= new java.sql.Date(start_date.getTime());
                System.out.println("Date: " + sqlStartDate);
            }     
        });

        f2 = new JFrame();
		button_pop2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae1) {
            	String endDate = new DatePicker(f2).setPickedDate();
                tf_end_date.setText(endDate);
              
                DateFormat sourceFormat = new SimpleDateFormat("MM-dd-yyyy");
                try {
					end_date = sourceFormat.parse(endDate);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                sqlEndDate= new java.sql.Date(end_date.getTime());
                System.out.println("Date: " + sqlEndDate);
             }
		});

    }
	
	  public class event implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				try	{
					first_name = tf_firstName.getText();
					last_name = tf_lastName.getText();
					priority = bButton.getText();
					fld_type = aButton.getText();
					description = tf_desc.getText();
					assignee = Integer.parseInt(tf_assig.getText());
					tech_required = Integer.parseInt(tf_tech.getText());
					
				    dispose();	
					
					Date start = sqlStartDate;
					Date end = sqlStartDate; 

					System.out.println("first name: " + first_name);
					System.out.println("last name: " + last_name);
					System.out.println("flyType: " + fld_type);
					System.out.println("status: " + status);
					System.out.println("start date: " + start);
					System.out.println("end date: " + end);
					System.out.println("assignee: " + assignee);
					System.out.println("priority: " + priority);
					System.out.println("description: " + description);
					System.out.println("tech_required: " + tech_required);

					  // This will load the MySQL driver, each DB has its own driver
					  Class.forName("com.mysql.jdbc.Driver");
					  // Setup the connection with the DB
					  connect = DriverManager
					          .getConnection("jdbc:mysql://www.papademas.net/tickets?"
						      + "user=root&password=jamesp");
						      
					  System.out.println("Inserting records into the table...");
					  statement = connect.createStatement();
						      
					  String sql = "INSERT INTO Bkan_Hzhan_tickets(FirstName, LastName, "
					  		+ "fldType, Status, StartDate, EndDate, Assignee, Priority, "
					  		+ "Description, TechsRequired) " +
					        "VALUES ('"+first_name+"', '"+last_name+"','"+fld_type+"', "
					        		+ "'"+status+"',  '"+start+"', '"+end+"',  "
					        		+ "'"+assignee+"', '"+priority+"', "
					        		+ "'"+description+"', '"+tech_required+"')";
					  statement.executeUpdate(sql);
					  System.out.println("Inserted records into the table...");
  
				}
				catch(Exception e2)	{System.out.println(e2.getMessage()); }
			}
		}
	  
	  public static void main(String[] args) throws Exception {
		  InsertData frame = new InsertData();
		  frame.setTitle("Help Dest Trouble Ticket");
		  frame.setSize(800, 600);
		  frame.setLocationRelativeTo(null); // Center the frame
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  frame.setVisible(true);
	  } // end of main 
	  
}
