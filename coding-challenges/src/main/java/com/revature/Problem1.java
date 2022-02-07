package com.revature;

public class Problem1 {
    public int sumOfArray(int[] arr) {
        int sum = 0;

        for (int n : arr) {
            sum += n;
        }

        return sum;
    }
}
