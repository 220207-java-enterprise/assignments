package com.revature.recurringWordII;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public String recurringWordII(String str) {
        String[] split = str.split(" ");
        ArrayList<String> myList = new ArrayList<>();
        int counter = 1, highestCount = 0;
        String current;
        String mostString = "";

        for(String s: split)
            myList.add(s);
        //System.out.println(myList + " " + myList.size());
        Collections.sort(myList);
        //System.out.println(myList + " " + myList.size());

        current = myList.get(0);
        for(int j = 1; j < myList.size();j++)
        {
            if (myList.get(j).equals(current)){
                //System.out.println(current + " " + myList.get(j));
                counter++;
            }
            else {
                //System.out.println(current + " " + myList.get(j));
                if (counter > highestCount) {
                    highestCount = counter;
                    mostString = myList.get(j-1);
                    //System.out.println(counter+ " " + mostString);
                }
                counter = 1;
                current = myList.get(j-1);
            }
        }
        return mostString;
    }
}
