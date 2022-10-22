import java.io.BufferedReader;
import java.io.FileReader;

public class Course {






	public Course() {
		super();
	}




    public  int getSno() {
		return Sno;
	}




	public void setSno(int sno) {
		Sno = sno;
	}

	private  int Sno;
	private  String code;
	private  int credit;
	private  String grade;


	
	public String getCode() {
		return code;
	}




	public void setCode(String code) {
		this.code = code;
	}




	public int getCredit() {
		return credit;
	}




	public void setCredit(int credit) {
		this.credit = credit;
	}




	public String getGrade() {
		return grade;
	}




	public void setGrade(String grade) {
		this.grade = grade;
	}



	
	
	
	
	

	
	
	
	
	@Override
	public String toString() {
		return "Course #"+getSno()+":"+getCode() + "(" + getCredit() + " credit):" + getGrade();
	}


	
}
