
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DeleteData extends JFrame {
	private Connection connect = null;
	private Statement statement = null;
	private int id;
	private String number = "";
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
	
	public DeleteData() {
		int repeat = 0;
		String answer;
			try {
				Select();
				while(status.equals(null)) {
					JOptionPane.showMessageDialog(null, 
		                    "Warn: Ticket not found");
					/*Select();*/
					}
			answer = JOptionPane
					.showInputDialog("Are you sure you want to delete ticket#"
							+ id
							+ "?\n"
							+ "enter 1: YES \n"
							+ "enter other number: NO");
			repeat = Integer.parseInt(answer);
			if (repeat == 1)
				Delete();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Warn: ticket not found!");
		}
	}// end of UpdateTicket()

	public void Select() {
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
			number = JOptionPane
					.showInputDialog("Please input the ticket ID which you want to delete");
			id = Integer.parseInt(number);
			
			// This will load the MySQL driver, each DB has its own driver
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
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			/* dispose(); */
		}
	}

	public void Delete() throws Exception {
		try {
			id = Integer.parseInt(number);
			/* String number = ""; */
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to a selected database...");
			// Setup the connection with the DB
			connect = DriverManager
					.getConnection("jdbc:mysql://www.papademas.net/tickets?"
							+ "user=root&password=jamesp");
			System.out.println("Connected database successfully...");
			statement = connect.createStatement();

			// Select a ticket
				String sql = "DELETE from Bkan_Hzhan_tickets WHERE ticketNo="
						+ id;
				statement.executeUpdate(sql);
				JOptionPane.showMessageDialog(null,
						"Deleted ticket#" + id+ " successfully! ");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Warn: incorrect!");
			
		} 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args){
		new DeleteData();
	}// end main
}
