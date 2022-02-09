import java.util.Scanner;

public class LengthOfString{

    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a string ");
        
        String userString = s.nextLine();
        if(userString.length() < 10)
        {
        System.out.println("Your input was: "+ userString);
            
        }
        else 
        {   
            
            System.out.println("Your first character is " + userString.charAt(0) +
            userString.charAt(userString.length()/2) +
            userString.charAt(userString.length()-1));
            
        }
       
    
       
	}}
