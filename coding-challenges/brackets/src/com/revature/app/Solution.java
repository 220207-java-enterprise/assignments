package com.revature.app;

public class Solution {
    public String brackets(String s) {
        /* Write your code here */
        for (int i=0; i < s.length(); i++){
            if (s.charAt(i) == '.'){
                s = new StringBuilder(s).insert(i+1, "]").toString();

            }

        }
        for (int i=s.length()-1; i >=0; i--){
            if (s.charAt(i) == '.'){
                s = new StringBuilder(s).insert(i, "[").toString();

            }

        }
        return s;
    }
}
