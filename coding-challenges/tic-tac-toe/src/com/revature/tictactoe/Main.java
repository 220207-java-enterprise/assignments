package com.revature.tictactoe;

public class Main {
    public static void main(String[] args) {
        char[][] game = {{'X', 'X', 'X'}, {'O', 'X', 'O'}, {'O', 'O', 'X'}};
        Solution s1 = new Solution();
        System.out.println(s1.validateWin(game));
    }
}
