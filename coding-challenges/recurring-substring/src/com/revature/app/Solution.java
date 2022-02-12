package com.revature.app;

public class Solution {
    public boolean recurringSubstring(String s) {
        /* Write your code here */
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length() / 2; i++) {
            sb.append(s.charAt(i));
            String substr = sb.toString();

            while (sb.length() <= s.length()) {
                if (sb.toString().equals(s)) {
                    return true;
                } else {
                    sb.append(substr);
                }
            }

            sb = new StringBuilder(substr);
        }
        return false;
    }
}
