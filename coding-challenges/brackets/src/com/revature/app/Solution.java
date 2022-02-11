package com.revature.app;

import java.util.*;

public class Solution {

    public void brackets(String s) {
        System.out.print("Enter a string: ");
        Scanner scr = new Scanner(System.in);
    }

    boolean check(String s) {
        if (s == null) {
            return false;
        }
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if ((Character.isLetter(s.charAt(i)) == false)) {
                return false;
            }
        }
    }
}

