import java.util.*;

public class LengthOfString {

	public static void main(String[] args){
	
	Scanner ac = new Scanner(System.in);
	System.out.println("Enter a string: ");
	String s = ac.next();
	if (s.length() > 10) {
	s = s.substring(0,10);
	System.out.println(s);
	}
	else{
	System.out.println(s);
	}
}
}