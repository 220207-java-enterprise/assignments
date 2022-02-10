import java.util.Scanner;

<<<<<<< HEAD:coding-challenges/length-of-string/LengthOfString.java
class LengthOfString{

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String userInput = scan.next();

 	final int MAX_LENGTH = 10;

        if (userInput.length() > MAX_LENGTH){

	    System.out.println(userInput.charAt(0) + "" + (userInput.length() - 2) + "" + userInput.charAt(userInput.length() - 1));
=======
public class LengthOfString {
	public static void main(String[] args) {
		String input = "";
		
		Scanner scan = new Scanner(System.in);
		
		input = scan.next();
		
		if (input.length() > 10) {
			System.out.println(input.charAt(0) + String.valueOf(input.length() - 2) + input.charAt(input.length() -1));
		} else {
			System.out.println(input);
		}
>>>>>>> 9e2abe6db0c9ccf8ae3cf9eb34f2cfae43b6dd31:coding-challenges-solutions/length-of-string/LengthOfString.java
	}
        else{
	    System.out.println(userInput);
        }
    }
}
