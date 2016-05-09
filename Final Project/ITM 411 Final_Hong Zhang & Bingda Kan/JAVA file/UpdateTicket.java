import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;

public class UpdateTicket extends JFrame{
	private static Connection connect = null;
	private static Statement statement = null;
	private static int id;

	private static int assignee;
	private static int tech_required;
	private static String first_name = null;
	private static String last_name = null;
	private static String fld_type = null;
	private static String status = null;
	private static String priority = null;
	private static String description = null;
	private static Date start;
	private static Date end;
	private java.util.Date end_date;
	private java.sql.Date sqlEndDate;
	
	private JLabel lb_id, lb_id1, lb_firstName, lb_firstName1, 
	               lb_lastName, lb_lastName1, lb_status, lb_status1,
	               lb_start_date, lb_start_date1, lb_end_date, lb_assig;
	private JTextField tf_desc, tf_end_date;
	private JButton button1, button2, button_pop2, button3, button4, button5, button6, button7, button8;
	private JRadioButton jrb1, jrb2, jrb3, jrb4, jrb5, jrb6, jrb7, jrb8, jrb9, jrb10, jrb11;
	private JPanel jp1, jp2, jprb1, jprb2, jprb3, jprb4, jp3, jp4, p2;
	private ButtonGroup bgroup1, bgroup2, bgroup3;
	private JFrame f2;
	AbstractButton aButton, bButton, cButton;
	
