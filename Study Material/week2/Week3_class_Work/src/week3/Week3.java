package week3;

import java.util.Scanner;

public class Week3 {

	
	
	
	
	// defining method for finding then weekly discount

	public static double computePrice(double discount, double saving) {

		return discount * saving / 100;
	}

	// Defining the method and calling the method
	public static void displayInfo() {
		System.out.println("Paradise Day Spa wants to handle");
		System.out.println("We will make you look good");
	}
	
	// display menu Item Program
	public static void displayMenuItem(SpaService spaServ)
	{
		System.out.println("Service Item:");
		spaServ.displayInfo();
		
	}
	
	public static void runObjectDemo()
	{
		SpaService firstService;
		firstService = new SpaService();
		  
		
		
		String service ;
		double price;
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Service >> ");
		service = scanner.nextLine();
		System.out.println("Enter the Price >> ");
		price =  scanner.nextDouble();
         
		// set the values
		firstService.setServiceDescription(service);
		firstService.setPrice(price);
	
		
		  displayMenuItem(firstService);
		
		
		// get the values
		// 1 method to display Info
		System.out.println("Service Details :");
		System.out.println(firstService.getServiceDescription());
	    System.out.println(firstService.getPrice());
	
	   // 2 method to display Info
	    System.out.println(firstService.displayInfo());;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		displayInfo();
		String price;
		String newPrice;
		double Mprice;
		double discount;
		double saving;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Cut off Price:");
		// price = sc.nextDouble();
		// this will print only first word of the first Line
		price = sc.next();
		System.out.println(price);
		sc.nextLine();
		System.out.println("Enter the Cut off Price:");
		newPrice = sc.nextLine();

		System.out.println(newPrice);

		System.out.println("Enter the discount Amount");
		discount = sc.nextDouble();

		System.out.println("Enter the Price Amount");
		Mprice = sc.nextDouble();

		System.out.println(computePrice(discount, Mprice));

		
		  runObjectDemo();
	}

}
