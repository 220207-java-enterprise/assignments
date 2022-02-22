package com.revature.recurringWordII;

import java.util.HashMap;
import java.util.*;

public class Solution {
    public String recurringWordII(String str) {
        // hashmap that will keep count of words
        HashMap<String, Integer> frequency = new HashMap<>();

        // String array to store words
        String[] words;
        words = str.split(" ");


        int max=0;
        String result="";

        for (int i=0; i<words.length;i++){
            words[i] = words[i].replaceAll("[^a-zA-Z]","");

            // if hashmap already has the word
            if (frequency.containsKey(words[i])){
                int count = frequency.get(words[i]);
                frequency.put(words[i], ++count);
            } else{ // new word will have count of 1
                frequency.put(words[i], 1);
            }
            // gets max value inside frequency
            max = Collections.max(frequency.values());
        }

        // search for key with max counter value
        for (Map.Entry<String, Integer> entry: frequency.entrySet()){
            if(entry.getValue()==max){
                result = entry.getKey();
            }
        }

        return result;
    }

}
