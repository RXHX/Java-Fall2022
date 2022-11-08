import java.util.ArrayList;

public class MCQuestion extends Question {
 
	public MCQuestion(String questionText) {
		super(questionText);
	}

	
	public void addOption(String option)
	{
		
		
	}
	public MCQuestion(String questionText, ArrayList<String> options, String answer) {
		super(questionText);
		this.options = options;
		this.answer = answer;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

private  ArrayList<String> options;
  private String answer;
  
	@Override
	boolean checkAnswer(String answer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	String getCorrectAnswer() {
		// TODO Auto-generated method stub
		return null;
	}

}
