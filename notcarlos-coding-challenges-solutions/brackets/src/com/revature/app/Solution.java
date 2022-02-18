package com.revature.app;

public class Solution {
    public String brackets(String s) {
        /* Write your code here */
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '.') {
                sb.append("[.]");
            } else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}
