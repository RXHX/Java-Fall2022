

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Board {
	



		public Board() {
		super();
	}

		public int getWidth() {
			return width;
		}

		public void setWidth(int width) {
			this.width = width;
		}

		public int getHeight() {
			return height;
		}

		public void setHeight(int height) {
			this.height = height;
		}

		public char[][] getCells() {
			return cells;
		}

		public void setCells(char[][] cells) {
			this.cells = cells;
		}

		private int width;
		private int height;
		public char[][] cells;
		public int [][] neighhbour;
	    public char[][] tempcells;
		public final static void clearConsole() {
			/*
			 * clearConsole method to clear the console if you are using Windows' command
			 * prompt or Linux-based system This method does not work in Eclipse IDE.
			 */
			try {
				final String os = System.getProperty("os.name");

				if (os.contains("Windows")) {
					new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
				} else {
					Runtime.getRuntime().exec("clear");
				}
			} catch (final Exception e) {
				// Handle any exceptions.
			}
		}

		 public  int computeNeighbour( String status ,int i, int j)
		  {
			 
			  int sum = 0;
			  
			  
			  
			  
			  if(((i+1) == height))
			  {

				  if(cells[0][j] == '#')
				  {
					  sum++;
				  }
				  
				  if(!((j+1) == width))
				  {
					  if(cells[0][j+1] == '#')
					  {
                        sum++;						  
					  }
					 
					  if(j!= 0)
					   if(cells[0][j-1] == '#')
						  {
							  sum++;
						  }
					 
					
					  
					
					 
				  }
				  
				  
			  }
			  
			  
			  
			  
			  
			  if(   !((i-1) == -1)  )
			  {
				  if(cells[i-1][j] == '#' )
				   {
					   sum++;
				   }
				  
				  if(!((j-1) == -1))
				  {
					  
					  if(cells[i-1][j-1] == '#' )
					   {
						   sum++;
					   }
		
				  }
				  
				  if(!((j+1) == width))
				  {
					  if(cells[i-1][j+1] == '#')
					   {
						   sum++;
					   }
					  
				  }
			  
			  }
			  else {
				  
				  if(cells[height-1][j] == '#')
				  {
					  sum++;
				  }
				  
				
				  
				  if(!((j+1) == width))
				{
					       
					  if(cells[height-1][j+1] == '#')
					  {
					    sum++;	  
					  }
				}
				  else {
					  
					  if(cells[height-1][0] == '#')
					  {
					    sum++;	  
					  }
					  
					  
				  }
				  
			  }
			  
			  
			  
			  if(!((j-1) == -1))
			  {
				  if(cells[i][j-1] == '#' )
				   {
					   sum++;
				   }
				  
				  
				  if(!(i+1 == height))
				{
					   if(cells[i+1][j-1] == '#')
					   {
						   sum++;
					   }
					  
				}
				  
				  
			  }
			  else {
				  if(((cells[i][width-1]) == '#' ))
				  {
					  sum++;
				  }
				  
				  if(!((i+1) == height))
				  {
					  if(((cells[i+1][width-1]) == '#' ))
					  {
						  sum++;
					  }
					  
				  }
				  else {
					  
					  if(cells[0][0] == '#')
					  {
						  sum++;
					  }
					  
				  }
				  
				  
			  }
			  
			  if(!((j+1) == width))
			  {
				  if(cells[i][j+1] == '#' )
				   {
					   sum++;
				   }
				  
				  if(!((i+1) == height))
				  {
					  if(cells[i+1][j+1] == '#')
					   {
						   sum++;
					   }
				  }
				  
			  }
			  else {
				 
			  }
			  
			
			  
			  if(!((i+1) == height))
			  {

				   if(cells[i+1][j] == '#' )
				   {
					   sum++;
				   }
				   
				  
					  
			  }
			
			  
			  neighhbour[i][j] = sum;
			
			 return sum;
			
		  }
		 
		 
		 public void printNeighbour()
		 {
//			 for(int i=0;i<height;i++)
//			 {
//				 for(int j=0;j<width;j++)
//				 {
//					 System.out.print(neighhbour[i][j]+" ");
//				 }
//				 System.out.println();
//			 }
			 
			 for(int i=0;i<height;i++)
			 {
				 for(int j=0;j<width;j++)
				 {
					 System.out.print(tempcells[i][j]+" ");
				 }
				 System.out.println();
			 }	 
			
		 }
		 
		  public void findNumberOfNeighbour()
		  {
			neighhbour = new int[height][width];
			tempcells = new char[height][width];
			   String status = "";
			  for (int i = 0; i < height; i++) {
					for (int j = 0; j < width; j++) {
						if(cells[i][j] == ' ')
						{
						status = "Dead";	
						}
						else if(cells[i][j] == '#')
						{
						status = "Live";
						}
						int num = computeNeighbour(status,i,j);
						
					
								if(status.equals("Dead"))
								{
									if(num == 3)
									{
										tempcells[i][j]= '#';
									}
									else {
										tempcells[i][j] = ' ';
									}
									
								}
								else if(status.equals("Live"))
								{
								     if( num == 2 || num == 3)
								     {
								    	 tempcells[i][j]= '#';
								     }
								     else {
								    	 tempcells[i][j] = ' ';
								     }
									
									
								}
								
						
						
						
					}
					
				}
			 
			  print();
			 
			  setCells(tempcells);
			 
			  print();
			  
			  
		  }
	

		public Board(int height, int width) {
			/*
			 * Constructor to create a board with height and width
			 */
			this.width = width;
			this.height = height;
			
		}

		public void clear() {
			/*
			 * Set all cells to space characters
			 */
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					cells[i][j] = ' ';
				}
			}
		}

		public void print() {
			/*
			 * Print all cells of the board
			 */
			//Board.clearConsole();
			
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					System.out.print(cells[i][j]);
				}
				System.out.println();
			}
			
			
		}

		
	
	
}
