package com.revature.recurringWord;

import java.util.ArrayList;

public class Solution {
    public char recurringWord(String str) {
        char[] myChars = str.toCharArray();
        ArrayList<Character> myList = new ArrayList<>();
        int[] numbers = new int[123];
        int highestChar = 0;
        int index = 0;

        for(char ch : myChars)
            myList.add(ch);

        myList.forEach(Character-> numbers[(int) Character] += 1);

        for (int i = 0; i < numbers.length; i++){
            if (numbers[i] > highestChar) {
                index = i;
                highestChar = numbers[i];
            }
        }
        return (char)index;
    }

}
