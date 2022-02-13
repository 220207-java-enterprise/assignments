import java.util.Scanner;
public class LengthOfString {

    public static void main(String[] args) {
        String userInput = "";
        Scanner inputConsole = new Scanner(System.in);
        System.out.print("Please type your string: ");
        userInput = inputConsole.next();

        if (userInput.length() > 10) {
            System.out.println(userInput.charAt(0) + String.valueOf(userInput.length() - 2) + userInput.charAt(userInput.length() -1));
        }
        else {
            System.out.println(inputConsole.next());
        }
    }
}
