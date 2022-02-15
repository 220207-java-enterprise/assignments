package com.revature.app;

<<<<<<< HEAD
import java.util.Scanner;

public class Solution {
    public boolean recurringSubstring(String s) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String userInput = scanner.nextLine();
        String s;
        for (int i = 0; i < userInput.length() / 2; i++) {//set up loop that goes halfway to substring
            s = userInput.substring(0, i + 1);//creates a substring of user input, and searches for letters from 0 to i, plus 1 since it begins at zero

            if (userInput.length() % s.length() != = 0) { //if userInput is equally divisible by s.length(not equal to 0)
                continue;
            }


            return false;
        }
=======
public class Solution {
    public boolean recurringSubstring(String s) {
        /* Write your code here */
        return false;
>>>>>>> 8f42dedb9fb210ce7f9e7aa55db28fd0c0a4f5a2
    }
}
