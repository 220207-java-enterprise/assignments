package com.revature.tictactoe;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        char [][] name = { {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g','h', 'i'} } ;
        for(int i = 0;  i < name.length; i++)
        System.out.println(s.validateWin(name));
    }
}
