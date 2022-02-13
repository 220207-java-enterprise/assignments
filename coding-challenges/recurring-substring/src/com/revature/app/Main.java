package com.revature.app;

public class Main {
    public static void main(String[] args) {
        /* Use Main to enter in values into your Solution class */
        String a = "abababa";
        String b = "abcdabcdabcdabcdabcd";
        Solution s = new Solution();

        System.out.println(s.recurringSubstring(a));
        System.out.println(s.recurringSubstring(b));

    }
}
