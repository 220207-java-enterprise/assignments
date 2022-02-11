package com.revature.app;

//import java.lang;

public class Solution {
    public boolean recurringSubstring(String s) {

        if (s.length() < 2) return false;

        String subStr;
        String frankenstein;
        int times;

        // OK, we know the string is at least two characters long.
        for (int i = 0; i < s.length()/2; i++) {

            // build a substring
            subStr = s.substring(0, i+1);
System.out.println(subStr + "subStr");
            if (s.length() % subStr.length() !=0 )
                continue; // substr can't add up to s

            // figure out how many times to add the substring together
            times = s.length()/subStr.length();
            frankenstein = "";

            // Dr. Frankenstein to surgery.
            for (int j = 0; j < times; j++) {
                frankenstein += subStr;
            }

            // Are they equal?
            if (s.equals(frankenstein))
                    return true;

        }
        return false;
    }
}
