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

public class ViewTable extends JFrame {
	private Connection connect = null;
	private Statement statement = null;
	
	private JTable table;
	
	public ViewTable() {
		
		String[] columnNames = { "Ticket No.", "First name","Type", "Status", "Start", "End","Priority","Description","TechsRequired" ,"Assignee ID", "Assignee First name", "Assignee Last name",  "Assignee Email", "Assignee Phone"}; // column name
		Object[][] rowData = new Object[30][14]; // column and array number
		
		String first_name = JOptionPane.showInputDialog("Enter your First name that you want to search: ");
		String last_name = JOptionPane.showInputDialog("Enter your Last name that you want to search: ");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to a selected database...");
			// Setup the connection with the DB
			connect = DriverManager
					.getConnection("jdbc:mysql://www.papademas.net/tickets?"
							+ "user=root&password=jamesp");
			System.out.println("Connected database successfully...");
			statement = connect.createStatement();

			String sql = " SELECT ticketNo, fldType, Status, StartDate, EndDate, employee_id, first_name, last_name, email, phone_number, FirstName, TechsRequired, Description, Priority  FROM Bkan_Hzhan_tickets LEFT JOIN Bkan_Hzhan_employees ON Bkan_Hzhan_employees.employee_id = Bkan_Hzhan_tickets.Assignee "
					+ "WHERE FirstName =" + "'"+ first_name + "'"
					+ " AND LastName =" + "'" + last_name + "';";

			ResultSet rs = statement.executeQuery(sql);
			
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
			
			rs.close();
			
			Container container = getContentPane(); 
			// container.setLayout(null);

			table = new JTable(rowData, columnNames); 

			container.add(new JScrollPane(table), BorderLayout.CENTER); 

			setSize(1200, 300); 
			setVisible(true); 
			setTitle("Your trouble tickets' information");
			setLocationRelativeTo(null);
			
		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null,"Your name is not found!");
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
			
		}
	}// end ViewTable

	public static void main(String[] args) {
		new ViewTable();
	}// end main
} // end class
