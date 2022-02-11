package com.revature.app;

public class Solution {
    public boolean recurringSubstring(String s) {
        /* Write your code here */
         String str ;
        for (int j=1; j <= s.length()/2; j++){
            str = s.substring(0,j);
            for (int i=0; i < (s.length()/str.length()); i++){
                str += str;
                if (s.equals(str)){
                    return true;

                }
            }
        }
        return false;
    }
}
