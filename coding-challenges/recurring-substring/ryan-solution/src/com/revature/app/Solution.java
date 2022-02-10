package com.revature.app;

public class Solution {
    public boolean recurringSubstring(String s) {
        int i, j = 0;
        for(i = 0; i < s.length(); i++) {
            for(j = 0; j < s.substring(i).length(); j++){
                //substring starting at i
                String iSubString = s.substring(i);
                String jSubstring = iSubString.substring(0, iSubString.length() - j);
                if(jSubstring.equals(s)) {
                    continue;
                }
                StringBuilder appendingString = new StringBuilder();
                while(appendingString.toString().length() < s.length()) {
                    appendingString.append(jSubstring);
                }
                if(appendingString.toString().equals(s)){
                    System.out.println(jSubstring);
                    return true;
                }
            }
        }
        return false;
    }
}
