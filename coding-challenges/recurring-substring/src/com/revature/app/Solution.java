package com.revature.app;

public class Solution {
    public boolean recurringSubstring(String s) {
        /* Write your code here */
        String str ;
        for (int j=1; j <= s.length(); j++){
            str = s.substring(0,j);
            for (int i=0; i < (s.length()/str.length()); i++){
                if ((s.length()/str.length())%2 == 0){
                    str += str;
                    if (s.equals(str)){
                        return true;
                    }

                }
                else if ((s.length()/str.length())%2 != 0){
                    str += str;
                    if (str.equals(s+s)){
                        return true;
                    }

                }
                
                
            }
        }
        return false;
    }
}
