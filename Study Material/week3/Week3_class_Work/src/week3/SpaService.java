package week3;

public class SpaService {
	
	
	
	public String displayInfo()
	{

		return this.getServiceDescription()+" $ "+this.getPrice();
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getServiceDescription() {
		return serviceDescription;
	}

	private String serviceDescription;
	private double price;
	
	public void setServiceDescription(String serviceDescription)
	{
		   this.serviceDescription = serviceDescription;
	}
	
	

}
