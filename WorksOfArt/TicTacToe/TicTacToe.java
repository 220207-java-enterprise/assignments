import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) {
		// Instantiate an instance of SeeWhoWon
		SeeWhoWon sww = new SeeWhoWon();
		
		// get the three rows of the playing board
		Scanner getInput = new Scanner(System.in);
		
		int result;
		
		String row1, row2, row3;
		
		System.out.println("Enter the tic tac toe board as three rows of characters, e.g.,");
		System.out.println("X O X is a valid row, but XOX is not.\n");
		System.out.print("Enter the first row:  ");
		row1 = getInput.nextLine();
		
		System.out.print("Enter the second row: ");
		row2 = getInput.nextLine();
		
		System.out.print("Enter the third row:  ");
		row3 = getInput.nextLine();
		
		char[] firstRow = new char[3];
		char[] secondRow = new char[3];
		char[] thirdRow = new char[3];
		
		if (row1.length() < 5 || row2.length() < 5 || row3.length() < 5) {
			System.out.println("Each row must be five characters long.");
			return;
		}
		
		// Decode the input rows
		firstRow = sww.decodeRow(row1);
		
		secondRow = sww.decodeRow(row2);
		
		thirdRow = sww.decodeRow(row3);
		
		// Convert player X's moves to an integer.
		result = sww.changeBoardToInteger('X', firstRow, secondRow, thirdRow);
		
		// Check to see if X won
		if (sww.detectWin(result)) 
			{
				System.out.println("X won!");
				getInput.close();
				return;
			}
		
		// convert player O's moves to an integer
		result = sww.changeBoardToInteger('O', firstRow, secondRow, thirdRow);
		
		// check to see if O won
		if (sww.detectWin(result)) {
			System.out.println("O won!");
			getInput.close();
			
			return;
		}
		
		// Cat's game
		System.out.println("Cat's game.");
		getInput.close();
		
	}

}
