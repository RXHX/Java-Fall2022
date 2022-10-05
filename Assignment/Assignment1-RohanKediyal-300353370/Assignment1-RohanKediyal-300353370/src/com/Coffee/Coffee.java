package com.Coffee;
// Imported the Packages 
import java.text.DecimalFormat;
import java.util.Scanner;

// Model Class Coffee
// Will help in dealing with all type of Coffees
// Cappuccino, Latte, and others
public class Coffee {
	
	// data members
	public  double coffeePrice;
	public  double largePrice;
	public  double mediumPrice;
	public  double smallPrice;
	public  String name;
	public   char size;
	
	// parameterized Constructor
	public  Coffee(double smallPrice,double mediumPrice,double largePrice,String name) {
		this.smallPrice = smallPrice;
		this.mediumPrice =mediumPrice;
		this.largePrice = largePrice;
		this.name = name;
		
	}
	
	
	// method to calculate the Coffee Price
	 public  double CoffeePrice()
	  {
		 // object creation of Scanner Class
		 Scanner sc = new Scanner(System.in);
		 // object creation of DecimalFormat Class
		 DecimalFormat formatter = new DecimalFormat("##.00");
		
		 // Print the result in a formatted Way
		 System.out.print("Please choose the size (S/M/L):\r\n"
		       		+ "(S)mall:$"+formatter.format(smallPrice)
		       		+" / (M)edium:$"+formatter.format(mediumPrice)+
		       		" / (L)arge:$"+formatter.format(largePrice)+" >>");
		 // input the user choice 
		 size = sc.next().charAt(0);
		 
		 // Switch case block
		  switch(size)
		  {
		  
		  // For Small Size Coffee
		  case 'S','s':
			  coffeePrice = smallPrice; 
			  break;
		  // For Medium  Size Coffee
		  case 'M','m':
			  coffeePrice = mediumPrice;
			  break;
		  // For the Large Size Coffee
		  case 'L','l':
			  coffeePrice = largePrice;
			  break;	  
		// If any other coffee size is chosen
		  default:
			  System.out.println("Please enter the correct Coffee Size");
             break; 		  

		  }
		  
		// return the coffeePrice Value
		  return coffeePrice;
	  }
	

}
