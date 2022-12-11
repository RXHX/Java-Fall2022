
// Library Used in the Project
import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;

// Main Execution Class
public class Main {
	// Path of the File
	private static final String FILENAME = "./input";
	// char type Array
	static char[][] starIndex = null;

	// Method to Read the Board
	public static Board ReadFile() {
		// Buffered Reader
		BufferedReader br = null;
		// File Reader
		FileReader fr = null;
	
		// instance of Board Class
		Board newBoard = null;
		try {
			// creation of object of FileReader
			fr = new FileReader(FILENAME);
			// creation of object of BufferedReader
			br = new BufferedReader(fr);
			// String to hold data
			String sCurrentLine;
			// counter to count number of lines in the file
			int count = 0;
			// to count number of Rows
			int rowCount = 0;
			// to count number of Columns
			int columnCount = 0;



			// to iterate data in the File
			while ((sCurrentLine = br.readLine()) != null) {

				// for first Row
				if (count == 0) {
					// get rowCount
					rowCount = Integer.parseInt(sCurrentLine);
				}
				// for Second Row
				else if (count == 1) {
					// get Column Count
					columnCount = Integer.parseInt(sCurrentLine);
					// initialize the star Index
					starIndex = new char[rowCount][columnCount];
					// Make an Empty Array
					for (int i = 0; i < rowCount; i++) {
						for (int j = 0; j < columnCount; j++) {
							starIndex[i][j] = ' ';
						}
					}
				} else {

					// make an Array with rowCount and ColumnCount
					newBoard = new Board(rowCount, columnCount);
					// make an tempStorage string
					String[] tempStorage = sCurrentLine.split(" ");
					// store the row count
					int row = Integer.parseInt(tempStorage[0]);
					// store the Column Count
					int column = Integer.parseInt(tempStorage[1]);
					// Make a starIndex array
					starIndex[row][column] = '#';
					// make the newBoard Array with # at specific location
					newBoard.setCells(starIndex);

				}

				// update the counter
				count++;
			}
			// Close File Reader
			fr.close();
			// Close Buffered Reader
			br.close();

		} catch (IOException e) {

			e.printStackTrace();
		}

		// Return the newBoard Object
		return newBoard;

	}

	public static void main(String[] args) throws Exception {

		// store newBoard Object inside the Board Class
		Board board = ReadFile();

		while (true) {

			// Call the FindNumberOfNeighbour Method
			board.findNumberOfNeighbour();
			// Clear the board by Calling clearConsole Method
			Board.clearConsole();
			board.print();
			Thread.sleep(2000);

		}

	}

}
