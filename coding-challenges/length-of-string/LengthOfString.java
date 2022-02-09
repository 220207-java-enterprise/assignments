import java.util.Scanner;

public class LengthOfString
{
    public static String userInput;

    public static void getUserInput()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please type something: ");


        userInput = scanner.nextLine();
        //System.out.println(userInput);
    }

    public static void countInput()
    {
        if(userInput.length() < 10)
        {
            System.out.println(userInput);
        }
        else if(userInput.length() >= 10)
        {
            String newString = userInput.charAt(0) + "" +
            (userInput.length() - 2) + "" + 
            userInput.charAt(userInput.length() - 1);
            System.out.println(newString);
        }
    }

    public static void main(String[] args)
    {
        getUserInput();
        countInput();
    }
}