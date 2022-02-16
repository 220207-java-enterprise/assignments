package com.revature.app;

public class Solution {
    public String brackets(String s) {

        // Base case: provided string is null or filled with only whitespace
        if (s == null || s.trim().equals("")) return "";


        String[] frags = s.split("\\.");

        // Base case: if the provided string contains only a period
        if (frags.length == 0) return "[.]";

        // Base case: if the provided string contained no period
        if (frags.length == 1) return s;

        // All other cases: wrap all periods in brackets
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < frags.length; i++) {
            sb.append(frags[i]);
            if (i != frags.length - 1) sb.append("[.]");
        }
        return sb.toString();
    }
}
