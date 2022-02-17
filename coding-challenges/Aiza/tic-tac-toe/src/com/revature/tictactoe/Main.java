package com.revature.tictactoe;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] ttt= {{'X','X','X'},{'X','O','O'},{'O','X','O'}};
       // System.out.println(s.validateWin({{'X','X','X'},{'X','O','O'},{'O','X','O'}});
//	         System.out.println(s.validateWin(ttt[0][0]+ttt[0][1]+ttt[0][2]+
        System.out.print(s.validateWin(ttt));
        //or new Solution.validateWin(ttt);
//
    }
}
