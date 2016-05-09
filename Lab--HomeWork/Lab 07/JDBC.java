import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBC {
	  private Connection connect = null;
	  private Statement statement = null;

	  public void createDataBase() throws Exception {
		  try {
	          // This will load the MySQL driver, each DB has its own driver
			  Class.forName("com.mysql.jdbc.Driver");
	          // Setup the connection with the DB
	          connect = DriverManager
	                  .getConnection("jdbc:mysql://www.papademas.net/Inventory?"
	                  + "user=root&password=jamesp");
 	      
	          //create table
	          statement = connect.createStatement();
	          String sql = "CREATE TABLE hzhanInventory " +
	              "(id INTEGER not NULL AUTO_INCREMENT, " +
	              " cost INTEGER, " + 
	              " PRIMARY KEY ( id ))"; 

	          statement.executeUpdate(sql);
	      
	          System.out.println("Created table in given database...");
	          //end create table
	      } 
		  catch (Exception e) {
			  System.out.println(e.getMessage());  
	      }  
	  } // end of createDataBase()
	  
	  public void insertIntoDataBase() throws Exception {
		  try {
			  // This will load the MySQL driver, each DB has its own driver
			  Class.forName("com.mysql.jdbc.Driver");
			  // Setup the connection with the DB
			  connect = DriverManager
			          .getConnection("jdbc:mysql://www.papademas.net/Inventory?"
				      + "user=root&password=jamesp");
				      
			  System.out.println("Inserting records into the table...");
			  statement = connect.createStatement();
				      
			  String sql = "INSERT INTO hzhanInventory(cost) " +
		                      "VALUES (400)";
			  statement.executeUpdate(sql);
			  
			  sql = "INSERT INTO hzhanInventory(cost) " +
		               "VALUES (400)";
			  statement.executeUpdate(sql);
			  
			  sql = "INSERT INTO hzhanInventory(cost) " +
                      "VALUES (500)";
			  statement.executeUpdate(sql);
			  
			  sql = "INSERT INTO hzhanInventory(cost) " +
                      "VALUES (500)";
			  statement.executeUpdate(sql);
			  
			  sql = "INSERT INTO hzhanInventory(cost) " +
                      "VALUES (600)";
			  statement.executeUpdate(sql);
				      
			  System.out.println("Inserted records into the table...");
			  
		  } 
		  catch (Exception e) {
			  System.out.println(e.getMessage());  
		  }  
	} // end of insertIntoDataBase()

	  
	  public static void main(String[] args) throws Exception {
		  JDBC dao = new JDBC();
	      dao.createDataBase();
	      dao.insertIntoDataBase();
	  } // end of main 
	  
}
