package com.revature.challenges;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int minIndex=0;
        int maxIndex=nums.length-1;
        int midIndex=nums.length/2;

        for(int i=0; i<nums.length/2; i++){
            /*System.out.println("i: "+ i);
            System.out.println("minIndex: "+ minIndex);
            System.out.println("maxIndex: "+ maxIndex);
            System.out.println("midIndex: "+ midIndex);*/
            if (nums[midIndex] == target){
                return midIndex;
            }
            if (target < nums[midIndex] && midIndex!=0){
                //target should be in the left half of the array
                maxIndex = midIndex-1;
                midIndex = midIndex/2;
            }else if (target > nums[midIndex] && midIndex+1<nums.length){
                //target should be in the right half of the array
                minIndex = midIndex+1;
                midIndex = minIndex + (maxIndex-midIndex)/2;
            }
        }
        /*System.out.println("minIndex: "+ minIndex);
        System.out.println("maxIndex: "+ maxIndex);
        System.out.println("midIndex: "+ midIndex);*/
        if(nums[midIndex] == target) return midIndex;
        else  if (target < nums[midIndex]) return midIndex;
        else if (target > nums[midIndex]) return  maxIndex+1;

        return -1;
    }
}

/*
Input: nums = [1,3,5,6], target = 5
        Output: 2

        1 2 3 4 5 6 7 8 9
*/
