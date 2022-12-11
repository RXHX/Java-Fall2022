import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Controller {

	
	
	static Connection connection = null;
	static Statement statement = null;
	static ResultSet resultSet = null;
    static Model[] trains = new Model[57];
	public Model[] dBDemo() {

		// Step 1: Loading the ucanaccess driver
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Unable to load driver.");
			e.printStackTrace();
		}

		try {
			String msAccDB = "SkytrainFare.accdb";
			String dbURL = "jdbc:ucanaccess://" + msAccDB;

			// Step 2.A: Creating and getting connection
			connection = DriverManager.getConnection(dbURL);

			// Step 2.B: Creating JDBC Statement
			statement = connection.createStatement();

			// Step 2.C: Executing SQL query and process results if any
			String sqlStr = "SELECT * FROM Stations" + "";
			resultSet = statement.executeQuery(sqlStr);
            
			// index 
			int index = 0;
			while (resultSet.next()) {
				
				if(index != 58 )
				{
					Model newtrain = new Model();
				    newtrain.setId(resultSet.getInt("ID"));
				    newtrain.setLine(resultSet.getString("Line"));
				    newtrain.setName(resultSet.getString("Name"));
				    newtrain.setZone(resultSet.getInt("Zone"));
					trains[index] = newtrain;
					index++;
				}
				
			}
         
			

		} catch (SQLException e) {
			e.printStackTrace();

		}

		return trains;
		
	}
	
	public void closedB()
	{
		// Step 3: Close the connection
					try {
						connection.close();
						statement.close();
						resultSet.close();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
		
	}
	
	
	
}