	public UpdateTicket(){
	    	try {
	    		Select();
	    		while(status.equals("Closed")) {
	    			JOptionPane.showMessageDialog(null, 
    	                    "Ticket #" + id + " has been already closed", "Warn",JOptionPane.PLAIN_MESSAGE ); 	
	    			Select();
	    		}
				Update();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, 
	                    "Ticket #" + id + " not found", "Warn",JOptionPane.PLAIN_MESSAGE );
				dispose();
				new Menu();
			}

	}// end of UpdateTicket()

	static void Select(){
		try {
			first_name = null;
			first_name = null;
			assignee=0;
			tech_required=0;
			last_name = null;
			fld_type = null;
			status = null;
			priority = null;
			description = null;
			start=null;
			end=null;
			String number = "";
			
			number = JOptionPane.showInputDialog("Please input the ticket ID which you want to update?");
			/*while(number == null || number.equals(""))
			number = JOptionPane.showInputDialog("Please input some data!\n "
					+ "Please input the ticket ID which you want to update?");*/
			
			id = Integer.parseInt(number);
			
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to a selected database...");
			// Setup the connection with the DB
			connect = DriverManager
					.getConnection("jdbc:mysql://www.papademas.net/tickets?"
							+ "user=root&password=jamesp");
			System.out.println("Connected database successfully...");

			//Select a ticket 
			System.out.println("select a ticket in given database...");
			statement = connect.createStatement();
			
			String sql = "SELECT ticketNo, FirstName, LastName, fldType, "
					+ "Status, StartDate, EndDate, Assignee, Priority, "
					+ "Description, TechsRequired FROM Bkan_Hzhan_tickets " +
	                 "WHERE ticketNo = '"+id+"'";
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				//Extract data from result set
	            first_name = rs.getString("FirstName");
	            last_name = rs.getString("LastName");
	            fld_type = rs.getString("fldType");
	            status = rs.getString("Status");
	            start = rs.getDate("StartDate");
	            end = rs.getDate("EndDate");
	            assignee = rs.getInt("Assignee");
	            priority = rs.getString("Priority");
	            description = rs.getString("Description");
	            tech_required = rs.getInt("TechsRequired");

			    //Display values
			    System.out.println("TicketID: " + id);
			    System.out.println("FirstName: " + first_name);
			    System.out.println("LastName: " + last_name);
			    System.out.println("fldType: " + fld_type);
			    System.out.println("StartDate: " + start);
			    System.out.println("EndDate: " + end);
			    System.out.println("Assignee: " + assignee);
			    System.out.println("Priority: " + priority);
			    System.out.println("Description: " + description);
			    System.out.println("TechsRequired: " + tech_required);
			}			
			rs.close();
			System.out
					.println("select a ticket in given database...");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Warn: Please input a number!");
            Select();
		}
	}

	public void Update() {	    
		// the panel of ticket information
		jp1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 2));
		jp1.setBorder(new TitledBorder("Ticket Information"));	
		
		lb_id = new JLabel("Ticket No:  #");
		jp1.add(lb_id);
		
		lb_id1 = new JLabel(Integer.toString(id));
		jp1.add(lb_id1);
		
		lb_firstName = new JLabel("          First Name:  ");
	    jp1.add(lb_firstName);	
	    
		lb_firstName1 = new JLabel(first_name);
	    jp1.add(lb_firstName1);	
	    
	    lb_lastName = new JLabel("          Last Name:  ");
	    jp1.add(lb_lastName);
	    
	    lb_lastName1 = new JLabel(last_name);
	    jp1.add(lb_lastName1);
	    
	    lb_status = new JLabel("          Ticket Status:  ");
	    jp1.add(lb_status);
	    
	    lb_status1 = new JLabel(status);
	    jp1.add(lb_status1);
	    
	    // the panel of description of problem
		jp2 = new JPanel(new GridLayout(0, 1, 4, 4));
		jp2.setBorder(new TitledBorder("Description of Problem"));
		
		// show radio buttons panel for Field Type
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
		//identify selected button
		if (fld_type.equals("Email login Issue"))
			jrb1.setSelected(true);
		else if (fld_type.equals("Connectivity Issue"))
			jrb2.setSelected(true); 
		else if (fld_type.equals("Software Issue"))
			jrb3.setSelected(true); 
		else 
			jrb4.setSelected(true); 
		jprb1.add(jrb1);
		jprb1.add(jrb2);
		jprb1.add(jrb3);
		jprb1.add(jrb4);
		
	    ActionListener sliceActionListener = new ActionListener() {
	        public void actionPerformed(ActionEvent actionEvent) {
	          aButton = (AbstractButton) actionEvent.getSource();
	          System.out.println("Selected: " + aButton.getText());
	          fld_type = aButton.getText();
	        }
	      };
		
		jrb1.addActionListener(sliceActionListener);
		jrb2.addActionListener(sliceActionListener);
		jrb3.addActionListener(sliceActionListener);
		jrb4.addActionListener(sliceActionListener);
		
	    button3 = new JButton("Update Field Type");
	    jprb1.add(button3);
	    event1 fte = new event1();
	    button3.addActionListener(fte);
		
		// show radio buttons panel for priority
		jprb2 = new JPanel(new GridLayout(0, 1, 3, 3));
		jprb2.setBorder(new TitledBorder("Priority"));
		jrb5 = new JRadioButton("High");
		jrb6 = new JRadioButton("Low");
		bgroup2 = new ButtonGroup();
		bgroup2.add(jrb5);
		bgroup2.add(jrb6);
		
		//identify selected button
		if (priority.equals("High"))
			jrb5.setSelected(true);
		else 
			jrb6.setSelected(true); 
		jprb2.add(jrb5);
		jprb2.add(jrb6);
		
	    ActionListener sliceActionListener1 = new ActionListener() {
	        public void actionPerformed(ActionEvent actionEvent) {
	          bButton = (AbstractButton) actionEvent.getSource();
	          System.out.println("Selected: " + bButton.getText());
	          priority = bButton.getText();
	        }
	      };
	
		jrb5.addActionListener(sliceActionListener1);
		jrb6.addActionListener(sliceActionListener1);
		
	    button4 = new JButton("Update Priority");
	    jprb2.add(button4);
	    event2 pe = new event2();
	    button4.addActionListener(pe);

		// show text field for description
	    jprb4 = new JPanel(new GridLayout(0,2,2,2));
	    jprb4.setBorder(new TitledBorder("Description"));
	    tf_desc = new JTextField(description);
	    button5 = new JButton("Update Description");
	    jprb4.add(tf_desc);
	    jprb4.add(button5);
	    
	    event3 de = new event3();
	    button5.addActionListener(de);
			
		// add items to the panel of description of problem
		jp2.add(jprb1);
		jp2.add(jprb2);
		jp2.add(jprb4);
		
	    // the panel of Technician Response
		jp3 = new JPanel(new GridLayout(0, 1, 4, 4));
		jp3.setBorder(new TitledBorder("Technician Response "));
		
		// show assignee
		lb_assig = new JLabel("Assigned To Employee ID #" + assignee);

		// show radio buttons panel for technician number required
		jprb3 = new JPanel(new GridLayout(0, 2, 3, 3));
		jprb3.setBorder(new TitledBorder("Technician Number Required"));
		jrb7 = new JRadioButton("1");
		jrb8 = new JRadioButton("2");
		jrb9 = new JRadioButton("3");
		jrb10 = new JRadioButton("4");
		jrb11 = new JRadioButton("5");
		bgroup3 = new ButtonGroup();
		bgroup3.add(jrb7);
		bgroup3.add(jrb8);
		bgroup3.add(jrb9);
		bgroup3.add(jrb10);
		bgroup3.add(jrb11);
		//identify selected button
		if (tech_required == 1)
			jrb7.setSelected(true);
		else if (tech_required == 2)
			jrb8.setSelected(true); 
		else if (tech_required == 3)
			jrb9.setSelected(true); 
		else if (tech_required == 4)
			jrb10.setSelected(true); 
		else
			jrb11.setSelected(true); 
		jprb3.add(jrb7);
		jprb3.add(jrb8);
		jprb3.add(jrb9);
		jprb3.add(jrb10);
		jprb3.add(jrb11);
		
	    ActionListener sliceActionListener2 = new ActionListener() {
	        public void actionPerformed(ActionEvent actionEvent) {
	          cButton = (AbstractButton) actionEvent.getSource();
	          System.out.println("Selected: " + cButton.getText());
	          tech_required = Integer.parseInt(cButton.getText());
	        }
	      };
		
		jrb7.addActionListener(sliceActionListener2);
		jrb8.addActionListener(sliceActionListener2);
		jrb9.addActionListener(sliceActionListener2);
		jrb10.addActionListener(sliceActionListener2);
		jrb11.addActionListener(sliceActionListener2);
		
	    button6 = new JButton("Update Technician Required");
	    event4 tre = new event4();
	    button6.addActionListener(tre);

	    // show start date
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		lb_start_date = new JLabel("      Start Date:     " + df.format(start));
		
	    // show end date
		p2 = new JPanel();
		lb_end_date = new JLabel("End Date:   ");
		tf_end_date = new JTextField(df.format(end));
        button_pop2 = new JButton("popup");
        p2.add(lb_end_date);
        p2.add(tf_end_date);
        p2.add(button_pop2);
        
	    button7 = new JButton("Update End Date");
	    event5 ede = new event5();
	    button7.addActionListener(ede);
 		
		// add items to the panel of Technician Response
		jp3.add(lb_assig);
		jp3.add(jprb3);
		jp3.add(button6);
		jp3.add(lb_start_date);
		jp3.add(p2);
		jp3.add(button7);
		
		// the panel of buttons
		jp4 = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 2));
	    
	    button2 = new JButton("Quit");
	    jp4.add(button2);
	    button8 = new JButton("Back to Menu");
	    jp4.add(button8);
	    
	    button2.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	            Container frame = button2.getParent();
	            do 
	                frame = frame.getParent(); 
	            while (!(frame instanceof JFrame));                                      
	            ((JFrame) frame).dispose();
	        }
	    });
	    button8.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	            dispose();
	           new Menu();
	        }
	    });
		// add panel to frame
		this.setLayout(new BorderLayout(5, 10));
		this.add(jp1, BorderLayout.NORTH);
		this.add(jp2, BorderLayout.CENTER);
		this.add(jp3, BorderLayout.EAST);
		this.add(jp4, BorderLayout.SOUTH);
		

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
		setTitle("Update: Trouble Ticket");
		setSize(600, 600);
		setLocationRelativeTo(null); // Center the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
    }
	
	  public class event1 implements ActionListener {
			public void actionPerformed(ActionEvent fte) {
				try	{
					fld_type = aButton.getText();

					System.out.println("flyType: " + fld_type);

					  // This will load the MySQL driver, each DB has its own driver
					Class.forName("com.mysql.jdbc.Driver");
					  // Setup the connection with the DB
					connect = DriverManager
					          .getConnection("jdbc:mysql://www.papademas.net/tickets?"
	 					      + "user=root&password=jamesp");
						      
					System.out.println("update records into the table...");
					statement = connect.createStatement();
						     
					String sql = "UPDATE Bkan_Hzhan_tickets SET fldType = '"
									+ fld_type + "' WHERE ticketNo = " + id + ";";
					statement.executeUpdate(sql);
	
					System.out.println("update a record into the table...");
					JOptionPane.showMessageDialog(null,
							"Update fldType successfully!");
  
				}
				catch(Exception fte1)	{System.out.println(fte1.getMessage()); }
			}
		}
	
	  public class event2 implements ActionListener {
			public void actionPerformed(ActionEvent pe) {
				try	{
					priority = bButton.getText();

					System.out.println("priority: " + priority);

					  // This will load the MySQL driver, each DB has its own driver
					Class.forName("com.mysql.jdbc.Driver");
					  // Setup the connection with the DB
					connect = DriverManager
					          .getConnection("jdbc:mysql://www.papademas.net/tickets?"
	 					      + "user=root&password=jamesp");
						      
					System.out.println("update records into the table...");
					statement = connect.createStatement();
						     
					String sql2 = "UPDATE Bkan_Hzhan_tickets SET Priority = '"
							+ priority + "' WHERE ticketNo = " + id;
		        	statement.executeUpdate(sql2);
	
					System.out.println("update a record into the table...");
					JOptionPane.showMessageDialog(null,
							"Update Priority successfully!");
  
				}
				catch(Exception pe1)	{System.out.println(pe1.getMessage()); }
			}
		}
	  
	  public class event3 implements ActionListener {
			public void actionPerformed(ActionEvent de) {
				try	{
					description = tf_desc.getText();

					System.out.println("description: " + description);


					  // This will load the MySQL driver, each DB has its own driver
					Class.forName("com.mysql.jdbc.Driver");
					  // Setup the connection with the DB
					connect = DriverManager
					          .getConnection("jdbc:mysql://www.papademas.net/tickets?"
	 					      + "user=root&password=jamesp");
						      
					System.out.println("update records into the table...");
					statement = connect.createStatement();

					String sql4 = "UPDATE Bkan_Hzhan_tickets SET Description = '"
									+ description + "' WHERE ticketNo = " + id;
					statement.executeUpdate(sql4);
	
					System.out.println("update a record into the table...");
					JOptionPane.showMessageDialog(null,
							"Update Description successfully!");
  
				}
				catch(Exception de1)	{System.out.println(de1.getMessage()); }
			}
		}
	  
	  public class event4 implements ActionListener {
			public void actionPerformed(ActionEvent tre) {
				try	{
					tech_required = Integer.parseInt(cButton.getText());
	
					System.out.println("tech_required: " + tech_required);

					  // This will load the MySQL driver, each DB has its own driver
					Class.forName("com.mysql.jdbc.Driver");
					  // Setup the connection with the DB
					connect = DriverManager
					          .getConnection("jdbc:mysql://www.papademas.net/tickets?"
	 					      + "user=root&password=jamesp");
						      
					System.out.println("update records into the table...");
					statement = connect.createStatement();

					String sql3 = "UPDATE Bkan_Hzhan_tickets SET TechsRequired = "
									+ tech_required + " WHERE ticketNo = " + id;
					statement.executeUpdate(sql3);
	
					System.out.println("update a record into the table...");
					JOptionPane.showMessageDialog(null,
							"Update Tech Required successfully!");
  
				}
				catch(Exception tre1)	{System.out.println(tre1.getMessage()); }
			}
		}
	  
	  public class event5 implements ActionListener {
			public void actionPerformed(ActionEvent ede) {
				try	{
					System.out.println("end date: " + sqlEndDate);

					  // This will load the MySQL driver, each DB has its own driver
					Class.forName("com.mysql.jdbc.Driver");
					  // Setup the connection with the DB
					connect = DriverManager
					          .getConnection("jdbc:mysql://www.papademas.net/tickets?"
	 					      + "user=root&password=jamesp");
						      
					System.out.println("update records into the table...");
					statement = connect.createStatement();
						     
					String sql1 = "UPDATE Bkan_Hzhan_tickets SET EndDate = '"
									+ sqlEndDate + "' WHERE ticketNo = " + id;
					statement.executeUpdate(sql1);

					System.out.println("update a record into the table...");
					JOptionPane.showMessageDialog(null,
							"Update End Date successfully!");
  
				}
				catch(Exception ede1)	{System.out.println(ede1.getMessage()); }
			}
		}
	
	public static void main(String[] args) {
		new UpdateTicket();
		/*frame.setTitle("Help Dest Trouble Ticket");
		frame.setSize(600, 600);
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);*/
	}//end main
	
}
