
public class Model {

	public int id;
	public String line;
	public String name;
	public int zone;

	
	

	public Model(int id, String line, String name, int zone) {
		super();
		this.id = id;
		this.line = line;
		this.name = name;
		this.zone = zone;
	}
	
	
	public Model() {
		super();
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getZone() {
		return zone;
	}
	public void setZone(int zone) {
		this.zone = zone;
	}
	
	
	@Override
	public String toString() {
		return "Model [id=" + id + ", line=" + line + ", name=" + name + ", zone=" + zone + "]";
	}



	
	
	
}
