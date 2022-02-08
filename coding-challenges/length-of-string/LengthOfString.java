import java.util.Scanner;


class LengthOfString {
	public static void main(String[] args){
		Scanner myObj = new Scanner(System.in);
		System.out.println("Enter a string");
			
		//Read it here.
		String input = myObj.nextLine();

		if(input.length() > 10){
			System.out.println("Output\n");
			System.out.print(input.charAt(0));
			System.out.print(input.length()-2);
			System.out.print(input.charAt(input.length()-1));
			
		} else {
			System.out.println(input);
		}
		
	}
}