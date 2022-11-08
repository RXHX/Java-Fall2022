import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	

	MCQuestion mcq = null;
	TFQuestion tQuestion = null;
	
	
	
	
	
	
	
	public static void mcqtypeQuestionCreation()
	{
		String question;
		int numberOfOption;
		char ch='A';
		ArrayList<String> optionsValue = null;
		int points;
		
		Scanner mcq = new Scanner(System.in);
		System.out.println("Enter the question text >>");
		  question = mcq.nextLine();
		System.out.println("How many options? ");
		numberOfOption = mcq.nextInt();
		
		for(int i = 0; i < numberOfOption; i++) {
			char option = (char) (ch + i);
			System.out.println("Enter Option "+option+"(Start with * for correct answer) >>");
		    optionsValue.add(mcq.nextLine());
		}
		System.out.println("How many points?");
		points = mcq.nextInt();
		
		      
		  
	}
	
	public static void trueFalseQuestionCreation()
	{
		
		
	}
	
	public static void questionCreation()
	{
		String questionType;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the type of question (MC or TF) >>");
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
	
	public static void welcome()
	{
		Scanner sc = new Scanner(System.in);
		String choice =  "";
		do {
			
			System.out.println("Please choose (c)reate a question, (p)review or (e)xit >>");
			choice = sc.nextLine();
			switch(choice)
			{
			case "c","C":
				questionCreation();
				break;
			case "p","P":
				
				break;
			case "e","E":
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
