package com.revature.app;

public class Solution {
    public String brackets(String s) {
        String newString = "";
        newString = s.replaceAll("\\.","{.}");
        /* Write your code here */
        return newString;
    }
}
