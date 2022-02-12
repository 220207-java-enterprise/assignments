package com.revature.app;

public class Solution {
    public boolean recurringSubstring(String s) {
        /* Write your code here */
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(0,(s.length()/2)));

        //System.out.println(sb.toString()+ " "+s.substring(s.length()/2));

        if(sb.toString().equals(s.substring((s.length()/2)))){

            return true;
        }
        else {
            return false;
        }
    }
}
