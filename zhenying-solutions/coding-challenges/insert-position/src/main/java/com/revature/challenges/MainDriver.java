package com.revature.challenges;

public class MainDriver {
    public static void main(String[] args) {
        /* Use this to populate your Solution class */
        Solution sul = new Solution();

        //int ans = sul.searchInsert(new int[]{5,7, 8,11, 22,33, 44, 55},44);
        int ans = sul.searchInsert(new int[]{1, 3, 5, 6},7);
        System.out.println("Ans: "+ ans);
    }
}
