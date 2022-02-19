package com.revature.app;

public class Solution {
    public boolean recurringSubstring(String s) {
        /* Write your code here */
        StringBuilder newString = new StringBuilder();

        for (int i = 0; i < s.length() / 2; i++)
        {
            newString.append(s.charAt(i));
            String sub = newString.toString();

            while (newString.length() <= s.length())
            {
                if (newString.toString().equals(s))
                {
                    return true;
                }
                else
                {
                    newString.append(sub);
                }
            }
            newString = new StringBuilder(sub);
        }

        return false;
    }
}
