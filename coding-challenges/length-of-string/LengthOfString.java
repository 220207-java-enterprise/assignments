import java.util.Scanner;

class LengthOfString{

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String userInput = scan.next();

 	final int MAX_LENGTH = 10;

        if (userInput.length() > MAX_LENGTH){

	    System.out.println(userInput.charAt(0) + "" + (userInput.length() - 2) + "" + userInput.charAt(userInput.length() - 1));
	}
        else{
	    System.out.println(userInput);
        }
    }
}
