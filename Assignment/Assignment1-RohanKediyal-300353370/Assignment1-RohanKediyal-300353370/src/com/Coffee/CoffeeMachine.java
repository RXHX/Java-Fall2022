package com.Coffee;

import java.text.DecimalFormat;
import java.util.Scanner;
 class CoffeeMachine {

	public static double coffeePrice;
	public static int milkCount = 0;
	public static int creamCount = 0;
	public static int sugarCount = 0;
	public static boolean loopBreaker=true;
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
		        System.out.print("How many sugar do you want?");
                sugarCount = sc.nextInt();
		        break;
		  case 'N','n':
			  System.out.print("How many sugar do you want?");
              sugarCount = sc.nextInt();
			  break;
		  
		  default : 
			  System.out.println("Enter a valid input");
			  break;
		  
		  }
		  
		  
	  }
	  
	  public static String computeBill()
	  {
		  DecimalFormat formatter = new DecimalFormat("##.00");
		  return formatter.format((coffeePrice)+(coffeePrice * 0.05));
	  }
	
	  public static boolean confirmOrder(char orderConfirmation,char addon, char size, String name, Scanner sc  )
	  {
		  if(orderConfirmation == 'Y'|| orderConfirmation == 'y')
	      {
			  loopBreaker = false;
	    	  System.out.println("Thank you for your purchase!");
	    	  if(addon == 'M' || addon == 'm')
   	    	  {
                switch(size)
                {
                
                case 'S','s':
      			 System.out.println("Your Small "+name+"("+milkCount+" Milk and "+sugarCount+" Sugar) is ready to serve.");
      			 System.out.println("Total cost: $"+computeBill());
      			  break;
      		  case 'M','m':
     			 System.out.println("Your Medium "+name+"("+milkCount+" Milk and "+sugarCount+" Sugar) is ready to serve.");
      			 System.out.println("Total cost: $"+computeBill());
      			 break;
      		  case 'L','l':
      			System.out.println("Your Large "+name+"("+milkCount+" Milk and "+sugarCount+" Sugar) is ready to serve.");
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
          			 System.out.println("Your Small "+name+"("+creamCount+" Cream and "+sugarCount+" Sugar) is ready to serve.");
          			 System.out.println("Total cost: $"+computeBill());
          			  break;
          		  case 'M','m':
         			 System.out.println("Your Medium "+name+"("+creamCount+" Cream and "+sugarCount+" Sugar) is ready to serve.");
          			 System.out.println("Total cost: $"+computeBill());
          			 break;
          		  case 'L','l':
          			System.out.println("Your Large "+name+"("+creamCount+" Cream and "+sugarCount+" Sugar) is ready to serve.");
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
          			 System.out.println("Your Small "+name+"("+sugarCount+" Sugar) is ready to serve.");
          			 System.out.println("Total cost: $"+computeBill());
          			  break;
          		  case 'M','m':
         			 System.out.println("Your Medium "+name+"("+sugarCount+" Sugar) is ready to serve.");
          			 System.out.println("Total cost: $"+computeBill());
          			 break;
          		  case 'L','l':
          			System.out.println("Your Large "+name+"("+sugarCount+" Sugar) is ready to serve.");
          			 System.out.println("Total cost: $"+computeBill());
          			 break;	  
          	    
                   default : break;        
                    }
	    		  
	    		  
	    	  }
	    	  
	    	  
	      }
		return loopBreaker;
	     
		  
	  }
	  
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       
		Scanner sc = new Scanner(System.in);
		
		int option;  
		char addon;
		char orderConfirmation = 'N';
       while(loopBreaker)
	   {
		   dispalyMenu();  
		   System.out.print("Enter the coffee number >>");
	       option = sc.nextInt();  
	       switch(option)
	       {
	       case 1: 
	    	   Coffee latte = new Coffee(3.70, 4.45, 5.00, "Latte");
	    	   coffeePrice = latte.CoffeePrice();
	    	       System.out.print("Do you want (M)ilk, (C)ream or (N)one?");
	    	       addon = sc.next().charAt(0);
	    	       chooseAddons(addon,sc);
	    	       System.out.print("Confirm you order (Y/N):");
	    	        orderConfirmation = sc.next().charAt(0); 
	    	        confirmOrder(orderConfirmation,addon,latte.size,"Latte",sc);
	    
	    	   break;
	    	   
	       case 2: 
	    	   Coffee americano = new Coffee(2.95,3.50,4.10,"Americano");
	    	   coffeePrice = americano.CoffeePrice();
	    	       System.out.print("Do you want (M)ilk, (C)ream or (N)one?");
	    	       addon = sc.next().charAt(0);
	    	       chooseAddons(addon,sc);
	    	       System.out.print("Confirm you order (Y/N):");
	    	        orderConfirmation = sc.next().charAt(0); 
	    	        confirmOrder(orderConfirmation,addon,americano.size,"Americano",sc);
	    	      break;
	    	      
	    	      
	       case 3:
	    	   Coffee cappuccino = new Coffee(3.70,4.55, 5.00,"Cappuccino");
	    	      coffeePrice = cappuccino.CoffeePrice();
	    	       System.out.print("Do you want (M)ilk, (C)ream or (N)one?");
	    	       addon = sc.next().charAt(0);
	    	       chooseAddons(addon,sc);
	    	       System.out.print("Confirm you order (Y/N):");
	    	        orderConfirmation = sc.next().charAt(0); 
	    	        confirmOrder(orderConfirmation,addon,cappuccino.size,"Cappuccino",sc);
	    	      break;
	    	      
	    	      
	       case 4:
	    	   Coffee caramelMacchiato =  new Coffee(3.75, 4.50, 5.00, "Caramel Macchiato");
	    	      coffeePrice = caramelMacchiato.CoffeePrice();
	    	       System.out.print("Do you want (M)ilk, (C)ream or (N)one?");
	    	       addon = sc.next().charAt(0);
	    	       chooseAddons(addon,sc);
	    	       System.out.print("Confirm you order (Y/N):");
	    	        orderConfirmation = sc.next().charAt(0); 
	    	        confirmOrder(orderConfirmation,addon,caramelMacchiato.size,"Caramel Macchiato",sc);
	    	      break;
	    	      
	    	      
	       case 5: 
	    	  Coffee mocha = new Coffee(4.50, 5.40, 6.00, "Mocha");
	       coffeePrice = mocha.CoffeePrice();
	       System.out.print("Do you want (M)ilk, (C)ream or (N)one?");
	       addon = sc.next().charAt(0);
	       chooseAddons(addon,sc);
	       System.out.print("Confirm you order (Y/N):");
	        orderConfirmation = sc.next().charAt(0); 
	        confirmOrder(orderConfirmation,addon,mocha.size,"Mocha",sc);
	       break;
	       
	       
	       default: 
	    	   System.out.println("Please enter a valid option");
	    	   break;
	       }
		   
		  
		   
		    
	   }
	   
	
	}

}
