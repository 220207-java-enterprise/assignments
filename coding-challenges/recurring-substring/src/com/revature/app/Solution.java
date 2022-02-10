package com.revature.app;

public class Solution {
    public boolean recurringSubstring(String s) {
        /* Write your code here */
        if(s.length()<2)
            return false;

        String test = String.valueOf(s.charAt(0));
        int index=0;
        while(test.length()<(s.length()/2)+1){
            String test2 =test;
            int diff = test2.length();
            int start=diff;
            int end = start + diff;
            while(end<=s.length()){
                if(test2.equals(s.substring(start,end))){
                    if(end == s.length() && test2.equals(s.substring(start,end))){
                        return true;
                    }
                    start=end;
                    end+=diff;
                }
                else{
                    break;
                }
            }

            index++;
            test=test+String.valueOf(s.charAt(index));
        }

        return false;
    }
}
//      Only works if string is repeated once
//    String test = String.valueOf(s.charAt(0));
//    int index=0;
//        while(test.length()<(s.length()/2)+1){
//        String test2 =test;
//        for(int i=0; i<s.length(); i+=test.length()){
//        test2+=test2;
//        if(test2.length()>s.length())
//        break;
//        if(test2.equals(s))
//        return true;
//        }
//        index++;
//        test=test+String.valueOf(s.charAt(index));
//        }
