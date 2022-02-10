/*
1. Create the class LengthOfString
2. Take in a user input string
3. If the string is more than 10 characters, abbreviate the string: **internationalization -> i18n**
4. If the string is less than 10 characters, print out the string
*/

import java.util.Scanner;

public class LengthOfString {

	public static void main(String[] args) {
<<<<<<< HEAD:coding-challenges/length-of-string/LengthOfString.java
		Scanner userInput = new Scanner(System.in);
		System.out.println("Enter a string: ");
		String inputString = userInput.nextLine();

		//System.out.println(inputString.length())

		if (inputString.length() <= 10) {
			System.out.println(inputString);
=======
		String input = "";
		
		Scanner scan = new Scanner(System.in);
		
		input = scan.next();
		
		if (input.length() > 10) {
			System.out.println(input.charAt(0) + String.valueOf(input.length() - 2) + input.charAt(input.length() -1));
>>>>>>> 9e2abe6db0c9ccf8ae3cf9eb34f2cfae43b6dd31:coding-challenges-solutions/length-of-string/LengthOfString.java
		} else {
			System.out.println(inputString.charAt(0)
					+ Integer.toString(inputString.length() - 2)
					+ inputString.charAt(inputString.length() - 1));
		}
	}
}
