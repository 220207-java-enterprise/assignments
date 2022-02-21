package com.revature.recurringWord;
import java.util.*;

public class Solution {
    public char recurringWord(String s) {
        List<Integer> countlist = new ArrayList<Integer>();
        for (int i =0; i<s.length(); i++){
            int count = 0;
            char c = s.charAt(i);
            for (int j=0; j<s.length(); j++){
                if (c == s.charAt(j)){
                    count++;
                }
            }
            countlist.add(count);
        }
        Integer max = Collections.max(countlist);
        //System.out.println(s.charAt(countlist.indexOf(max)));
        return s.charAt(countlist.indexOf(max));
    }
}
