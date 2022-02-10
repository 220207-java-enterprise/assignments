// import java.sql.Array;

import java.util.*;
// import java.lang.reflect.*;
import java.lang.reflect.Array;


// # Problem: Length of String

// **Tasks**
// 1. Create the class LengthOfString
// 2. Take in a user input string
// 3. If the string is more than 10 characters, abbreviate the string: **internationalization -> i18n**
// 4. If the string is less than 10 characters, print out the string


public class los {
    // SOA 2
    public static void main(String[] args) {
        Scanner howMany = new Scanner(System.in);
        System.out.println("Type in an int to represent how large you want your array to be:  ");
        while(!howMany.hasNextInt()) {
            howMany.nextInt();
        } 
            int frhowMany = howMany.nextInt();
            int[] theirArray = new int[frhowMany];
            int count = 0;
            for (int element : theirArray) {
                Scanner newVal = new Scanner(System.in);
                System.out.print("What would you like in the " + count + "th spot in your array?  ");
                while(!newVal.hasNextInt()) {
                    newVal.nextInt();
                } 
                    int frnewVal = newVal.nextInt();
                    Array.set(theirArray, count, frnewVal);
                    
                System.out.println(theirArray[count]);
                count++;
            }
            count = 0;
            int sum = 0;
            for (int element : theirArray) {
                sum += theirArray[count];
                count++;
            }
            System.out.println(sum);
            

    }



    //SOA
    // static int sum;
    // public static void main(String[] args) {
    //     int[] thisArray = {1, 2, 3, 4, 5};
    //     for (int var : thisArray) {
    //         sum = sum + var;
    //     }
    //     System.out.println(sum);
    // }



        //LOS
    // public static void main(String[] args) {
    //     Scanner theInput = new Scanner(System.in);
    //     System.out.print("Enter a String: ");
    //     String theIntput = theInput.next();
    //     while (theIntput.matches(".*\\s.*")) {
    //         theInput.next();
    //         theIntput = theInput.next();
    //     } 
        

    //     if (theIntput.length() > 9) {
    //         Character firstChar = theIntput.charAt(0);
    //         System.out.println(firstChar);
    //         Character lastChar  = theIntput.charAt(theIntput.length() - 1);
    //         System.out.println(lastChar);
    //         int thelength = (theIntput.length() - 2);
    //         System.out.println(thelength);
    //         System.out.println(firstChar.toString() + thelength + lastChar.toString());
    //     }
    //     else {
    //         System.out.println("The number you entered is: " + theIntput);
    //     }
    // }

// OTHER LOS
    // public static void main(String[] args) {
    //     Scanner theInput = new Scanner(System.in);
    //     System.out.print("Enter an Integer");
    //     while (!theInput.hasNextInt()) theInput.next();
    //     int theIntput = theInput.nextInt();

    //     if (theIntput > 9) {
    //         System.out.println("its bigger");
    //     }
    //     else {
    //         System.out.println("The number you entered is: " + theIntput);
    //     }
    // }

}