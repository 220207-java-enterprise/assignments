package com.revature.app;

public class Solution {
    public String brackets(String s) {
        /* Write your code here */
        StringBuilder ans = new StringBuilder("");
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i) == '.'){
                ans.append("[.]");
            }else{
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }
}

/*
**Tasks**
1. Given a string
2. Put brackets around the period(s)

**Input**
* String = "abc.abc"

**Output**
* String = "abc[.]abc"

 */
