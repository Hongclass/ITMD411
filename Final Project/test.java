import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

//import java.awt.event.*;
public class test extends JFrame
// implements ActionListener
{
	// private String dbURL="jdbc:microsoft:sqlserver://202.115.26.181:1433"; //
	// ���ݿ��ʶ��
	private String user = "devon"; // ���ݿ��û�
	private String password = "book"; // ���ݿ��û�����
	private JTable table;
	private JButton ok, canel;

	public test() {
		super("��ʾ���ݿ��ѯ���"); // ���ø��๹�캯��
		String[] columnNames = { "�û���", "����", "�Ա�", "Email" }; // ����
		Object[][] rowData = new Object[5][4]; // �������
		ok = new JButton("ȷ��");
		canel = new JButton("ȡ��");
		// ok.addActionListener(this);
		// canel.addActionListener(this);
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con = DriverManager.getConnection("jdbc:odbc:example",
					"sa", "");
			// Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
			// //����������
			// Connection con=DriverManager.getConnection(dbURL,user,password);
			// //��ȡ����
			String sqlStr = "select * from users"; // ��ѯ���
			PreparedStatement ps = con.prepareStatement(sqlStr); // ��ȡPreparedStatement����
			ResultSet rs = ps.executeQuery(); // ִ�в�ѯ
			String name, sex, email; // ��ѯ���
			int age;
			int count = 0;
			while (rs.next()) { // ������ѯ���
				rowData[count][0] = rs.getString("name"); // ��ʼ����������
				rowData[count][1] = Integer.toString(rs.getInt("age"));
				rowData[count][2] = rs.getString("sex");
				rowData[count][3] = rs.getString("email");
				count++;
			}

			con.close(); // �ر�����
		} catch (Exception ex) {
			ex.printStackTrace(); // ���������Ϣ
		}

		Container container = getContentPane(); // ��ȡ��������
		// container.setLayout(null);
		container.add(ok);
		container.add(canel);
		ok.setBounds(10, 120, 70, 20);
		canel.setBounds(100, 120, 70, 20);
		table = new JTable(rowData, columnNames); // ʵ�������
		table.getColumn("����").setMaxWidth(25); // �����п�
		container.add(new JScrollPane(table), BorderLayout.CENTER); // �������

		setSize(300, 200); // ���ô��ڳߴ�
		setVisible(true); // ���ô��ڿ���
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �رմ���ʱ�˳�����
	}

	public static void main(String[] args) {
		new test();
	}
}
