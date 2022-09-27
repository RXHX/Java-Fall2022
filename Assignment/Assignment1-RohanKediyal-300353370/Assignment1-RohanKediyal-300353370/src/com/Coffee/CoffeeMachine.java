package com.Coffee;

import java.text.DecimalFormat;
import java.util.Scanner;

/*
 * 
 * 
 Enter the coffee number >> 3
Please choose the size (S/M/L):
(S)mall: $3.70 / (M)edium: $4.55 / (L)arge: $5.00 >> M
Do you want (M)ilk, (C)ream or (N)one? C
How many cream do you want? 2
How many sugar do you want? 2
Confirm you order (Y/N): Y
Thank you for your purchase!
Your Medium Cappuccino (2 Cream and 2 Sugar) is ready to serve.
Total cost: $4.78
 * 
 * 
 * 
 * 
 */
public class CoffeeMachine {

	public static double coffeePrice;
	public static int milkCount = 0;
	public static int creamCount = 0;
	public static int sugarCount = 0;
	  public static void dispalyMenu()
	  {
		  System.out.println("Welcome to N&I Cafe\r\n"
		  		+ "Please choose your coffee\r\n"
		  		+ "Coffee 1: Latte\r\n"
		  		+ "Coffee 2: Americano\r\n"
		  		+ "Coffee 3: Cappuccino\r\n"
		  		+ "Coffee 4: Caramel Macchiato\r\n"
		  		+ "Coffee 5: Mocha");		  
	  }
	  

	  public static void chooseAddons(char addon,Scanner sc)
	  {
		  switch(addon)
		  {
		  
		  case 'M','m': 
			        System.out.print("How many milk do you want?");
			        milkCount =sc.nextInt();
			        System.out.print("How many sugar do you want?");
	                sugarCount = sc.nextInt();
			        break;
		  case 'C','c':
		      System.out.print("How many cream do you want?");
			    creamCount = sc.nextInt();
		        System.out.println("How many sugar do you want?");
                sugarCount = sc.nextInt();
		        break;
		  case 'N','n':
			  System.out.println("How many sugar do you want?");
              sugarCount = sc.nextInt();
			  break;
		  
		  
		  
		  }
		  
		  
	  }
	  
	  public static String computeBill()
	  {
		  DecimalFormat formatter = new DecimalFormat("##.00");
		  return formatter.format((coffeePrice)+(coffeePrice * 0.05));
	  }
	
	  public static void confirmOrder(char orderConfirmation,char addon, char size, String name, Scanner sc  )
	  {
		  if(orderConfirmation == 'Y'|| orderConfirmation == 'y')
	      {
	    	  System.out.println("Thank you for your purchase!");
	    	  if(addon == 'M' || addon == 'm')
   	    	  {
                switch(size)
                {
                
                case 'S','s':
      			 System.out.println("Your Small Latte ("+milkCount+" Milk and "+sugarCount+" Sugar) is ready to serve.");
      			 System.out.println("Total cost: $"+computeBill());
      			  break;
      		  case 'M','m':
     			 System.out.println("Your Medium Latte ("+milkCount+" Milk and "+sugarCount+" Sugar) is ready to serve.");
      			 System.out.println("Total cost: $"+computeBill());
      			 break;
      		  case 'L','l':
      			System.out.println("Your Large Latte ("+milkCount+" Milk and "+sugarCount+" Sugar) is ready to serve.");
      			 System.out.println("Total cost: $"+computeBill());
      			 break;	  
      	    
               default : break;        
                }
	    		  
	    		  
	    	  }
	    	  else if(addon == 'C' || addon == 'c')
	    	  {
	    		  switch(size)
                    {
                    
                    case 'S','s':
          			 System.out.println("Your Small Latte ("+milkCount+" Milk and "+sugarCount+" Sugar) is ready to serve.");
          			 System.out.println("Total cost: $"+computeBill());
          			  break;
          		  case 'M','m':
         			 System.out.println("Your Medium Latte ("+milkCount+" Milk and "+sugarCount+" Sugar) is ready to serve.");
          			 System.out.println("Total cost: $"+computeBill());
          			 break;
          		  case 'L','l':
          			System.out.println("Your Large Latte ("+milkCount+" Milk and "+sugarCount+" Sugar) is ready to serve.");
          			 System.out.println("Total cost: $"+computeBill());
          			 break;	  
          	    
                   default : break;        
                    } 
	    		  
	    		  
	    	  }
	    	  else if(addon =='N' || addon == 'n')
	    	  {
	    		  switch(size)
                    {
                    
                    case 'S','s':
          			 System.out.println("Your Small Latte ("+milkCount+" Milk and "+sugarCount+" Sugar) is ready to serve.");
          			 System.out.println("Total cost: $"+computeBill());
          			  break;
          		  case 'M','m':
         			 System.out.println("Your Medium Latte ("+milkCount+" Milk and "+sugarCount+" Sugar) is ready to serve.");
          			 System.out.println("Total cost: $"+computeBill());
          			 break;
          		  case 'L','l':
          			System.out.println("Your Large Latte ("+milkCount+" Milk and "+sugarCount+" Sugar) is ready to serve.");
          			 System.out.println("Total cost: $"+computeBill());
          			 break;	  
          	    
                   default : break;        
                    }
	    		  
	    		  
	    	  }
	      }
	      else if(orderConfirmation == 'N'|| orderConfirmation == 'n')
	      {
	    	  System.exit(0);
	      }
	      else {
	    	  
	      }
		  
	  }
	  
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       
		Scanner sc = new Scanner(System.in);
		
