package com.revature.app;

public class Solution {
    public String brackets(String s) {
        StringBuilder solution = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '.') {
                solution.append("[.]");
            } else {
                solution.append(s.charAt(i));
            }
        }

        return solution.toString();
    }
}
