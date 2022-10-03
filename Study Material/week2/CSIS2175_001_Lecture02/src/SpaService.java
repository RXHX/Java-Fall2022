
public class SpaService {

	private String serviceDescription;
	private double price;

	public SpaService() {
		serviceDescription = "";
		price = 0.0;
	}

	public void displayServiceInfo() {
		System.out.println(this.getServiceDescription() + " $" + this.getPrice());
	}

	public String getServiceDescription() {
		return serviceDescription;
	}

	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
