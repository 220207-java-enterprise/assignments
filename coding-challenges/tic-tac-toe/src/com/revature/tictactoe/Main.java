package com.revature.tictactoe;

public class Main {
    public static void main(String[] args) {
        char[][] game = {{'O','O','O'},{'X','O','X'},{'O','X','X'}};
        Solution s1 = new Solution();
        System.out.println(s1.validateWin(game));
    }
}
