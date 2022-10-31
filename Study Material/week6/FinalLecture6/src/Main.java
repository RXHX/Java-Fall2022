import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

	final static int SIZE=10;
	
	public static void arrayDemo()
	{
		int[] anArray = new int[SIZE];
		int input;
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
			for(int i=0;i<SIZE;i++)
		{
			anArray[i] = random.nextInt(100);
	     }
	
		System.out.println("Before Sorting.....");
		for(int x : anArray)
		{
			System.out.print(x+" ");
		}
	   System.out.println();
	   Arrays.sort(anArray);
		System.out.println("After Sorting.......");
		for(int x : anArray)
		{
			System.out.print(x+" ");
		}
	
		System.out.print("\nEnter the key for search ");
		input = sc.nextInt();
		
		System.out.print(input+" is in position "+Arrays.binarySearch(anArray, input));
		
		System.out.println("\nGet Element at particular position");
		
		ArrayList<Student> students = new ArrayList<Student>();
		students.add(new Student());
		students.add(new Student());
		students.add(new Student());
		
	  students.get(0).setName("Rohan kediyal");
		
	}
	
	
	public static void arrayListDemo()
	{
		ArrayList<Integer> aList = new ArrayList<Integer>();
		Random random = new Random();
		for(int i=0;i<SIZE;i++)
		{
		  int x = random.nextInt(100);
		  aList.add(x);
		}
	
	System.out.println("\nArray List Element: List");
	   for(Integer x : aList)
	   {
		   System.out.print(x+" ");
	   }
	
		System.out.println("\nArray List Remove Element at position 0");
		aList.remove(0);
		   for(Integer x : aList)
		   {
			   System.out.print(x+" ");
		   }
	   
	   
	   
	}
	
	
	public static void twoDimArrayDemo()
	{
		final int ROWS = 5;
		final int COLS = 3;
		
		int[][] tables = {
				{ 2,3,4 },{ 20,34,56 },{300,32,4,24}
				
		};
		
		
		// tables.length gives the row size
		
		for(int i=0;i<tables.length;i++)
		{
		for(int j=0; j<tables[i].length; j++)
		{
			System.out.print(tables[i][j]+"\t");
		}
			
		}
		
	}
	
	public static void dbDemo()
	{
		// variables
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		// Step 1: Loading or registering ucanaccess 
		// JDBC driver class
		try {
		 Class.forName(
		 "net.ucanaccess.jdbc.UcanaccessDriver");
		} catch (ClassNotFoundException cnfex) {
		 System.out.println("Problem in loading or " +
		 "registering MS Access JDBC driver");
		 cnfex.printStackTrace();
		}
		try {
		 String msAccDB = "C:/Temp/Database2.accdb";
		 String dbURL = "jdbc:ucanaccess://" + 
		 msAccDB;
		 // Step 2.A: Create and get connection 
		 // using DriverManager class
		 connection = 
		 DriverManager.getConnection(dbURL);
		 // Step 2.B: Creating JDBC Statement
		 statement = connection.createStatement();
		 // Step 2.C: Executing SQL & retrieve 
		 // data into ResultSet
		 resultSet = statement.executeQuery(
		 "SELECT * FROM EMPLOYEE");
		 while (resultSet.next()) {
		 int id = resultSet.getInt(1);
		 String name = resultSet.getString(2);
		 Double salary = resultSet.getDouble(3);
		 System.out.println("Employee #" + id + 
		 ": " + name + ", " + salary);
		 }
		} catch (SQLException sqlex) {
		 sqlex.printStackTrace();
		} finally {
		 // Step 3: Closing database connection
		 try {
		 if (connection != null) {
		 // cleanup resources, once 
		 // after processing
		 resultSet.close();
		 statement.close();
		 // and then finally close connection
		 connection.close();
		 }
		 } catch(SQLException sqlex) {
		 sqlex.printStackTrace();
		 }
		}
		
	}
	
	public static void enumDemo()
	{
		Color color = null;
		
		color = color.BLACK;
		System.out.println("\nColour is: "+color);
		System.out.println("\nPosition of Colour is: "+color.ordinal());
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	      arrayDemo();	
	      arrayListDemo();
	      twoDimArrayDemo();
		  enumDemo();
		  dbDemo();
	}

}
