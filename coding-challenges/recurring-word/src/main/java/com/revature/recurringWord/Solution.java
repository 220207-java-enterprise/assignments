package com.revature.recurringWord;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public char recurringWord(String str) {
        //int count = frequency.containsKey(str.charAt(i))? frequency.get(str.charAt(i)) : 0;

        HashMap<Character, Integer> frequency = new HashMap<>();
        int max=0;
        char result=' ';

        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if (frequency.containsKey(c)){
                int count = frequency.get(str.charAt(i));
                frequency.put(c, ++count);
            } else{
                frequency.put(c, 1);
            }
            // gets max value inside frequency
            max = Collections.max(frequency.values());
        }

        // search for key with max counter value
        for (Map.Entry<Character, Integer> entry: frequency.entrySet()){
            if(entry.getValue()==max){
                result = entry.getKey();
            }
        }

        return result;
    }
}

