import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	
	
	private static String StudentID = "../MidtermPrcatice/src/";
	public static Course[] cour = new Course[100];
	
public static  void WelcomeMessage()
{
	
	System.out.println("Welcome to Student Info. System.");
}






public static void PrintInfo()
{
	
	for(int i=0;i<cour.length;i++)
	{
		if(cour[i] != null)
		System.out.println(cour[i]);
	}
}



public static void ReadFile(String studentId)
{
	

	

		
		switch(studentId)
		{
		
		
		case "300123456": specificFileRead(studentId); break;
		case "300198765": specificFileRead(studentId); break;
		
		
		}
 			
		
	
	
	
	
}
	
private static  void specificFileRead(String studentId)
{

	

	String TempStudentID = StudentID+studentId;
	
	BufferedReader br = null;
	PrintWriter pw = null;
	try {
		FileReader fr =  new FileReader(TempStudentID);
		br = new BufferedReader(fr);
		String sCurrent = " ";
		pw = new PrintWriter(new File("../MidtermPrcatice/src/output")); 
		while((sCurrent = br.readLine()) != null)
		 {
			    String[] info = sCurrent.split(",");
			 
			  pw.println("count:"+info[0]);

			  pw.println("info:"+info[1]);

			  pw.println("count variable :"+info[2]);
		 
		 }
		 
		pw.close();
		br.close();
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	


}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String choice;
	
		 Scanner sc = new Scanner(System.in);
		 Course info = new Course();
		do {
			
			System.out.println("Please select an option: \r\n"
					+ "(R)ead a student report\r\n"
					+ "(S)how all courses and GPA\r\n"
					+ "(E)xit ");
	    System.out.print("\r\n"
	    		+ "Enter your option >>");
		choice = sc.nextLine();
		String StudentId = "";
		  System.out.print("Enter the student ID >>");
		switch(choice) 
		{
		case "R":
			   
			     StudentId = sc.nextLine();
		
			     ReadFile(StudentId);
			      break;
		case "S":  
	            
	             PrintInfo();
		  			      break;
		
		
		
		}
		
		
			
			
		}while(!choice.equalsIgnoreCase("E"));
		
		
		
		
	}

}
