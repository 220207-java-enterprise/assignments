package com.revature.app;

public class Solution {
    public String brackets(String s) {
        int i;
        StringBuilder bracketedStringBuilder = new StringBuilder();
        for(i = 0; i < s.length(); i++){
            if(s.charAt(i) == '.') {
                bracketedStringBuilder.append('[');
                bracketedStringBuilder.append('.');
                bracketedStringBuilder.append(']');
            } else {
                bracketedStringBuilder.append(s.charAt(i));
            }
        }
        String bracketedString = bracketedStringBuilder.toString();
        return bracketedString;
    }
}
