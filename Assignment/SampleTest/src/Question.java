
 abstract class Question {
	
	public Question(String questionText) {
		super();
		this.questionText = questionText;
	}
	abstract boolean checkAnswer(String answer);
	
	abstract String getCorrectAnswer();
	

	public String getQuestionText() {
		return questionText;
	}


	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}


	public double getPoint() {
		return point;
	}


	public void setPoint(double point) {
		this.point = point;
	}


	private String questionText;
	 private double point;
	 
	 
	 public Question() {
			super();
		}
	 
	
	
}