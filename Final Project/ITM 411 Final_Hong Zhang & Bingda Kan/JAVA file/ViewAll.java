import java.awt.BorderLayout;
import java.awt.Container;
/*import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;*/

/*import javax.swing.AbstractButton;
import javax.swing.JButton;*/
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/*import javax.swing.JPanel;
*/import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.sql.*;

public class ViewAll extends JFrame {
	private Connection connect = null;
	private Statement statement = null;
	
	private JTable table;
	
	public ViewAll() {
		
		String[] columnNames = { "Ticket No.", "First name","Type", "Status", "Start", "End","Priority","Description","TechsRequired" ,"Assignee ID", "Assignee First name", "Assignee Last name",  "Assignee Email", "Assignee Phone"}; // column name
		Object[][] rowData = new Object[50][14]; // column and array number	

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to a selected database...");
			// Setup the connection with the DB
			connect = DriverManager
					.getConnection("jdbc:mysql://www.papademas.net/tickets?"
							+ "user=root&password=jamesp");
			System.out.println("Connected database successfully...");
			statement = connect.createStatement();

			String sql = " SELECT ticketNo, fldType, Status, StartDate, EndDate, employee_id, first_name, last_name, email, phone_number, FirstName, TechsRequired, Description, Priority FROM Bkan_Hzhan_tickets LEFT JOIN Bkan_Hzhan_employees ON Bkan_Hzhan_employees.employee_id = Bkan_Hzhan_tickets.Assignee ";

			ResultSet rs = statement.executeQuery(sql);
			if (rs == null)
				JOptionPane.showMessageDialog(null,"Your name is not found!");
			else{
			int count = 0;
			// STEP 5: Extract data from result set
			while (rs.next()) {
				rowData[count][0] = rs.getInt("ticketNo");
				rowData[count][1] = rs.getString("FirstName");
				rowData[count][2] = rs.getString("fldType");
				rowData[count][3] = rs.getString("Status");
				rowData[count][4] = rs.getDate("StartDate");
				rowData[count][5] = rs.getDate("EndDate");
				rowData[count][6] = rs.getString("Priority");
				rowData[count][7] = rs.getString("Description");
				rowData[count][8] = rs.getString("TechsRequired");
				rowData[count][9] = rs.getInt("employee_id");
				rowData[count][10] = rs.getString("first_name");
				rowData[count][11] = rs.getString("last_name");
				rowData[count][12] = rs.getString("email");
				rowData[count][13] = rs.getString("phone_number");
				count++;
			}
			}
			rs.close();
		} catch (Exception ex) {
			ex.printStackTrace(); 
			
		} finally {
			// finally block used to close resources
			try {
				if (statement != null)
					connect.close();
			} catch (SQLException se) {
			}// do nothing
			try {
				if (connect != null)
					connect.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}

			Container container = getContentPane(); 
			// container.setLayout(null);
			table = new JTable(rowData, columnNames); 

			container.add(new JScrollPane(table), BorderLayout.CENTER); 
			setSize(1200, 400); 
			setVisible(true); 
			this.setTitle("All tickets' information");
			this.setLocationRelativeTo(null);
			
		}
	}// end ViewTable

	public static void main(String[] args) {
		new ViewAll();
	}// end main
} // end class

