import java.util.ArrayList;

public class MCQuestion extends Question {
	


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
