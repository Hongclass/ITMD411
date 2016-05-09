import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CloseTicket {
	private static Connection connect = null;
	private static Statement statement = null;
	private static int id;
	private static String number = "";
	private static String first_name = null;
	private static int assignee;
	private static int tech_required;
	private static String last_name = null;
	private static String fld_type = null;
	private static String status = null;
	private static String priority = null;
	private static String description = null;
	private static Date start;
	private static Date end;

	public CloseTicket() {
		int repeat = 0;
		String answer;
		JOptionPane.showMessageDialog(null, 
                "Attention: If you close a ticket, you cannot update it anymore!", "Mention",JOptionPane.PLAIN_MESSAGE );
		try {
			id=0;
			Close();
			if(status.equals("Closed")) {
    			JOptionPane.showMessageDialog(null, 
	                    "Ticket #" + id + " has been closed, please enter another ticket number", "Result",JOptionPane.PLAIN_MESSAGE );
    			new Menu();
    		}
			else{
			answer = JOptionPane.showInputDialog("Close a Ticket?\n"
					+ "enter 1 to continue or other numbers to exit");
			repeat = Integer.parseInt(answer);
			if (repeat == 1)
				result();
			else
				new Menu();}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Warn: ticket not found!");
			new Menu();
		}

	}// end of CloseTicket()

	static void Close() {
		
			try{
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
			number = JOptionPane.showInputDialog("Please input the ticket ID which you want to close?");
			id = Integer.parseInt(number);
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to a selected database...");
			// Setup the connection with the DB
			connect = DriverManager
					.getConnection("jdbc:mysql://www.papademas.net/tickets?"
							+ "user=root&password=jamesp");
			System.out.println("Connected database successfully...");

			// Select a ticket
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
			}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	static void result() throws Exception{
		try{
		id = Integer.parseInt(number);
		
		// This will load the MySQL driver, each DB has its own driver
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Connecting to a selected database...");
		// Setup the connection with the DB
		connect = DriverManager
				.getConnection("jdbc:mysql://www.papademas.net/tickets?"
						+ "user=root&password=jamesp");
		System.out.println("Connected database successfully...");

		// update the status to close 
		System.out.println("Update table of status column in given database...");
		statement = connect.createStatement();
		
		String sql = "UPDATE Bkan_Hzhan_tickets " +
                 "SET status = 'Closed' WHERE ticketNo = "+id;

		statement.executeUpdate(sql);

		System.out
				.println("close a ticket in given database...");
		
        JOptionPane.showMessageDialog(null, 
                "Ticket #" + id + " is closed", "Result",JOptionPane.PLAIN_MESSAGE );
        new Menu();
		}
		catch(Exception e2)	{System.out.println(e2.getMessage()); 
		JOptionPane.showMessageDialog(null, "Warn: Incorrect!");
        new Menu();}
		// end create table
	}
	
	public static void main(String[] args) {
		new CloseTicket();
	}//end main
	
}//end CloseTicket