import java.util.Scanner;

public class LengthOfString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String userInput = scan.next();

        if (userInput.length() > 10) {
            String output =
                userInput.charAt(0) +
                Integer.toString(userInput.length() - 2) +
                userInput.charAt(userInput.length() - 1)
            ;
            System.out.println(output);
        }

        System.out.println(userInput);
    }
}
