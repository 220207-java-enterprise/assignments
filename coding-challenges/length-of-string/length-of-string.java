import java.util.Scanner;

class LengthOfString {

	public static void main (String[] args) {
		System.out.println("Enter something: ");
		Scanner ui = new Scanner(System.in);
		String n = ui.nextLine();
		
		if (n.length()  > 10) {
			int x = n.length() - 2;
			char a = n.charAt(0);
			char b = n.charAt(x+1);
			System.out.println(x);
			System.out.println(a);
			System.out.println(b);
			String s = String.valueOf(a);
			String t = String.valueOf(b);
			System.out.println(s);
			System.out.println(t);
			System.out.println(s + x + t);
		} else {
			System.out.println(n);
			}		
		}
	}

