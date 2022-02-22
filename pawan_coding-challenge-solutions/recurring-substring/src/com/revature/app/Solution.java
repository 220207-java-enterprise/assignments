package com.revature.app;

public class Solution {
    public boolean recurringSubstring(String s) {

        /* Write your code here */

        // covers empty string and whitespaces string cases
        if (s.isBlank())
            return false;
        /*
         when a string is added to itself and the first and the last characters are removed
         from that string.
         If that new string contains the original string, the original string has a repeating pattern
         ex: abcabc
         addition abcabc + abcabc
         altered string bc abc abc ab
         the repeating substring is in the middle
         String operation = s + s;
         operation = operation.substring(1, operation.length() -1);
        */
       String operation = s.substring(1) + s.substring(0, s.length()-1);

        // covers recurring string cases
        if (operation.contains(s))
            return true;

        // covers all the other cases
        return false;
    }
}
