
public class TFQuestion extends Question {
	

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
