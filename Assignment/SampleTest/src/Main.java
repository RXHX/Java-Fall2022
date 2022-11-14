
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static MCQuestion[] mcqquestions = new MCQuestion[100];
	public static TFQuestion[] tquestions = new TFQuestion[100];
	public static Question[] questions =  new Question[100];
	public static int mcquestionsCount = 0;
	public static int trueFalseQuestionsCount = 0;
	public static int questionsCount = 0;  
	public static String question;
	public static double points;
	public static char ch='A';
	
	
	public static Connection connection = null;
	public static Statement statement = null;


	public static void dbInit() {
		
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Unable to load driver.");
			e.printStackTrace();
		}

		String msAccDB = "Question.accdb";
		String dbURL = "jdbc:ucanaccess://" + msAccDB;

	
		try {
			connection = DriverManager.getConnection(dbURL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public static void insertRecordMCQ(String QText, ArrayList<String> Answer, double Point, String Type) {
	
		
		String sendInformation = ""; 
		
		try {
			
			for(int i=0;i<Answer.size();i++)
			{
				sendInformation =   sendInformation +Answer.get(i)+"##";
			}
			
			sendInformation = sendInformation.substring(0,sendInformation.length() - 2);

			String sqlStr = "INSERT INTO QUESTIONS (QText,Answer,Point,Type) VALUES " 
					+ "('"
					+QText
					+"'"+
					",'"
					+sendInformation
					+"'"
					+","
					+Point
					+",'"
					+Type
					+"')";
			statement.executeUpdate(sqlStr);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	public static void insertRecordTF(String QText, boolean Answer, double Point, String Type)
	{
		
		String ans =  Answer+"";
		
		String sqlStr = "INSERT INTO QUESTIONS (QText,Answer,Point,Type) VALUES " 
				+ "('"
				+QText
				+"'"+
				",'"
				+ans
				+"'"
				+","
				+Point
				+""
				+",'"
				+Type
				+"'"
				+");";
	
		
		try {
			statement.executeUpdate(sqlStr);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void dbClose() {
		// Step 3: Close the connection
		try {
			connection.close();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	public static void mcqtypeQuestionCreation()
	{
		
		int numberOfOption;
		
		ArrayList<String> temporaryStorage = new ArrayList<>();
		String optionAvailable = "";
		String correctAnswer = "";
		Scanner mcq = new Scanner(System.in);
		System.out.print("Enter the question text >> ");
		  question = mcq.nextLine();
		System.out.print("How many options? ");
		numberOfOption = mcq.nextInt();
		mcq.nextLine();
		 mcqquestions[mcquestionsCount] = new MCQuestion();
		for(int i = 0; i < numberOfOption; i++) {
			char option = (char) (ch + i);
			System.out.print("Enter Option "+option+"(Start with * for correct answer) >> ");
			optionAvailable = mcq.nextLine();
			temporaryStorage.add(optionAvailable);
			if(optionAvailable.charAt(0) == '*')
			{
			correctAnswer = option+""; 
			optionAvailable = optionAvailable.substring(1,optionAvailable.length());
			}	
			mcqquestions[mcquestionsCount].addOption(optionAvailable);	
		}
		System.out.print("How many points? ");
		points = mcq.nextDouble();	
		
		 mcqquestions[mcquestionsCount].setQuestionText(question);  
		 mcqquestions[mcquestionsCount].setPoint(points);	  
	     mcqquestions[mcquestionsCount].setAnswer(correctAnswer);
	     questions[mcquestionsCount] =  mcqquestions[mcquestionsCount];
	    insertRecordMCQ(mcqquestions[mcquestionsCount].getQuestionText(), temporaryStorage,points,"MC");
	    questions[questionsCount] =  questions[mcquestionsCount];
	    mcquestionsCount++;
	    questionsCount++;
	}
	
	public static void trueFalseQuestionCreation()
	{
		Scanner truefalse = new Scanner(System.in);
		boolean answer;
		
		System.out.print("Enter the question text >> ");
		question = truefalse.nextLine();
		System.out.print("Answer is True or False? ");
		answer = truefalse.nextBoolean();
        System.out.print("How many points? ");
        points = truefalse.nextDouble();
        
        tquestions[trueFalseQuestionsCount]= new TFQuestion();
        tquestions[trueFalseQuestionsCount].setQuestionText(question);
        tquestions[trueFalseQuestionsCount].setAnswer(answer);
        tquestions[trueFalseQuestionsCount].setPoint(points);
        insertRecordTF(question, answer, points, "TF");
       
        questions[questionsCount] = tquestions[trueFalseQuestionsCount];
        trueFalseQuestionsCount++;
        questionsCount++;
        
	}
	
	public static void questionCreation()
	{
		String questionType;
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the type of question (MC or TF) >> ");
	    questionType = input.nextLine();
	    switch(questionType)
	    {
	    case "MC","mC","Mc","mc": mcqtypeQuestionCreation();
        	    break;
	    case "TF","tf","Tf","tF": trueFalseQuestionCreation();
	           break;
	   default: break;
	    }
	}
	
	
	public static void previewResult()
	{
	    Scanner sc = new Scanner(System.in);
		String userAnswer = "";
		double sum = 0.0;	
			for(int i=0;i<mcqquestions.length;i++)
			{

				if(mcqquestions[i] != null)
					{
				System.out.println(mcqquestions[i]);
					}	
				
			
			}
			
			for(int i=0;i<tquestions.length;i++)
			{
				
				
				if(tquestions[i] != null)
					{
				System.out.println(tquestions[i]);
					}
				
			}
			
	
		
		
		
		
		
	
		System.out.println("The quiz ends. Your score is "+sum+".");
		
	}
	
	public static void welcome()
	{
		dbInit();
		Scanner sc = new Scanner(System.in);
		String choice =  "";
		do {
			
			System.out.print("Please choose (c)reate a question, (p)review or (e)xit >> ");
			choice = sc.nextLine();
			switch(choice)
			{
			case "c","C":
				questionCreation();
				break;
			case "p","P":
				previewResult();
				break;
			case "e","E":
				dbClose();
				System.out.println("Goodbye!");
				System.exit(0); 
			break;
			default: break;
			}
			
		}while(!choice.equalsIgnoreCase("E"));		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		welcome();
		
	}

}