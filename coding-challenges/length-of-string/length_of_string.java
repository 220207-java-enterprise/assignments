import java.util.Scanner;

public class length_of_string {

	public static void main(String[] args){
	Scanner stringInput = new Scanner(System.in);
	System.out.println("Input String:");
	
	String theString = stringInput.nextLine();

	System.out.println("Here is your string:");
	if(theString.length() >= 10) {
		//start index is inclusive and end index is exclusive
		System.out.println(theString.substring(0,10));
    } else {
		System.out.println(theString);
	}
}
}
