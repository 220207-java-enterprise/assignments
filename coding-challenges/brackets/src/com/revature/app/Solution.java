package com.revature.app;

public class Solution {
    public String brackets(String s) {
        /* Write your code here */
        String result = new String("");

        for (int i=0; i<s.length(); i++){
            if (s.charAt(i)=='.'){
                result += "[.]";
            } else {
                result += s.charAt(i);
            }
        }
        return result;
    }
}
