package com.revature.app;

public class Solution {
    public String brackets(String s) {
        /* Write your code here */
        StringBuilder result = new StringBuilder();

        for (int i=0; i<s.length(); i++){
            if (s.charAt(i)=='.'){
                result.append("[.]");
            } else {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }
}
