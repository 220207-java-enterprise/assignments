import java.util.Scanner;

public class LengthOfString{

		public static void main(String[] args){
		Scanner stringInput = new Scanner(System.in);
		System.out.println("Input String:");
	
		String theString = stringInput.nextLine();

		if(theString.length() > 10) {
			//start index is inclusive and end index is exclusive
			System.out.println("Truncated String to 10 characters: " + 
                                theString.substring(0,10));
			int middleLength = theString.length() - 2;
			int lastCharacterIndex = theString.length() - 1; 
			System.out.println("Abbreviated String: " + 
								theString.charAt(0) + middleLength 
								+ theString.charAt(lastCharacterIndex));
    	} else {
			System.out.println("The string is: " + theString);
		}
	}
}
