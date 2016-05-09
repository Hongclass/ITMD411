import java.awt.BorderLayout;
import java.awt.Container;
import java.io.*;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.text.DecimalFormat;
import java.sql.*;

public class ViewTable extends JFrame {
	private Connection connect = null;
	private Statement statement = null;
	private JTable table;
	private JButton ok, canel;

	public ViewTable() {
		super("Your Trouble Tickets' Information(Show recent 10 results)");
		String[] columnNames = { "Ticket No.", "Type", "Status", "Start", "End", "Assignee ID", "Assignee First name", "Assignee Last name",  "Assignee Email", "Assignee number", "Assignee Department ID", "Assignee Location"}; // 列名
		Object[][] rowData = new Object[10][12]; // 表格数据
		ok = new JButton("OK");
		canel = new JButton("CANCEL");
		String first_name = JOptionPane.showInputDialog("Enter your First name: ");
		String last_name = JOptionPane.showInputDialog("Enter your Last name");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to a selected database...");
			// Setup the connection with the DB
			connect = DriverManager
					.getConnection("jdbc:mysql://www.papademas.net/tickets?"
							+ "user=root&password=jamesp");
			System.out.println("Connected database successfully...");
			statement = connect.createStatement();

			String sql = " SELECT ticketNo, employee_id FROM Bkan_Hzhan_tickets LEFT JOIN Bkan_Hzhan_employees ON Bkan_Hzhan_employees.employee_id = Bkan_Hzhan_tickets.Assignee "
					+ "WHERE FirstName =" + "'"+ first_name + "'"
					+ " AND LastName =" + "'" + last_name + "';";

			ResultSet rs = statement.executeQuery(sql);
			if (rs == null)
				JOptionPane.showMessageDialog(null,"Your name is not found!");
			else{
			int count = 0;
			// STEP 5: Extract data from result set
			while (rs.next()) {
				rowData[count][0] = rs.getInt("ticketNo");
				rowData[count][1] = rs.getString("fldType");
				rowData[count][2] = rs.getString("Status");
				rowData[count][3] = rs.getDate("StartDate");
				rowData[count][4] = rs.getDate("EndDate");
				rowData[count][5] = rs.getInt("employee_id");
				rowData[count][6] = rs.getString("first_name");
				rowData[count][7] = rs.getString("last_name");
				rowData[count][8] = rs.getString("email");
				rowData[count][9] = rs.getString("phone_number");
				rowData[count][10] = rs.getInt("department_id");
				rowData[count][11] = rs.getString("location");
				count++;
			}
			}
			rs.close();
		} catch (Exception ex) {
			ex.printStackTrace(); // 输出出错信息
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

			Container container = getContentPane(); // 获取窗口容器
			// container.setLayout(null);
			container.add(ok);
			container.add(canel);
			ok.setBounds(320, 200, 100, 20);
			canel.setBounds(480, 200, 100, 20);
			table = new JTable(rowData, columnNames); // 实例化表格

			container.add(new JScrollPane(table), BorderLayout.CENTER); // 增加组件

			setSize(1000, 300); // 设置窗口尺寸
			setVisible(true); // 设置窗口可视
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}// 关闭窗口时退出程序
	}// end ViewTable

	public static void main(String[] args) {
		new ViewTable();
	}// end main
} // end class
