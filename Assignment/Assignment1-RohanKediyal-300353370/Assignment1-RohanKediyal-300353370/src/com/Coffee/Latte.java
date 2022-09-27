package com.Coffee;
import java.text.DecimalFormat;
import java.util.Formatter;
import java.util.Scanner;
public class Latte {

	public static double coffeePrice;
	public static double largePrice = 5.00;
	public static double mediumPrice = 4.45;
	public static double smallPrice = 3.70;
	public static  char size;
	
	 public static double CoffeePrice()
	  {
		 Scanner sc = new Scanner(System.in);
		 DecimalFormat formatter = new DecimalFormat("##.00");
		
		 System.out.print("Please choose the size (S/M/L):\r\n"
		       		+ "(S)mall:$"+formatter.format(smallPrice)
		       		+" / (M)edium:$"+formatter.format(mediumPrice)+
		       		" / (L)arge:$"+formatter.format(largePrice)+" >>");
		  size = sc.next().charAt(0);
		 
		  switch(size)
		  {
		  
		  case 'S','s':
			  coffeePrice = smallPrice; 
			  break;
		  case 'M','m':
			  coffeePrice = mediumPrice;
			  break;
		  case 'L','l':
			  coffeePrice = largePrice;
			  break;	  
		  default:
			  System.out.println("Please enter the correct Coffee Size");
             break; 		  

		  }
		  
		  
		  return coffeePrice;
	  }
	
	
}
