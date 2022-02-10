import java.util.*;

<<<<<<< HEAD
public class LengthOfString{
	
	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	System.out.print("Enter input: ");
	String input = scan.nextLine();
	if (input.length() > 10){
		System.out.println("Input is: " + input.charAt(0) + (input.length() - 2) + input.substring(input.length() -1));
	}
	else 
		System.out.println("Input is: " + input);
	}

=======
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
>>>>>>> 49a0bbc90936d11e66da00e28aa8d28f7bda7a57
}