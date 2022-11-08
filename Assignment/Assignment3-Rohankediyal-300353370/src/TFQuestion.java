
public class TFQuestion extends Question {
  public TFQuestion(String questionText, boolean answer,double point) {
		super(questionText);
		this.answer = answer;
		this.point = point;
	}

public boolean isAnswer() {
		return answer;
	}

	public void setAnswer(boolean answer) {
		this.answer = answer;
	}

private boolean answer;
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
