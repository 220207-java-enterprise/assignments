package com.revature.recurringWordII;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String recurringWordII(String str) {
        Map<String, Integer> map = new HashMap<>();

        StringBuilder tempWord = new StringBuilder("");

        for(int i=0; i<str.length();i++){
            //if it is alphabet character, append into tempWord
            if (Character.isLetter(str.charAt(i)) || str.charAt(i)=='\''){
                tempWord.append(str.charAt(i));
            }else if (tempWord.length() != 0){
                //if it is not an alphabet character, and tempWord was not empty;
                //save the tempWord, and reset it as an empty string
                if(map.get(tempWord.toString()) == null){
                    map.put(tempWord.toString(), 1);
                }else{
                    map.put(tempWord.toString(),map.get(tempWord.toString())+1);
                }
                tempWord = new StringBuilder("");
            }
        }

        int maxCount=0;
        String ans = "";
        for (String key : map.keySet()){
            System.out.println(key + " " + map.get(key));
            if (map.get(key)>maxCount) {
                maxCount = map.get(key);
                ans = key;
            }
        }
        return ans;
    }
}
