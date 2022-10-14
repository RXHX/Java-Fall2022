
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;



public class Main {
	private static final String FILENAME = "../Assignment-3/src/input";
	static char[][] starIndex = null;
	public static void ReadFile()
	{
		BufferedReader br = null;
		FileReader fr = null;
		PrintWriter pw = null;
		Board newBoard = null;
		
		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			String sCurrentLine;
			int count = 0;
            int rowCount = 0;
            int columnCount = 0;
           
            Board board = new Board();
			int starInitialIndex = 0;
            while ((sCurrentLine = br.readLine()) != null) {
           
				if(count == 0)
				{
					rowCount = Integer.parseInt(sCurrentLine);
				}
				else if(count == 1)
				{
					columnCount = Integer.parseInt(sCurrentLine);
					 starIndex = new char[rowCount][columnCount];
					 for (int i = 0; i < rowCount; i++) {
							for (int j = 0; j < columnCount; j++) {
								starIndex[i][j] = ' ';
							}
						}
				 }
				else {
					 
					newBoard = new Board(rowCount, columnCount);
				    String[] tempStorage = sCurrentLine.split(" ");	
				    int row = Integer.parseInt(tempStorage[0]);
				    int column = Integer.parseInt(tempStorage[1]);
					starIndex[row][column] = '#';
				  newBoard.setCells(starIndex); 
				 	    
				}
				
			     
				count++;    
			}
         // newBoard.print();
          newBoard.findNumberOfNeighbour();
    //      newBoard.print();
		
			br.close();

		} catch (IOException e) {

			e.printStackTrace();
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		LocalTime now = LocalTime.now();
		

		while(true)
		{
			ReadFile();
			int s = now.getSecond();
			sleep(s);
		}
		
	
		
	
		

	}
	private static void sleep(int s) {
		// TODO Auto-generated method stub
		
	}

}
