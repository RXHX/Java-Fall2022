import java.util.ArrayList;
import java.util.Scanner;



public class MCQuestion extends Question {
	
	public String askUserOption()
	{
		
		char ch = 'A';
	
	   
	   String options = "";

			for(int l=0;l<getOptions().size();l++)
			{
				char option = (char) (ch + l);
				options = options + option+": "+getOptions().get(l)+"\n";
			}
			 
			return options;
		
	}
	
	public String askUserChoice()
	{
		 Scanner sc = new Scanner(System.in);
		 double sum = 0; 
		System.out.print("Enter your choice >> ");
		String userAnswer= "";
		userAnswer = sc.nextLine();
		String userResult = " ";
		if(userAnswer.equals(getAnswer()))
		{
			userResult = "You are correct!";
			sum = sum + getPoint();
		}
		else {
			userResult = "You are wrong. The correct answer is "+ getAnswer()+".";
		}

		return userResult;
	}

	@Override
public String toString() {
		
		System.out.println(getQuestionText()+"("+getPoint()
		+" Points)");
		System.out.println(askUserOption());
		
	return askUserChoice();
	}
	
	
private  ArrayList<String> options = new ArrayList<>();
	
	public ArrayList<String> getOptions() {
		return options;
	}

	private String answer;
	  
	public MCQuestion() {
		super();
	}

	public MCQuestion(String questionText, ArrayList<String> options, double point) {
		super(questionText);
		this.options = options;
	}
	

	public String getAnswer() {
		return answer;
	}
	
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public void addOption(String option)
	{
		
		options.add(option);
	}
  
	@Override
	boolean checkAnswer(String answer) {
		if(answer.equals(getCorrectAnswer()))
		{
			return true;
		}
		else {
			return false;	
		}
		
	}

	@Override
	String getCorrectAnswer() {
		// TODO Auto-generated method stub
		return getAnswer();
	}

		
		
	}

	
