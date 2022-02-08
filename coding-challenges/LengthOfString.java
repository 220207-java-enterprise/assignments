import java.util.Scanner;

public class LengthOfString{
  public static void main(String arg[]){

  	Scanner sc= new Scanner(System.in); //System.in is a standard input stream.
	System.out.print("Enter a string but not more than ten characters!!! What will happen?! ");
	String input= sc.nextLine();
	String midLength = (input.length()-2) + "";

	if(input.length()>10)
		System.out.println("That was bigger than 10 so it looks like this: " + input.charAt(0) + midLength + input.charAt(input.length()-1));
	else
		System.out.println("Thank you for keeping it small-brained. Here's your string: " + input);
  }
}