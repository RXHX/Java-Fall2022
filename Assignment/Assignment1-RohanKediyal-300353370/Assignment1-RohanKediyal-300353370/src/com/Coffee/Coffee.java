package com.Coffee;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Coffee {
	
	
	public static double coffeePrice;
	public static double largePrice;
	public static double mediumPrice;
	public static double smallPrice;
	public static String name;
	public static  char size;
	
	
	public  Coffee(double smallPrice,double mediumPrice,double largePrice,String name) {
		this.smallPrice = smallPrice;
		this.mediumPrice =mediumPrice;
		this.largePrice = largePrice;
		this.name = name;
		
	}
	
	
	
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
		  
		  sc.close();
		  return coffeePrice;
	  }
	

}
