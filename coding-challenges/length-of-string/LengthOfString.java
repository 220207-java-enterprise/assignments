import java.util.Scanner;

public class LengthOfString{

    public static void main(String[] args) {
        
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter a string");

        String s = myObj.nextLine();
        if (s.length() < 10){
        System.out.println("Result is: "+s);
        } else {
            System.out.println("Result is: \n"+s.charAt(0)+ (s.length()-2) +s.charAt(s.length()-1));
        }
	}
}