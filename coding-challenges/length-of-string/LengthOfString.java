import java.util.Scanner;


public class LengthOfString {
public static String machinations(String input) {
	String result = "";
	int temp = input.length();
	
	if (temp > 10) {
		result += input.charAt(0);
		result += Integer.toString(temp);
		result += input.charAt(temp -1);
		//result += input.charAt(0) + input.charAt(1)
	}
	else {
		result = input;
	}

	return result;
}
	
public static void main(String[] args) {
	Scanner getInput = new Scanner(System.in);

	String input = getInput.nextLine();
	String result = machinations(input);

	System.out.println(result);
}

}
