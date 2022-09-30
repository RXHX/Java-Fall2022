import java.text.DecimalFormat;
import java.util.Scanner;

public class Lecture02Demo {

	public static void displayMenuItem(SpaService spaService) {
		System.out.println("Service Item:");
		spaService.setServiceDescription("XXXX");
		spaService.displayServiceInfo();
	}
	
	
	public static void displayInfo() {
		System.out.println("Paradise Day Spa wants to pamper you.");
		System.out.println("We will make you look good.");

		int x = 0;
		if (x == 0) {
			System.out.println("x: " + x);
			return;
		}

		System.out.println("Bye!");

	}

	public static void runObjectDemo() {

		SpaService firstService;
		firstService = new SpaService();

		SpaService secondService;
		secondService = new SpaService();

		secondService = firstService;

		String service;
		double price;
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter service >> ");
		service = scanner.nextLine();

		System.out.print("Enter price >> ");
		price = scanner.nextDouble();

		firstService.setServiceDescription(service);
		firstService.setPrice(price);

		displayMenuItem(firstService);
		
		System.out.println("Calling firstService.displayServiceInfo();");
		firstService.displayServiceInfo();
		
//		System.out.println("Service Details:");
//		firstService.displayServiceInfo();
//		
//		secondService.setServiceDescription("XXX");
//		secondService.setPrice(1000);
//
//		System.out.println("First Service Details:");
//		firstService.displayServiceInfo();
//
//		System.out.println("Second Service Details:");
//		secondService.displayServiceInfo();

	}

	public static void main(String[] args) {

		runObjectDemo();

//		displayInfo();
//
//		DecimalFormat formatter = new DecimalFormat("$###,###.00");
//		
//		double price;
//		double discount;
//		double savings;
//		Scanner scanner = new Scanner(System.in);
//
//		System.out.print("Enter cutoff price >> ");
//		price = scanner.nextDouble();
//
//		System.out.print("Enter discount rate >> ");
//		discount = scanner.nextDouble();
//
//		savings = computeDiscount(price, discount);
//
//		System.out.println("Speical this week on any service over $" + 
//				formatter.format(price));
//		System.out.println("Discount of " + formatter.format(discount) + " percent");
//		System.out.println("That's a savings of at least $" + 
//				formatter.format(savings));

	}

	public static double computeDiscount(int price, int discount) {

		double savings;
		savings = price * discount / 100;
		return savings;

	}

	public static double computeDiscount(double price) {

		double savings;
		savings = price * 10 / 100;
		return savings;

	}

	public static double computeDiscount(double price, double discount) {

		double savings;
		savings = price * discount / 100;
		return savings;

	}

}
