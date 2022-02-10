import java.util.*;

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
	}
}