		int option;  
		char addon;
		char orderConfirmation;
       while(true)
	   {
		   dispalyMenu();  
		   System.out.print("Enter the coffee number >>");
	       option = sc.nextInt();  
	       switch(option)
	       {
	       case 1: 
	    	       Latte coffeeLatte = new Latte();
	    	       coffeePrice = Latte.CoffeePrice();
	    	       System.out.print("Do you want (M)ilk, (C)ream or (N)one?");
	    	       addon = sc.next().charAt(0);
	    	       chooseAddons(addon,sc);
	    	       System.out.print("Confirm you order (Y/N):");
	    	        orderConfirmation = sc.next().charAt(0); 
	    	        confirmOrder(orderConfirmation,addon,Latte.size,"Latte",sc);
	    	     
	    	      
	    	   break;
	       case 2: 
	    	      Americano coffeeSizeAmericano = new Americano();
	    	      coffeePrice = Latte.CoffeePrice();
	    	       System.out.print("Do you want (M)ilk, (C)ream or (N)one?");
	    	       addon = sc.next().charAt(0);
	    	       chooseAddons(addon,sc);
	    	       System.out.print("Confirm you order (Y/N):");
	    	        orderConfirmation = sc.next().charAt(0); 
	    	        confirmOrder(orderConfirmation,addon,Latte.size,"Latte",sc);
	    	      break;
	       case 3:
	    	      Cappuccino coffeeSizeCappuccino = new Cappuccino();
	    	      coffeePrice = Latte.CoffeePrice();
	    	       System.out.print("Do you want (M)ilk, (C)ream or (N)one?");
	    	       addon = sc.next().charAt(0);
	    	       chooseAddons(addon,sc);
	    	       System.out.print("Confirm you order (Y/N):");
	    	        orderConfirmation = sc.next().charAt(0); 
	    	        confirmOrder(orderConfirmation,addon,Latte.size,"Latte",sc);
	    	      break;
	       case 4:
	    	      CaramelMacchiato coffeeSizeCaramelMacchiato = new CaramelMacchiato();
	    	      coffeePrice = Latte.CoffeePrice();
	    	       System.out.print("Do you want (M)ilk, (C)ream or (N)one?");
	    	       addon = sc.next().charAt(0);
	    	       chooseAddons(addon,sc);
	    	       System.out.print("Confirm you order (Y/N):");
	    	        orderConfirmation = sc.next().charAt(0); 
	    	        confirmOrder(orderConfirmation,addon,Latte.size,"Latte",sc);
	    	      break;
	       case 5: Mocha coffeeSizeMocha = new Mocha();
	       coffeePrice = Latte.CoffeePrice();
	       System.out.print("Do you want (M)ilk, (C)ream or (N)one?");
	       addon = sc.next().charAt(0);
	       chooseAddons(addon,sc);
	       System.out.print("Confirm you order (Y/N):");
	        orderConfirmation = sc.next().charAt(0); 
	        confirmOrder(orderConfirmation,addon,Latte.size,"Latte",sc);
	       break;
	       default: 
	    	   System.out.println("Please enter a valid option");
	    	   break;
	       }
		   
		  
		   
		    
	   }
	   
	
	}

}
