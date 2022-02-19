package com.revature.app;

public class Main {
    public static void main(String[] args) {
        /* Use Main to enter in values into your Solution class */
        String a = "abababa";
        String b = "abcdabcdabcdabcdabcd";
        String c = "";
        String d = "                ";
        String status = " contains repeating characters: ";
        Solution s = new Solution();

        System.out.println("Test cases:");
        System.out.println("String " + a + status + s.recurringSubstring(a));
        System.out.println("String " + b + status + s.recurringSubstring(b));
        System.out.println("String " + c + status + s.recurringSubstring(c));
        System.out.println("String " + d + status + s.recurringSubstring(d));

    }
}
