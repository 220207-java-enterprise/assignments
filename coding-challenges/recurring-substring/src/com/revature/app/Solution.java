package com.revature.app;

public class Solution {
    public boolean recurringSubstring(String s) {
        /* Write your code here */
        if(s.isBlank())
            return false;
        String operation = s.substring(1) + s.substring(0, s.length()-1);
        if (operation.contains(s))
            return true;
        return false;
    }
}
