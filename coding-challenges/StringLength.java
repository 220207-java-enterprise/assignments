import java.util.Scanner;
public class StringLength{
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in); 
        System.out.println("Enter String");
        String s = myObj.next();
        StringLength(s);

    }
    public static void StringLength(String s){
        String str;
        if (s.length() <= 10) {
            System.out.println(s);
        }
        else {
            str = String.valueOf(s.charAt(0));
            str += s.length()-2;
            str += String.valueOf(s.charAt(s.length()-1));
            System.out.println(str);
        }


    }
        
}