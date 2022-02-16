package com.revature.app;

public class Solution {
    public boolean recurringSubstring(String s) {
        return ((s + s).indexOf(s, 1) != s.length());
    }
}
