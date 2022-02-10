<<<<<<< HEAD
import java.util.Scanner;//import scanner

public class LengthOfString {
	public static void main(String[] args) {
	
	//implements scanner
	Scanner scanner = new Scanner(System.in);
	//create String for user input
	String userInput;
	//pint "Please enter a string: "
	System.out.println("Please enter a string: ");
	//prompts for user input using scanner
	userInput = scanner.nextLine();

	//creates character primitive "firstWord" for first word of user input(computer identifies this as a numerical value)
	char firstWord = userInput.charAt(0);
	//creates character prim "lastWord" for last word of user input
	char lastWord = userInput.charAt(userInput.length() - 1);
	

	int middleLetters;
	int i; 

	if (userInput.length() > 10) {

	  middleLetters = userInput.length() - 2;
	  System.out.println(firstWord+""+middleLetters+""+lastWord);

	} else if (userInput.length() <= 10) {

	  System.out.println(userInput);

	}
}
=======
import java.util.*;

public class LengthOfString {
	public static void main(String[] args) {
		String input = "";
		String abbr = "";
		Scanner scan = new Scanner(System.in);
		
		input = scan.nextLine();
		
		if (input.length() > 10) {
			System.out.println(input.charAt(0) + String.valueOf(input.length() - 2) + input.charAt(input.length() - 1));	
		} else {
			System.out.println(input);
		}
	}
>>>>>>> 6812d90cb163251ff5c668a63d2f5907aa7dbe35
}