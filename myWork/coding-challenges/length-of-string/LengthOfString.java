import java.util.*;

public class LengthOfString {

	public static void main(String[] args){
	
	Scanner ac = new Scanner(System.in);
	System.out.println("Enter a string: ");
	String s = ac.next();
	if (s.length() > 10) {
	System.out.print(s.charAt(0));
	System.out.print(s.length()-2);
	System.out.print(s.charAt(s.length()-1));
	}
	else{
	System.out.println(s);
	}
}
}