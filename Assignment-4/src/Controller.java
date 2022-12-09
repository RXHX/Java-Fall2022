import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Controller {
	static Connection connection = null;
	static Statement statement = null;
	static ResultSet resultSet = null;
    static Model[] stud = new Model[10];
	public Model[] dBDemo() {

		// Step 1: Loading the ucanaccess driver
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Unable to load driver.");
			e.printStackTrace();
		}

		try {
			String msAccDB = "Studentcourse.accdb";
			String dbURL = "jdbc:ucanaccess://" + msAccDB;

			// Step 2.A: Creating and getting connection
			connection = DriverManager.getConnection(dbURL);

			// Step 2.B: Creating JDBC Statement
			statement = connection.createStatement();

			// Step 2.C: Executing SQL query and process results if any
			String sqlStr = "SELECT * FROM GRADES" + "";
			resultSet = statement.executeQuery(sqlStr);
            
			// index 
			int index = 0;
			while (resultSet.next()) {
				Model newStud = new Model();
				newStud.setId(resultSet.getInt(1));
				newStud.setsName(resultSet.getString(2));
				newStud.setsID(resultSet.getString(3));
				newStud.setcCode(resultSet.getString(4));
				newStud.setcTitle(resultSet.getString(5));
				newStud.setGrade(resultSet.getString(6));
				stud[index] = newStud;
				index++;
			}
         
			// Step 3: Close the connection
			connection.close();
			statement.close();
			resultSet.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}

		return stud;
		
	}
	
}
