package com.revature.app;

public class Solution {
    public String brackets(String s) {
        /* Write your code here */
        //int[] array = new int[s.length()];
        //System.out.println("running brackets");
        StringBuilder newString = new StringBuilder();
        for(int i=0; i<s.length(); i++)
        {
            if('.' == s.charAt(i))
            {
                //System.out.println("if statement reached on the " + i + "th iteration");
                newString.append("[").append(s.charAt(i)).append("]");
            }
            else
                newString.append(s.charAt(i));
        }
        String finalString = newString.toString();
        return finalString;
    }
}
