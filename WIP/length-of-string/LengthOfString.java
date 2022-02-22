import java.util.*;

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

}