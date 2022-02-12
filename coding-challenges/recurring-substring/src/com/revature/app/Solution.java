package com.revature.app;

public class Solution {
    public static boolean recurringSubstring(String s) {
        /* Write your code here */
        StringBuilder output = new StringBuilder();
        String tmp = new String(s);

        for(int i = 0; i < s.length() / 2; i++) {
            output.append(s.charAt(i));
            tmp = output.toString();
            while (output.length() <= s.length()) {
                if (output.toString().equals(s)) {
                    return true;
                } else {
                    output.append(tmp);
                }

            }
            output = output.replace(0, output.length(), tmp);
            System.out.println(output);
        }
        return false;
    }
}

// aaaaaabaaaa
