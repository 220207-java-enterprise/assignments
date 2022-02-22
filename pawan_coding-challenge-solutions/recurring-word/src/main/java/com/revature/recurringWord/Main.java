package com.revature.recurringWord;

public class Main {
    public static void main(String[] args) {


        Solution s = new Solution();

        String testString = "abaaacddddadd";
        System.out.println(s.recurringWord(testString));

        testString = "abaaacddddadd";
        System.out.println(s.recurringWord(testString));

        testString = "12214223443848";
        System.out.println(s.recurringWord(testString));

        testString = null;
        System.out.println(s.recurringWord(testString));
    }
}
