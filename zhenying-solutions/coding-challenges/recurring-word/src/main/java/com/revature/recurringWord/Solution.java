package com.revature.recurringWord;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public char recurringWord(String str) {
        Map<Character, Integer> map = new HashMap<>();

       for(int i=0; i<str.length();i++){
            if (map.get(str.charAt(i)) == null) {
                map.put(str.charAt(i), 1);
            }
            map.put(str.charAt(i),map.get(str.charAt(i))+1);
       }

       int maxCount=0;
       char ans = ' ';
       for (char key : map.keySet()){
           if (map.get(key)>maxCount) {
               maxCount = map.get(key);
               ans = key;
           }
       }
       return ans;
    }
}