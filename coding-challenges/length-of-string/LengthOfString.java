import java.util.Scanner;

public class LengthOfString {
	
	public static void main(String[] args){
		System.out.println("Enter word.");
		Scanner user = new Scanner(System.in);
		String temp = user.next();

		if (temp.length() > 10) {
			char temp2 = temp.charAt(0);
			char temp3 = temp.charAt(temp.length() - 1);
			System.out.print(temp2);
					System.out.print(temp.length());
					System.out.print(temp3);
		}
		else {
			System.out.println(temp);
		}
	}
}