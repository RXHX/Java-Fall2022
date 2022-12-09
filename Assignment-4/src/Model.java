
public class Model {
	
	
	@Override
	public String toString() {
		return "Model [id=" + id + ", sName=" + sName + ", sID=" + sID + ", cCode=" + cCode + ", cTitle=" + cTitle
				+ ", grade=" + grade + "]";
	}
	int id;
	String sName;
	String sID;
	String cCode;
	String cTitle;
	String grade;

	
	public Model() {
		super();
	}

	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsID() {
		return sID;
	}
	public void setsID(String sID) {
		this.sID = sID;
	}
	public String getcCode() {
		return cCode;
	}
	public void setcCode(String cCode) {
		this.cCode = cCode;
	}
	public String getcTitle() {
		return cTitle;
	}
	public void setcTitle(String cTitle) {
		this.cTitle = cTitle;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}

	
}
