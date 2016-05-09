import java.sql.*;

public class CreateTable {
	private Connection connect = null;
	private Statement statement = null;

	public void createDataBase() throws Exception {
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to a selected database...");
			// Setup the connection with the DB
			connect = DriverManager
					.getConnection("jdbc:mysql://www.papademas.net/tickets?"
							+ "user=root&password=jamesp");
			System.out.println("Connected database successfully...");

			// create table
			System.out.println("Creating table in given database...");
			statement = connect.createStatement();

			/*String sql = "DROP TABLE Bkan_Hzhan_tickets;";
			statement.executeUpdate(sql);*/
			String sql = "CREATE TABLE Bkan_Hzhan_tickets "
					+ "(ticketNo INTEGER NOT NULL AUTO_INCREMENT, "
					+ " FirstName VARCHAR(20) NOT NULL, "
					+ "LastName VARCHAR(20) NOT NULL,"
					+ " fldType VARCHAR(20), " + " Status VARCHAR(20), "
					+ " StartDate DATE, " + " EndDate DATE, "
					+ " Assignee INTEGER NOT NULL, "
					+ " Priority VARCHAR(20), " + " Description VARCHAR(20), "
					+ " TechsRequired INTEGER, "
					+ " PRIMARY KEY ( ticketNo ));";
			statement.executeUpdate(sql);

			/*sql = "DROP TABLE Bkan_Hzhan_employees;";
			statement.executeUpdate(sql);*/
			sql = " CREATE TABLE Bkan_Hzhan_employees "
					+ "(employee_id INTEGER NOT NULL, "
					+ " first_name VARCHAR(20) NOT NULL," + " last_name VARCHAR(20) NOT NULL,"
					+ " email VARCHAR(25)," + " phone_number VARCHAR(20),"
					+ " department_id INTEGER," + " location VARCHAR(20),"
					+ " PRIMARY KEY(employee_id));";
			statement.executeUpdate(sql);

			String sql1 = " ALTER TABLE Bkan_Hzhan_tickets ADD CONSTRAINT fk_2 FOREIGN KEY (Assignee) REFERENCES Bkan_Hzhan_employees(employee_id);";
			statement.executeUpdate(sql1);

			System.out
					.println("Created table and procedures in given database...");

			// end create table
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void insertIntoDataBase() throws Exception {
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager
					.getConnection("jdbc:mysql://www.papademas.net/tickets?"
							+ "user=root&password=jamesp");

			System.out.println("Inserting records into the table...");
			statement = connect.createStatement();
			/*String sql="delete from Bkan_Hzhan_employees; ";
			statement.executeUpdate(sql);*/
			String sql = "INSERT INTO Bkan_Hzhan_employees(employee_id, first_name, last_name, email, phone_number, department_id, location) " + "VALUES (101, 'Bill', 'Black', 'gob@gmail.com', '312-933-4097', 20, 'IT');";
			statement.executeUpdate(sql);
			sql = "INSERT INTO Bkan_Hzhan_employees(employee_id, first_name, last_name, email, phone_number, department_id, location) " + "VALUES (102, 'Bob', 'Smith', 'gag@gmail.com', '312-943-5007', 20, 'IT');";
			statement.executeUpdate(sql);
			sql = "INSERT INTO Bkan_Hzhan_employees(employee_id, first_name, last_name, email, phone_number, department_id, location) " + "VALUES (103, 'Halen', 'Katty', 'sala@gmail.com', '312-112-3047', 20, 'IT');";
			statement.executeUpdate(sql);
			sql = "INSERT INTO Bkan_Hzhan_employees(employee_id, first_name, last_name, email, phone_number, department_id, location) " + "VALUES (104, 'Tank', 'Brown', 'tuch@gmail.com', '312-984-7692', 20, 'IT');";
			statement.executeUpdate(sql);
			sql = "INSERT INTO Bkan_Hzhan_employees(employee_id, first_name, last_name, email, phone_number, department_id, location) " + "VALUES (105, 'James', 'Cook', 'ko@gmail.com', '310-945-4023', 20, 'IT');";
			statement.executeUpdate(sql);
			sql = "INSERT INTO Bkan_Hzhan_employees(employee_id, first_name, last_name, email, phone_number, department_id, location) " + "VALUES (106, 'Wale', 'Smith', 'giant@gmail.com', '334-633-4071', 30, 'Marketing');";
			statement.executeUpdate(sql);
			sql = "INSERT INTO Bkan_Hzhan_employees(employee_id, first_name, last_name, email, phone_number, department_id, location) " + "VALUES (107, 'Jing', 'Kerry', 'running@gmail.com', '365-283-4065', 30, 'Marketing');";
			statement.executeUpdate(sql);
			sql = "INSERT INTO Bkan_Hzhan_employees(employee_id, first_name, last_name, email, phone_number, department_id, location) " + "VALUES (108, 'Lebrone', 'James', 'lj@gmail.com', '312-976-3987', 40, 'Finance');";
			statement.executeUpdate(sql);
			sql = "INSERT INTO Bkan_Hzhan_employees(employee_id, first_name, last_name, email, phone_number, department_id, location) " + "VALUES (109, 'Kobe', 'Briant', 'kb@gmail.com', '312-900-7056', 50, 'Service');";
			statement.executeUpdate(sql);
			sql = "INSERT INTO Bkan_Hzhan_employees(employee_id, first_name, last_name, email, phone_number, department_id, location) " + "VALUES (110, 'Chris', 'Pole', 'cp1@gmail.com', '313-317-4023', 60, 'Management');";
			statement.executeUpdate(sql);
			sql = "INSERT INTO Bkan_Hzhan_employees(employee_id, first_name, last_name, email, phone_number, department_id, location) " + "VALUES (111, 'Todd', 'Jimpson', 'tj@gmail.com', '348-268-4097', 70, 'Sale');";
			statement.executeUpdate(sql);
			/*sql = "INSERT INTO Bkan_Hzhan_tickets(ticketNo, FirstName, LastName, fldType, Assignee) " + "VALUES (001, 'test', 'test', 'test', 103);";
			statement.executeUpdate(sql);*/
			System.out.println("Inserted records into the table...");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) throws Exception {
		CreateTable CREATE = new CreateTable();
		CREATE.createDataBase();
		CREATE.insertIntoDataBase();
	}// end main
}// end JDBCExample
