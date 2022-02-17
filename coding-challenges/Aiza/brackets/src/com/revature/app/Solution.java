package com.revature.app;

public class Solution {
    public String brackets(String s) {
        /* Write your code here */
        if(s.contains(".")==true){
            s=s.replace(".","[.]");
        }
        return s;
    }
}
