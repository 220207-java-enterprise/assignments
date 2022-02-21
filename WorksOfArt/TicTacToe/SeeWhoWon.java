
public class SeeWhoWon {

	public boolean detectWin(int moves) {
		
		if ((moves & 7) == 7) return true;
		
		if ((moves & 56) == 56) return true;
		
		if ((moves & 448) == 448) return true;

		if ((moves & 73) == 73) return true;

		if ((moves & 146) == 146) return true;

		if ((moves & 292) == 292) return true;

		if ((moves & 273) == 273) return true;

		if ((moves & 84) == 84) 
			return true;
		return false;
	}
	
	public int changeBoardToInteger(char player, char[] firstrow, char[] secondRow, char[] thirdRow) {
		int result = 0;
		
		if (firstrow[0] == player) result = result | 1;
		if (firstrow[1] == player) result = result | 2;
		if (firstrow[2] == player) result = result | 4;
		
		if (secondRow[0] == player) result = result | 8;
		if (secondRow[1] == player) result = result | 16;
		if (secondRow[2] == player) result = result | 32;
		
		if (thirdRow[0] == player) result = result | 64;
		if (thirdRow[1] == player) result = result | 128;
		if (thirdRow[2] == player) result = result | 256;
	
		return result;
	}
	
	public char[] decodeRow(String rowInput) {
		char[] row = new char[3];
		
		row[0] = rowInput.charAt(0);
		row[1] = rowInput.charAt(2);
		row[2] = rowInput.charAt(4);
		
		return row;
	}
}
