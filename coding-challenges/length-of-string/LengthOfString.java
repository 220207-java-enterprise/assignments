
/*
1. Create the class LengthOfString
2. Take in a user input string
3. If the string is more than 10 characters, abbreviate the string: **internationalization -> i18n**
4. If the string is less than 10 characters, print out the string
*/

import java.util.Scanner;

public class LengthOfString{

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter a string: " );
        String inputString = userInput.nextLine();

        //System.out.println(inputString.length())

        if (inputString.length()<=10){
            System.out.println(inputString);
        }else{
            System.out.println(inputString.charAt(0)
                            +Integer.toString(inputString.length()-2)
                            +inputString.charAt(inputString.length()-1));
        }
    }

}