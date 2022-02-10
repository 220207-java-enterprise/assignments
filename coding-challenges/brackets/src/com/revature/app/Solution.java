package com.revature.app;

public class Solution {
    public String brackets(String s) {
        /* Write your code here */
        //int[] array = new int[s.length()];

        StringBuilder newString = new StringBuilder();
        for(int i=0; i<s.length(); i++)
        {
            if(".".equals(s.charAt(i)))
            {
                newString.append("[").append(s.charAt(i)).append("]");
            }
            else
                newString.append(s.charAt(i));
        }
        String finalString = newString.toString();
        return finalString;
    }
}
