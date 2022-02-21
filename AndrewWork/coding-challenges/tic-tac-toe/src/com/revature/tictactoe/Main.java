package com.revature.tictactoe;

public class Main {
    public static void main(String[] args) {
        Solution A = new Solution();
        char[][] board = {{'X', 'X', 'X'}, {'O', 'X', 'O'}, {'O', 'O', 'X'}};
        A.validateWin(board);
    }
}
