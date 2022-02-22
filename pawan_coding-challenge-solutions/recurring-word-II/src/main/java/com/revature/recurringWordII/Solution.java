package com.revature.recurringWordII;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String recurringWordII(String str) {

        String [] arr = str.split(" ");
        String mostRepeated = "";

        Map<String, Integer> map = new HashMap<>();

        if(str == null){
            throw new NullPointerException("Field cannot be a null value");
        }

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i]))
                map.put(arr[i], map.get(arr[i]) + 1);
            else
                map.put(arr[i], 1);

            mostRepeated = Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
        }
        return mostRepeated;
    }
}
