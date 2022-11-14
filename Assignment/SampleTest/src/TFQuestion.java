import java.util.Scanner;

public class TFQuestion extends Question {
	

	
	
	
	
	@Override
	public String toString() {
		
		char ch = 'A';
		String userAnswer= "";
	   double sum = 0;
		 Scanner sc = new Scanner(System.in);
		String userResult = "";
			System.out.println(getQuestionText()
					+"("+getPoint()
					+" Points)");
		
		   System.out.print("True(T) or False(F) >> ");
		   userAnswer = sc.nextLine();
		   
		   if(checkAnswer(userAnswer))
		   {
			   System.out.println();
			   sum = sum + getPoint();
			   userResult = "You are correct!"+sum;
		   }
		   else {
			   userResult = "You are wrong. The correct answer is "+getAnswer()+".";
		   }
		
		return userResult;
	}

private boolean answer;

public TFQuestion() {
		super();
	}

public TFQuestion(String questionText, boolean answer,double point) {
		super(questionText);
		this.answer = answer;
		
	}


public boolean getAnswer() {
	return answer;
}

	public void setAnswer(boolean answer) {
		this.answer = answer;
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

		if(getAnswer())
		{
		  return "T";	
		}
		else {
			return "F";
		}
		
	}

}