package com.revature.recurringWord;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public char recurringWord(String str) {

        Map<Character, Integer> map = new HashMap<>();
        char repeatingChar = '\0';

        if (str == null)
            throw new NullPointerException("Null value not accepted");

        for (int i = 0; i < str.length(); i++) {

           repeatingChar  = str.charAt(i);

            if (map.containsKey(repeatingChar))
                map.put(repeatingChar, map.get(repeatingChar) + 1);
            else
                map.put(repeatingChar, 1);

            repeatingChar = Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
        }
        return repeatingChar;
    }
}
