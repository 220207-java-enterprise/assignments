package com.revature.recurringWord;

public class Solution {
    public char recurringWord(String str) {
        //char[] charsFound = new char[256];

        //create array to hold count for every ascii value (256 possible)
        int [] charsCount = new int[256];
        int size = str.length();

        //loop through and get a count of each character in the string
        for (int i=0; i<size; i++) {
            //convert value at i to ascii value by type casting
            int ascii = (int) str.charAt(i);
            //System.out.println("character found in ascii: " + ascii +
                    //" count at index before increment: " + charsCount[ascii]);
            //use converted ascii value to increment the character count there
            charsCount[ascii]++;
            //System.out.println(charsCount[i]);
        }

        int highestCount = -1;
        int highestCountIndex = -1;

        for (int i=0; i<256; i++) {
            if (charsCount[i] > highestCount) {
                highestCount = charsCount[i];
                highestCountIndex = i;
            }
        }
        System.out.println(highestCountIndex);
        System.out.println(highestCount);
        return (char) highestCountIndex;
    }
}
