package Utiltity;

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

		 public  void computeNeighbour(String status, int i, int j)
		  {
			 
			  int sum = 0;
			  
			  
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
			  
			
			  
			  if(!((i+1) == height))
			  {

				   if(cells[i+1][j] == '#' )
				   {
					   sum++;
				   }
					  
			  }
			  
		   System.out.println("Sum for Index: "+"("+i+"-"+j+"):"+sum);
			   
			  
			  
			
		  }
		  public void findNumberOfNeighbour()
		  {
			
			   
			  for (int i = 0; i < height; i++) {
					for (int j = 0; j < width; j++) {
						if(cells[i][j] == '0')
						{
							computeNeighbour("Dead",i,j);
						 
						
						}
						else if(cells[i][j] == '#')
						{
							computeNeighbour("Live",i,j);
						}
						else {
							System.out.println("What: "+cells[i][j]);
						}
					}
				}
			
			 
			  
			  
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
			System.out.println("At Print Station");
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					System.out.print(cells[i][j]);
				}
				System.out.println();
			}
			
			
		}

		
	
	
}
